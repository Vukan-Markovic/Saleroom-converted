package vukan.com.apursp.ui.my_ads

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.PopupMenu
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import vukan.com.apursp.GlideApp
import vukan.com.apursp.R
import vukan.com.apursp.adapters.CommentsAdapter
import vukan.com.apursp.adapters.ProductRecyclerViewAdapter
import vukan.com.apursp.models.Comment
import vukan.com.apursp.models.User
import java.io.IOException
import java.util.*

class MyAdsFragment : Fragment(), ProductRecyclerViewAdapter.ListItemClickListener {
    private lateinit var username: TextView
    private lateinit var location: TextView
    private lateinit var phone: TextView
    private lateinit var avatar: ImageView
    private lateinit var edit: Button
    private lateinit var rate: Button
    private lateinit var report: Button
    private lateinit var editUsername: EditText
    private lateinit var editLocation: EditText
    private lateinit var editPhone: EditText
    private lateinit var editLayout: ConstraintLayout
    private lateinit var save: Button
    private lateinit var cancel: Button
    private var currentUser: User? = null
    private lateinit var starGrade: RatingBar
    private var userID = ""
    private lateinit var commentLayout: ConstraintLayout
    private lateinit var commentBtn: Button
    private lateinit var comment: EditText
    private lateinit var butCanRate: Button
    private lateinit var adapter: ProductRecyclerViewAdapter
    private lateinit var adapter2: CommentsAdapter
    private lateinit var recikler: RecyclerView
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAnimation: Animation
    private lateinit var myAdsViewModel: MyAdsViewModel
    private lateinit var cameraActivityResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var galleryActivityResultLauncher: ActivityResultLauncher<Intent>
    private var selectedImageCamera: Bitmap? = null
    private var selectedImageGallery: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_ads, container, false)
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.my_profile)

        cameraActivityResultLauncher = registerForActivityResult(
            StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                Glide.with(this).load(
                    result.data?.extras?.get("data") as Bitmap?
                ).into(avatar)
                selectedImageCamera = result.data?.getParcelableExtra("data")
                selectedImageGallery = null
            }
        }

        galleryActivityResultLauncher = registerForActivityResult(
            StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        GlideApp.with(avatar.context).load(
                            ImageDecoder.decodeBitmap(
                                ImageDecoder.createSource(
                                    requireActivity().contentResolver,
                                    result.data?.data!!
                                )
                            )
                        ).into(avatar)
                    } else {
                        GlideApp.with(avatar.context).load(
                            MediaStore.Images.Media.getBitmap(
                                requireActivity().contentResolver, result.data?.data
                            )
                        ).into(avatar)
                    }

                } catch (e: IOException) {
                    e.printStackTrace()
                }
                selectedImageGallery = result.data?.data
                selectedImageCamera = null
            }
        }

        mAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.fade)
        mAnimation.duration = 150
        myAdsViewModel = ViewModelProvider(this).get(MyAdsViewModel::class.java)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(context, 2)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager
        adapter = ProductRecyclerViewAdapter(this)
        recyclerView.adapter = adapter
        val layoutManager2: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recikler = view.findViewById(R.id.recikler)
        recikler.layoutManager = layoutManager2
        adapter2 = CommentsAdapter(ArrayList())
        recikler.adapter = adapter2
        recyclerView.visibility = View.VISIBLE
        recikler.visibility = View.INVISIBLE
        avatar = view.findViewById(R.id.imageAvatar)
        if (arguments != null) userID = MyAdsFragmentArgs.fromBundle(requireArguments()).userId

        if (userID == "0") {
            val fireUser = FirebaseAuth.getInstance().currentUser
            userID = Objects.requireNonNull(fireUser).uid
        }

        avatar.setOnClickListener { view1: View ->
            view1.startAnimation(mAnimation)
            showPopUpMenu(view1)
        }

        avatar.isClickable = false
        username = view.findViewById(R.id.username)
        location = view.findViewById(R.id.location)
        phone = view.findViewById(R.id.phone)
        edit = view.findViewById(R.id.editButton)
        editUsername = view.findViewById(R.id.username_input)
        editLocation = view.findViewById(R.id.location_input)
        editPhone = view.findViewById(R.id.phone_input)
        editLayout = view.findViewById(R.id.edit_layout)
        save = view.findViewById(R.id.buttonSave)
        rate = view.findViewById(R.id.rateButton)
        report = view.findViewById(R.id.report_user)
        cancel = view.findViewById(R.id.buttonCancel)
        starGrade = view.findViewById(R.id.starGrades)
        commentLayout = view.findViewById(R.id.commentLayout)
        comment = view.findViewById(R.id.comment)
        butCanRate = view.findViewById(R.id.buttonCancelRate)
        commentBtn = view.findViewById(R.id.commentButton)

        myAdsViewModel.getUserRating(userID).observe(viewLifecycleOwner, { rating: Float? ->
            if (rating != null) starGrade.rating = rating
            currentUser?.grade = rating
        })

        myAdsViewModel.getUser(userID).observe(viewLifecycleOwner, { user: User? ->
            username.text = user?.username
            location.text = user?.location
            phone.text = user?.phone
            user?.userID = user?.userID

            GlideApp.with(avatar.context)
                .load(user?.imageUrl)
                .into(avatar)

            if (userID == FirebaseAuth.getInstance().currentUser?.uid) {
                edit.visibility = View.VISIBLE
                report.visibility = View.INVISIBLE
                rate.visibility = View.INVISIBLE
            }

            currentUser = user
        })

        myAdsViewModel.getUserProducts(userID).observe(viewLifecycleOwner, {
            adapter = ProductRecyclerViewAdapter(this)
            recyclerView.adapter = adapter
        })

        myAdsViewModel.getUserComments(userID)
            .observe(viewLifecycleOwner, { userComments: List<Comment> ->
                adapter2 = CommentsAdapter(userComments)
                recikler.adapter = adapter2
            })

        rate.setOnClickListener {
            rate.visibility = View.INVISIBLE
            recyclerView.visibility = View.INVISIBLE

            if (userID == FirebaseAuth.getInstance().currentUser?.uid)
                starGrade.setIsIndicator(true)
            else {
                commentLayout.visibility = View.VISIBLE
                comment.visibility = View.VISIBLE
                commentBtn.visibility = View.VISIBLE
                starGrade.rating = 0f
                starGrade.setIsIndicator(false)
            }

            butCanRate.visibility = View.VISIBLE
            recikler.visibility = View.VISIBLE
        }

        report.setOnClickListener { view1: View ->
            AlertDialog.Builder(requireContext())
                .setTitle(R.string.block_user)
                .setMessage(R.string.block_user_message)
                .setPositiveButton(android.R.string.ok) { _: DialogInterface?, _: Int ->
                    Toast.makeText(requireActivity(), R.string.user_blocked, Toast.LENGTH_SHORT)
                        .show()
                    myAdsViewModel.reportUser(userID)

                    Navigation.findNavController(view1)
                        .navigate(MyAdsFragmentDirections.mojioglasiToPocetnaFragmentAction())
                }
                .setNegativeButton(android.R.string.cancel, null)
                .setIcon(R.drawable.ic_report)
                .show()
        }

        butCanRate.setOnClickListener {
            recikler.visibility = View.INVISIBLE
            rate.visibility = View.VISIBLE
            recyclerView.visibility = View.VISIBLE
            starGrade.setIsIndicator(true)
            commentLayout.visibility = View.GONE
            comment.visibility = View.GONE
            commentBtn.visibility = View.GONE
            butCanRate.visibility = View.INVISIBLE
        }

        edit.setOnClickListener {
            recyclerView.visibility = View.INVISIBLE
            username.visibility = View.INVISIBLE
            phone.visibility = View.INVISIBLE
            rate.visibility = View.INVISIBLE
            location.visibility = View.INVISIBLE
            edit.visibility = View.INVISIBLE
            starGrade.visibility = View.INVISIBLE
            editUsername.setText(currentUser?.username)
            editLocation.setText(currentUser?.location)
            editPhone.setText(currentUser?.phone)
            editLayout.visibility = View.VISIBLE
            save.visibility = View.VISIBLE
            cancel.visibility = View.VISIBLE
            recikler.visibility = View.INVISIBLE
            avatar.isClickable = true
        }

        cancel.setOnClickListener {
            editLayout.visibility = View.INVISIBLE
            save.visibility = View.INVISIBLE
            cancel.visibility = View.INVISIBLE
            recyclerView.visibility = View.VISIBLE
            location.visibility = View.VISIBLE
            username.visibility = View.VISIBLE
            phone.visibility = View.VISIBLE
            edit.visibility = View.VISIBLE
            starGrade.visibility = View.VISIBLE
            rate.visibility = View.VISIBLE
            avatar.isClickable = false

            myAdsViewModel.getUser(userID).observe(
                viewLifecycleOwner,
                { (_, _, _, _, _, imageUrl) ->
                    GlideApp.with(avatar.context)
                        .load(imageUrl)
                        .into(avatar)
                })
        }

        save.setOnClickListener {
            myAdsViewModel.editUserInfo(
                User(
                    currentUser?.userID,
                    editUsername.text.toString(),
                    editLocation.text.toString(),
                    currentUser?.grade,
                    editPhone.text.toString(),
                    currentUser?.imageUrl
                )
            )

            if (selectedImageCamera != null) {
                myAdsViewModel.updateProfilePictureBitmap(selectedImageCamera)
                Toast.makeText(
                    requireContext(),
                    getString(R.string.profile_updated),
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (selectedImageGallery != null) {
                myAdsViewModel.updateProfilePicture(selectedImageGallery)
                Toast.makeText(
                    requireContext(),
                    getString(R.string.profile_updated),
                    Toast.LENGTH_SHORT
                ).show()
            }

            editLayout.visibility = View.INVISIBLE
            save.visibility = View.INVISIBLE
            starGrade.visibility = View.VISIBLE
            cancel.visibility = View.INVISIBLE
            recyclerView.visibility = View.VISIBLE
            location.visibility = View.VISIBLE
            username.visibility = View.VISIBLE
            phone.visibility = View.VISIBLE
            edit.visibility = View.VISIBLE
            avatar.isClickable = false

            myAdsViewModel.getUser(userID).observe(viewLifecycleOwner, { user: User? ->
                username.text = user?.username
                location.text = user?.location
                phone.text = user?.phone
                user?.userID = user?.userID

                GlideApp.with(avatar.context)
                    .load(user?.imageUrl)
                    .into(avatar)

                currentUser = user
            })
        }

        commentBtn.setOnClickListener {
            if (comment.text.toString().trim { it <= ' ' }.isEmpty())
                Toast.makeText(
                    requireActivity(),
                    R.string.comment_warning,
                    Toast.LENGTH_SHORT
                ).show()
            else {
                val fireUser = FirebaseAuth.getInstance().currentUser
                val fromUserID = fireUser?.uid

                val newComment =
                    Comment(fromUserID, userID, starGrade.rating, comment.text.toString())

                myAdsViewModel.addNewUserComment(newComment)
                commentLayout.visibility = View.GONE
                comment.visibility = View.GONE
                commentBtn.visibility = View.GONE
                starGrade.setIsIndicator(true)

                myAdsViewModel.getUserComments(userID)
                    .observe(viewLifecycleOwner, { userComments: List<Comment> ->
                        adapter2 = CommentsAdapter(userComments)
                        recikler.adapter = adapter2
                    })

                myAdsViewModel.getUserRating(userID)
                    .observe(viewLifecycleOwner, { rating: Float? ->
                        if (rating != null) starGrade.rating = rating
                        currentUser?.grade = rating
                    })
            }
        }
    }

    private fun showPopUpMenu(view: View) {
        val popupMenu = PopupMenu(requireContext(), view)
        popupMenu.inflate(R.menu.popup_menu)

        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            if (item.itemId == R.id.camera_upload) {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                cameraActivityResultLauncher.launch(
                    intent,
                    ActivityOptionsCompat.makeCustomAnimation(
                        requireContext(),
                        R.anim.fade_in,
                        R.anim.fade_out
                    )
                )
            } else if (item.itemId == R.id.file_upload) {
                val intent = Intent(Intent.ACTION_GET_CONTENT)
                intent.type = "image/*"

                galleryActivityResultLauncher.launch(
                    Intent.createChooser(
                        intent,
                        getString(R.string.choose_picture)
                    ),
                    ActivityOptionsCompat.makeCustomAnimation(
                        requireContext(),
                        R.anim.fade_in,
                        R.anim.fade_out
                    )
                )
            }

            true
        }

        popupMenu.show()
    }

    override fun onListItemClick(productID: String?) {
        val action = MyAdsFragmentDirections.mojioglasiToProizvodFragmentAction()
        if (productID != null) action.productId = productID
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun onStarItemClick(productID: String?, view: View?) {}
}