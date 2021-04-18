package vukan.com.apursp

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.AuthUI.IdpConfig.*
import com.firebase.ui.auth.IdpResponse
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.auth.FirebaseUser
import vukan.com.apursp.ui.my_ads.MyAdsViewModel
import java.util.*

class MainActivity : AppCompatActivity() {
    private val mFirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var mAuthStateListener: AuthStateListener
    private var mFirebaseUser: FirebaseUser? = null
    private lateinit var myAdsViewModel: MyAdsViewModel
    private lateinit var sharedPref: SharedPreferences

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPref = getPreferences(MODE_PRIVATE)

        val activityResultLauncher =
            registerForActivityResult(StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == RESULT_OK) myAdsViewModel.addUser()
                if (IdpResponse.fromResultIntent(result.data) == null) finish()
            }

        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(navView, navController)
        myAdsViewModel = ViewModelProvider(this).get(MyAdsViewModel::class.java)
        val language = sharedPref.getString("language", "lang")
        if (language != null && language != "lang") setLocale(language, false)
        val theme = sharedPref.getString("theme", "light")

        if (theme != null && theme == "dark")
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        navController.addOnDestinationChangedListener { _: NavController?, destination: NavDestination, _: Bundle? ->
            if (destination.id == R.id.navigation_proizvodSlika) {
                supportActionBar?.hide()
                navView.visibility = View.GONE
            } else {
                supportActionBar?.show()
                navView.visibility = View.VISIBLE
            }
        }

        myAdsViewModel = ViewModelProvider(this).get(MyAdsViewModel::class.java)

        mAuthStateListener = AuthStateListener { firebaseAuth: FirebaseAuth ->
            mFirebaseUser = firebaseAuth.currentUser

            if (mFirebaseUser == null) {
                activityResultLauncher.launch(
                    AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setIsSmartLockEnabled(false, false)
                        .setAvailableProviders(
                            listOf(
                                FacebookBuilder().build(),
                                TwitterBuilder().build(),
                                GoogleBuilder().build()
                            )
                        )
                        .setLogo(R.mipmap.ic_launcher)
                        .build()
                )
            }
        }

        navView.menu.findItem(R.id.navigation_pocetna).title = getString(R.string.title_pocetna)
        navView.menu.findItem(R.id.navigation_omiljeni).title = getString(R.string.omiljeni)
        navView.menu.findItem(R.id.navigation_novioglas).title = getString(R.string.title_novioglas)
        navView.menu.findItem(R.id.navigation_obavestenja).title = getString(R.string.title_poruke)
        navView.menu.findItem(R.id.navigation_mojioglasi).title =
            getString(R.string.title_mojioglasi)
    }

    override fun onPause() {
        super.onPause()
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener)
    }

    override fun onResume() {
        super.onResume()
        mFirebaseAuth.addAuthStateListener(mAuthStateListener)
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.delete_account -> {
                AlertDialog.Builder(this)
                    .setTitle(R.string.delete_account)
                    .setMessage(R.string.confirm)
                    .setPositiveButton(android.R.string.ok) { _: DialogInterface?, _: Int ->
                        myAdsViewModel.deleteUserData(mFirebaseUser?.uid)
                        AuthUI.getInstance().delete(this).addOnCompleteListener {
                            Toast.makeText(
                                this,
                                R.string.account_deleted,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    .setNegativeButton(android.R.string.cancel, null)
                    .setIcon(R.drawable.ic_delete)
                    .show()
            }
            R.id.sign_out -> {
                AuthUI.getInstance().signOut(this).addOnCompleteListener {
                    Toast.makeText(
                        this,
                        R.string.signed_out,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            R.id.change_language -> {
                AlertDialog.Builder(this)
                    .setTitle(R.string.change_language)
                    .setMessage(R.string.choose_language)
                    .setPositiveButton(R.string.serbian) { _: DialogInterface?, _: Int ->
                        setLocale(
                            "sr",
                            true
                        )
                    }
                    .setNegativeButton(R.string.english) { _: DialogInterface?, _: Int ->
                        setLocale(
                            "en",
                            true
                        )
                    }
                    .setIcon(R.drawable.ic_language)
                    .show()
            }
            R.id.change_theme -> {
                AlertDialog.Builder(this)
                    .setTitle(R.string.change_theme)
                    .setMessage(R.string.choose_theme)
                    .setPositiveButton(R.string.dark) { _: DialogInterface?, _: Int ->
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        saveTheme("dark")
                    }
                    .setNegativeButton(R.string.light) { _: DialogInterface?, _: Int ->
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                        saveTheme("light")
                    }
                    .setIcon(R.drawable.ic_color)
                    .show()
            }
            R.id.privacy_policy -> {
                openWebPage("https://sites.google.com/view/saleroom-privacy-policy")
            }
            R.id.terms_and_conditions -> {
                openWebPage("https://sites.google.com/view/saleroom-terms-conditions")
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }

        return true
    }

    private fun openWebPage(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun saveTheme(data: String) {
        val editor = sharedPref.edit()
        editor.putString("theme", data)
        editor.apply()
        recreate()
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    fun setLocale(langCode: String, flag: Boolean) {
        val editor = sharedPref.edit()
        editor.putString("language", langCode)
        editor.apply()
        val res = resources
        val conf = res.configuration
        conf.setLocale(Locale(langCode))
        res.updateConfiguration(conf, res.displayMetrics)
        if (flag) recreate()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}