package vukan.com.apursp.ui.product

import android.app.ActivityOptions
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.firebase.auth.FirebaseAuth
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import de.hdodenhof.circleimageview.CircleImageView
import vukan.com.apursp.GlideApp
import vukan.com.apursp.R
import vukan.com.apursp.adapters.ProductImageRecyclerViewAdapter
import vukan.com.apursp.models.Product
import vukan.com.apursp.models.ProductCategory
import vukan.com.apursp.models.ProductImage
import vukan.com.apursp.models.User
import java.text.SimpleDateFormat
import java.util.*

class ProductFragment : Fragment() {
    private lateinit var adapter: ProductImageRecyclerViewAdapter
    private var productID = "0"
    private lateinit var nazivProizvoda: TextView
    private lateinit var opisProizvoda: TextView
    private lateinit var cenaProizvoda: TextView
    private lateinit var vidjeno: TextView
    private lateinit var lokacija: TextView
    private lateinit var datumObjavljivanja: TextView
    private lateinit var poruke: Button
    private lateinit var pozovi: Button
    private lateinit var delete: AppCompatImageButton
    private lateinit var report: AppCompatImageButton
    private lateinit var edit: AppCompatImageButton
    private var phoneNumber: String? = ""
    private var userID: String? = ""
    private var fixPrice = ""
    private lateinit var mAdView: AdView
    private lateinit var sfd: SimpleDateFormat
    private lateinit var username: TextView
    private lateinit var userImage: CircleImageView
    private lateinit var productViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        if (arguments != null) {
            productID = ProductFragmentArgs.fromBundle(requireArguments()).productId
            if (productID != "0") productViewModel.incrementCounter(productID)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: SliderView = view.findViewById(R.id.recycler_view)
        adapter = ProductImageRecyclerViewAdapter(ArrayList())
        sfd = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        recyclerView.setSliderAdapter(adapter)
        recyclerView.setIndicatorAnimation(IndicatorAnimationType.WORM)
        recyclerView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        recyclerView.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        recyclerView.indicatorSelectedColor = R.color.primary_light
        recyclerView.indicatorUnselectedColor = R.color.colorPrimaryDark
        recyclerView.scrollTimeInSec = 4
        recyclerView.startAutoCycle()
        nazivProizvoda = view.findViewById(R.id.naziv_proizvoda)
        opisProizvoda = view.findViewById(R.id.opis_proizvoda)
        cenaProizvoda = view.findViewById(R.id.cena_proizvoda)
        datumObjavljivanja = view.findViewById(R.id.datum_objavljivanja)
        vidjeno = view.findViewById(R.id.vidjeno)
        poruke = view.findViewById(R.id.poruke)
        pozovi = view.findViewById(R.id.pozovi)
        userImage = view.findViewById(R.id.userImage)
        lokacija = view.findViewById(R.id.lokacija)
        username = view.findViewById(R.id.userName)
        delete = view.findViewById(R.id.delete)
        report = view.findViewById(R.id.report_product)
        edit = view.findViewById(R.id.edit)
        val mAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.fade)
        mAnimation.duration = 150

        delete.setOnClickListener {
            view.startAnimation(mAnimation)

            AlertDialog.Builder(requireContext())
                .setTitle(R.string.delete_product)
                .setMessage(R.string.confirm)
                .setPositiveButton(android.R.string.ok) { _: DialogInterface?, _: Int ->
                    Toast.makeText(requireActivity(), R.string.deleted, Toast.LENGTH_SHORT).show()
                    productViewModel.deleteProduct(productID)
                    requireActivity().onBackPressed()
                }
                .setNegativeButton(android.R.string.cancel, null)
                .setIcon(R.drawable.ic_delete)
                .show()
        }

        report.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle(R.string.report_ad)
                .setMessage(R.string.report_ad_confirm)
                .setPositiveButton(android.R.string.ok) { _: DialogInterface?, _: Int ->
                    productViewModel.reportAd(productID)
                    Toast.makeText(requireActivity(), R.string.ad_reported, Toast.LENGTH_SHORT)
                        .show()
                }
                .setNegativeButton(android.R.string.cancel, null)
                .setIcon(R.drawable.ic_report)
                .show()
        }

        edit.setOnClickListener { view1: View ->
            view1.startAnimation(mAnimation)
            val action = ProductFragmentDirections.proizvodToNoviOglasProzorFragmentAction()
            action.productId = productID
            Navigation.findNavController(view1).navigate(action)
        }

        userImage.setOnClickListener { view1: View ->
            view1.startAnimation(mAnimation)
            val action = ProductFragmentDirections.proizvodToMojiOglasiFragmentAction()
            action.userId = userID.toString()
            Navigation.findNavController(view1).navigate(action)
        }

        MobileAds.initialize(requireContext()) { }
        mAdView = view.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        poruke.setOnClickListener {
            val action = ProductFragmentDirections.proizvodToPorukeFragmentAction(null)
            action.productId = productID
            Navigation.findNavController(requireView()).navigate(action)
        }

        pozovi.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNumber")

            startActivity(
                intent, ActivityOptions.makeCustomAnimation(
                    requireContext(),
                    R.anim.fade_in,
                    R.anim.fade_out
                ).toBundle()
            )
        }

        productViewModel.getProductDetails(productID)
            .observe(viewLifecycleOwner, { product: Product? ->
                nazivProizvoda.text = product?.name
                opisProizvoda.text = product?.description

                productViewModel.getCategory(product?.categoryID)
                    .observe(viewLifecycleOwner, { category: ProductCategory? ->
                        requireActivity().title = category?.name
                    })

                fixPrice = if (product?.fixPrice == true) getString(R.string.fiksna_cena)
                else getString(R.string.dogovor)

                cenaProizvoda.text = String.format(
                    getString(R.string.cena) + ": %s %s, %s",
                    product?.price.toString(),
                    product?.currency,
                    fixPrice
                )

                datumObjavljivanja.text = String.format(
                    getString(R.string.objavljeno) + ": %s",
                    sfd.format(product?.datetime!!.toDate())
                )

                vidjeno.text = String.format(
                    getString(R.string.vidjeno) + ": %s " + getString(R.string.puta),
                    product.seen.toString()
                )

                if (product.userID != null) {
                    userID = product.userID

                    productViewModel.getProductUser(userID)
                        .observe(viewLifecycleOwner, { user: User? ->
                            username.text =
                                String.format(getString(R.string.objavio) + ": %s", user?.username)

                            phoneNumber = user?.phone

                            if (user?.location != null)
                                lokacija.text = String.format(
                                    getString(R.string.lokacija) + ": %s",
                                    user.location
                                ) else lokacija.visibility = View.INVISIBLE

                            if (user?.imageUrl?.isNotEmpty() == true) {
                                GlideApp.with(userImage.context)
                                    .load(user.imageUrl)
                                    .into(userImage)
                            }

                            if (phoneNumber == null) pozovi.visibility = View.INVISIBLE
                        })

                    if (userID == FirebaseAuth.getInstance().currentUser?.uid) {
                        poruke.visibility = View.INVISIBLE
                        pozovi.visibility = View.INVISIBLE
                        report.visibility = View.INVISIBLE
                        delete.visibility = View.VISIBLE
                        edit.visibility = View.VISIBLE
                    }
                }
            })

        productViewModel.getProductImages(productID)
            .observe(viewLifecycleOwner, { products: List<ProductImage> ->
                adapter = ProductImageRecyclerViewAdapter(products)
                recyclerView.setSliderAdapter(adapter)
            })
    }

    override fun onPause() {
        mAdView.pause()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        mAdView.resume()
    }

    override fun onDestroy() {
        mAdView.destroy()
        super.onDestroy()
    }
}