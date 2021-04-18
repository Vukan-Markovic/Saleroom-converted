package vukan.com.apursp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import com.smarteist.autoimageslider.SliderViewAdapter
import vukan.com.apursp.GlideApp
import vukan.com.apursp.R
import vukan.com.apursp.firebase.Storage
import vukan.com.apursp.models.ProductImage
import vukan.com.apursp.ui.product.ProductFragmentDirections

class ProductImageRecyclerViewAdapter(private val products: List<ProductImage>) :
    SliderViewAdapter<ProductImageRecyclerViewAdapter.ProductViewHolder>() {

    private val storage: Storage = Storage()

    override fun onCreateViewHolder(parent: ViewGroup): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_image, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(position)

        holder.itemView.setOnClickListener { view: View ->
            val action = ProductFragmentDirections.proizvodToSlikaFragmentAction()
            action.imageUrl = products[position].imageUrl.toString()
            Navigation.findNavController(view).navigate(action)
        }
    }

    override fun getCount(): Int {
        return products.size
    }

    inner class ProductViewHolder(itemView: View) : ViewHolder(itemView) {
        private val productImage: ImageView = itemView.findViewById(R.id.slika_proizvoda)

        fun bind(index: Int) {
            GlideApp.with(productImage.context)
                .load(storage.getProductImage(products[index].imageUrl.toString()))
                .into(productImage)
        }
    }
}