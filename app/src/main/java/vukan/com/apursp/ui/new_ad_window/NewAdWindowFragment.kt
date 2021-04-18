package vukan.com.apursp.ui.new_ad_window

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageMetadata
import com.google.firebase.storage.UploadTask
import vukan.com.apursp.GlideApp
import vukan.com.apursp.R
import vukan.com.apursp.firebase.Storage
import vukan.com.apursp.models.Product
import vukan.com.apursp.models.ProductImage
import vukan.com.apursp.ui.product.ProductViewModel
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.util.*

class NewAdWindowFragment : Fragment() {
    private lateinit var fiksna: CheckBox
    private lateinit var radioValutaGroup: RadioGroup
    private lateinit var radioCurrentButton: RadioButton
    private lateinit var imageView: ImageView
    private lateinit var imageView1: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var imageView3: ImageView
    private lateinit var imageView4: ImageView
    private lateinit var naslov: EditText
    private lateinit var cena: EditText
    private lateinit var opis: EditText
    private var counter = 0
    private var filePath: Uri? = null
    private var filePath1: Uri? = null
    private var filePath2: Uri? = null
    private lateinit var mAnimation: Animation
    private var productId = ""
    private var filePath3: Uri? = null
    private var filePath4: Uri? = null
    private var bitmap: Bitmap? = null
    private var bitmap1: Bitmap? = null
    private var bitmap2: Bitmap? = null
    private var firebaseStorage = Storage()
    private var bitmap3: Bitmap? = null
    private var bitmap4: Bitmap? = null
    private var uuid = ""
    private var category = 0
    private var productID = ""
    private var storageReference = FirebaseStorage.getInstance().reference
    private var newProduct: Product = Product()
    private var productImageList: MutableList<ProductImage> = mutableListOf()
    private lateinit var newAdWindowViewModel: NewAdWindowViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_ad_window, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.new_ad)

        val cameraActivityResultLauncher =
            registerForActivityResult(StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK && result.data != null && result.data?.extras != null && result.data?.extras!!["data"] != null) {
                    val slika = result.data?.extras!!["data"] as Bitmap?

                    when (counter) {
                        0 -> {
                            filePath = null
                            bitmap = slika
                            GlideApp.with(imageView.context).load(bitmap).into(imageView)
                        }
                        1 -> {
                            filePath1 = null
                            bitmap1 = slika
                            GlideApp.with(imageView1.context).load(bitmap1).into(imageView1)
                        }
                        2 -> {
                            filePath2 = null
                            bitmap2 = slika
                            GlideApp.with(imageView2.context).load(bitmap2).into(imageView2)
                        }
                        3 -> {
                            filePath3 = null
                            bitmap3 = slika
                            GlideApp.with(imageView3.context).load(bitmap3).into(imageView3)
                        }
                        4 -> {
                            filePath4 = null
                            bitmap4 = slika
                            GlideApp.with(imageView4.context).load(bitmap4).into(imageView4)
                        }
                    }

                    if (counter < 5) counter++
                }
            }

        productImageList = ArrayList()
        val fireUser = FirebaseAuth.getInstance().currentUser
        newAdWindowViewModel = ViewModelProvider(this).get(NewAdWindowViewModel::class.java)
        val productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        mAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.fade)
        mAnimation.duration = 150
        val btnChoose = view.findViewById<Button>(R.id.btn_choose)
        val btnChoosecam = view.findViewById<Button>(R.id.btn_choosecam)
        val btnAddNewProduct = view.findViewById<Button>(R.id.add_new_product)
        val btnDelete = view.findViewById<Button>(R.id.btn_deletephoto)
        imageView = view.findViewById(R.id.myImage)
        imageView1 = view.findViewById(R.id.myImage1)
        imageView2 = view.findViewById(R.id.myImage2)
        imageView3 = view.findViewById(R.id.myImage3)
        imageView4 = view.findViewById(R.id.myImage4)
        naslov = view.findViewById(R.id.naslov)
        cena = view.findViewById(R.id.cena)
        opis = view.findViewById(R.id.opis)
        fiksna = view.findViewById(R.id.fiksna)
        radioValutaGroup = view.findViewById(R.id.radiogroup)
        val selectedId = radioValutaGroup.checkedRadioButtonId
        radioCurrentButton = view.findViewById(selectedId)
        val radioDinButton = view.findViewById<RadioButton>(R.id.dinari)
        val radioEurButton = view.findViewById<RadioButton>(R.id.euri)

        radioDinButton.setOnClickListener {
            radioCurrentButton = view.findViewById(radioValutaGroup.checkedRadioButtonId)
        }

        radioEurButton.setOnClickListener {
            radioCurrentButton = view.findViewById(radioValutaGroup.checkedRadioButtonId)
        }

        if (arguments != null) {
            productId = NewAdWindowFragmentArgs.fromBundle(requireArguments()).productId

            if (productId != "0") {
                productViewModel.getProductDetails(productId)
                    .observe(viewLifecycleOwner, { product: Product? ->
                        naslov.setText(product?.name)
                        cena.setText(String.format("%s", product?.price))
                        opis.setText(product?.description)
                        if (product != null) fiksna.isChecked = product.fixPrice == true
                        newProduct.homePhotoUrl = product?.homePhotoUrl
                        category = product?.categoryID?.toInt()!!

                        if (product.currency == "Din")
                            radioDinButton.isChecked = true
                        else radioEurButton.isChecked = true

                        productViewModel.getProductImages(productId)
                            .observe(viewLifecycleOwner, { productImages: List<ProductImage> ->
                                counter = productImages.size
                                productImageList.addAll(productImages)

                                for (i in productImages.indices) {
                                    when (i) {
                                        0 -> GlideApp.with(imageView.context)
                                            .load(firebaseStorage.getProductImage(productImages[0].imageUrl.toString()))
                                            .into(imageView)
                                        1 -> GlideApp.with(imageView1.context)
                                            .load(firebaseStorage.getProductImage(productImages[1].imageUrl.toString()))
                                            .into(imageView1)
                                        2 -> GlideApp.with(imageView2.context)
                                            .load(firebaseStorage.getProductImage(productImages[2].imageUrl.toString()))
                                            .into(imageView2)
                                        3 -> GlideApp.with(imageView3.context)
                                            .load(firebaseStorage.getProductImage(productImages[3].imageUrl.toString()))
                                            .into(imageView3)
                                        else -> GlideApp.with(imageView4.context)
                                            .load(firebaseStorage.getProductImage(productImages[4].imageUrl.toString()))
                                            .into(imageView4)
                                    }
                                }
                            })
                    })
            }
        }

        btnAddNewProduct.setOnClickListener { view3: View ->
            if (opis.text.toString().trim { it <= ' ' }.isNotEmpty() && cena.text.toString()
                    .trim { it <= ' ' }.isNotEmpty() && naslov.text.toString().trim { it <= ' ' }
                    .isNotEmpty()
            ) {
                view3.startAnimation(mAnimation)

                if (productId != "0")
                    Toast.makeText(
                        activity,
                        R.string.azuriranje_proizvoda,
                        Toast.LENGTH_SHORT
                    ).show()

                if (counter > 0) {
                    if (filePath == null) uploadImageBitmap(bitmap) else uploadImage(filePath)
                    if (bitmap != null || filePath != null) newProduct.homePhotoUrl = uuid
                }

                val date = Date()
                newProduct.datetime = Timestamp(date)
                newProduct.categoryID = "2"
                newProduct.description = opis.text.toString()
                newProduct.name = naslov.text.toString()
                newProduct.price = cena.text.toString().toDouble()
                val l: Long = 0
                newProduct.seen = l
                newProduct.productID = "temp"
                newProduct.userID = fireUser?.uid
                newProduct.fixPrice = fiksna.isChecked
                newProduct.currency = radioCurrentButton.text.toString()

                if (arguments != null) {
                    category = NewAdWindowFragmentArgs.fromBundle(requireArguments()).id
                    if (category != 0) newProduct.categoryID = category.toString() + ""
                }

                productID = newAdWindowViewModel.addProduct(newProduct, productId)
                val pi = ProductImage(imageUrl = uuid, productID = productID)
                newAdWindowViewModel.addProductImage(pi)
                productImageList.add(pi)

                when (counter) {
                    2 -> {
                        if (filePath1 == null) uploadImageBitmap(bitmap1) else uploadImage(filePath1)
                        newAdWindowViewModel.addProductImage(addPI(uuid, productID))
                    }
                    3 -> {
                        if (filePath1 == null) uploadImageBitmap(bitmap1) else uploadImage(filePath1)
                        newAdWindowViewModel.addProductImage(addPI(uuid, productID))
                        if (filePath2 == null) uploadImageBitmap(bitmap2) else uploadImage(filePath2)
                        newAdWindowViewModel.addProductImage(addPI(uuid, productID))
                    }
                    4 -> {
                        if (filePath1 == null) uploadImageBitmap(bitmap1) else uploadImage(filePath1)
                        newAdWindowViewModel.addProductImage(addPI(uuid, productID))
                        if (filePath2 == null) uploadImageBitmap(bitmap2) else uploadImage(filePath2)
                        newAdWindowViewModel.addProductImage(addPI(uuid, productID))
                        if (filePath3 == null) uploadImageBitmap(bitmap3) else uploadImage(filePath3)
                        newAdWindowViewModel.addProductImage(addPI(uuid, productID))
                    }
                    5 -> {
                        if (filePath1 == null) uploadImageBitmap(bitmap1) else uploadImage(filePath1)
                        newAdWindowViewModel.addProductImage(addPI(uuid, productID))
                        if (filePath2 == null) uploadImageBitmap(bitmap2) else uploadImage(filePath2)
                        newAdWindowViewModel.addProductImage(addPI(uuid, productID))
                        if (filePath3 == null) uploadImageBitmap(bitmap3) else uploadImage(filePath3)
                        newAdWindowViewModel.addProductImage(addPI(uuid, productID))
                        if (filePath4 == null) uploadImageBitmap(bitmap4) else uploadImage(filePath4)
                        newAdWindowViewModel.addProductImage(addPI(uuid, productID))
                    }
                }

                Navigation.findNavController(view3)
                    .navigate(NewAdWindowFragmentDirections.novioglasprozorToPocetnaFragmentAction())
            } else Toast.makeText(activity, R.string.upozorenje, Toast.LENGTH_SHORT).show()
        }

        btnDelete.setOnClickListener { view4: View ->
            view4.startAnimation(mAnimation)
            deleteImage()
        }

        btnChoosecam.setOnClickListener { view5: View ->
            if (counter < 5) {
                view5.startAnimation(mAnimation)
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                cameraActivityResultLauncher.launch(
                    cameraIntent, ActivityOptionsCompat.makeCustomAnimation(
                        requireContext(),
                        R.anim.fade_in,
                        R.anim.fade_out
                    )
                )
            }
        }

        btnChoose.setOnClickListener { view6: View ->
            if (counter < 5) {
                view6.startAnimation(mAnimation)
                chooseImage()
            }
        }
    }

    private fun addPI(uuid: String?, productID: String?): ProductImage {
        val pi = ProductImage(imageUrl = uuid, productID = productID.toString())
        productImageList.add(pi)
        return pi
    }

    private fun deleteImage() {
        if (counter - 1 < productImageList.size) {
            newAdWindowViewModel.deleteProductImage(productImageList[counter - 1].imageUrl)
            productImageList.removeAt(counter - 1)
        }

        when (counter) {
            1 -> imageView.setImageBitmap(null)
            2 -> imageView1.setImageBitmap(null)
            3 -> imageView2.setImageBitmap(null)
            4 -> imageView3.setImageBitmap(null)
            5 -> imageView4.setImageBitmap(null)
        }

        counter--
        if (counter < 0) counter = 0
    }

    private fun chooseImage() {
        val galleryActivityResultLauncher = registerForActivityResult(
            StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null && result.data?.data != null) {
                try {
                    when (counter) {
                        0 -> {
                            filePath = result.data?.data

                            GlideApp.with(imageView.context)
                                .load(
                                    MediaStore.Images.Media.getBitmap(
                                        requireActivity().contentResolver,
                                        filePath
                                    )
                                )
                                .into(imageView)
                        }
                        1 -> {
                            filePath1 = result.data?.data

                            GlideApp.with(imageView1.context)
                                .load(
                                    MediaStore.Images.Media.getBitmap(
                                        requireActivity().contentResolver,
                                        filePath1
                                    )
                                )
                                .into(imageView1)
                        }
                        2 -> {
                            filePath2 = result.data?.data

                            GlideApp.with(imageView2.context)
                                .load(
                                    MediaStore.Images.Media.getBitmap(
                                        requireActivity().contentResolver,
                                        filePath2
                                    )
                                )
                                .into(imageView2)
                        }
                        3 -> {
                            filePath3 = result.data?.data

                            GlideApp.with(imageView3.context)
                                .load(
                                    MediaStore.Images.Media.getBitmap(
                                        requireActivity().contentResolver,
                                        filePath3
                                    )
                                )
                                .into(imageView3)
                        }
                        4 -> {
                            filePath4 = result.data?.data

                            GlideApp.with(imageView4.context)
                                .load(
                                    MediaStore.Images.Media.getBitmap(
                                        requireActivity().contentResolver,
                                        filePath4
                                    )
                                )
                                .into(imageView4)
                        }
                    }

                    if (counter < 5) counter++
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }

        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        galleryActivityResultLauncher.launch(
            Intent.createChooser(intent, getString(R.string.izaberite_sliku)),
            ActivityOptionsCompat.makeCustomAnimation(
                requireContext(),
                R.anim.fade_in,
                R.anim.fade_out
            )
        )
    }

    private fun uploadImage(fajl: Uri?) {
        if (fajl != null) {
            val progressDialog = ProgressDialog(context)
            progressDialog.setTitle(getString(R.string.oglas_naslov))
            progressDialog.show()
            uuid = UUID.randomUUID().toString()
            val ref = storageReference.child("$uuid.jpg")

            ref.putFile(fajl)
                .addOnSuccessListener {
                    progressDialog.dismiss()
                    Toast.makeText(activity, R.string.oglas_postavljen, Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e: Exception ->
                    progressDialog.dismiss()
                    Toast.makeText(
                        activity,
                        getString(R.string.greska) + e.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .addOnProgressListener { taskSnapshot: UploadTask.TaskSnapshot ->
                    val progress =
                        100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount

                    progressDialog.setMessage(getString(R.string.otpremljeno) + progress.toInt() + "%")
                }
        }
    }

    private fun uploadImageBitmap(fajl: Bitmap?) {
        if (fajl != null) {
            val progressDialog = ProgressDialog(context)
            progressDialog.setTitle(getString(R.string.oglas_naslov))
            progressDialog.show()
            uuid = UUID.randomUUID().toString()
            val ref = storageReference.child("$uuid.jpg")
            val baos = ByteArrayOutputStream()
            fajl.compress(Bitmap.CompressFormat.JPEG, 100, baos)

            ref.putBytes(
                baos.toByteArray(),
                StorageMetadata.Builder().setContentType("image/jpg").build()
            )
                .addOnSuccessListener {
                    progressDialog.dismiss()
                    Toast.makeText(
                        activity,
                        getString(R.string.oglas_postavljen),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .addOnFailureListener { e: Exception ->
                    progressDialog.dismiss()
                    Toast.makeText(
                        activity,
                        getString(R.string.greska) + e.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .addOnProgressListener { taskSnapshot: UploadTask.TaskSnapshot ->
                    val progress =
                        100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount

                    progressDialog.setMessage(getString(R.string.otpremljeno) + progress.toInt() + "%")
                }
        }
    }
}