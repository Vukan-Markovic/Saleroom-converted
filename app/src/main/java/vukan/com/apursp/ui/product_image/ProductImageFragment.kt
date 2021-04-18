package vukan.com.apursp.ui.product_image

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import vukan.com.apursp.GlideApp
import vukan.com.apursp.R
import vukan.com.apursp.firebase.Storage

class ProductImageFragment : Fragment() {
    private lateinit var slika: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        slika = view.findViewById(R.id.slika)
        val storage = Storage()

        if (arguments != null)
            GlideApp.with(slika.context)
                .load(storage.getProductImage(ProductImageFragmentArgs.fromBundle(requireArguments()).imageUrl))
                .into(slika)
    }
}