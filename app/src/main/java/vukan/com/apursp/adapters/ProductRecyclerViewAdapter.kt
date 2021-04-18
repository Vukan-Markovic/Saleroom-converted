package vukan.com.apursp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vukan.com.apursp.GlideApp
import vukan.com.apursp.R
import vukan.com.apursp.firebase.Storage
import vukan.com.apursp.models.Product
import vukan.com.apursp.repository.Repository
import java.util.*

class ProductRecyclerViewAdapter(private val listener: ListItemClickListener) :
    RecyclerView.Adapter<ProductRecyclerViewAdapter.ProductViewHolder>() {

    private val storage: Storage = Storage()
    private val repository: Repository = Repository()
    private var products: MutableList<Product> = ArrayList()
    private val productsCopy: MutableList<Product> = ArrayList()

    init {
        productsCopy.addAll(products)
    }

    fun setProducts(products: MutableList<Product>) {
        this.products = products
        productsCopy.clear()
        productsCopy.addAll(products)
    }

    fun filter(t: String) {
        var text = t
        products.clear()

        if (text.isEmpty())
            products.addAll(productsCopy)
        else {
            text = text.toLowerCase(Locale.ROOT)

            for (item in productsCopy) {
                if (item.name?.toLowerCase(Locale.ROOT)
                        ?.contains(text)!! || item.description?.toLowerCase(Locale.ROOT)
                        ?.contains(text)!!
                ) products.add(item)
            }
        }

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private val productName: TextView = itemView.findViewById(R.id.product_name)
        private val productImage: ImageView = itemView.findViewById(R.id.product_image)
        private val star: CheckBox = itemView.findViewById(R.id.star)

        init {
            productImage.setOnClickListener(this)
            star.setOnClickListener(this)
        }

        fun bind(index: Int) {
            productName.text = products[index].name

            GlideApp.with(productImage.context)
                .load(storage.getProductImage(products[index].homePhotoUrl.toString()))
                .useAnimationPool(false)
                .placeholder(R.drawable.ic_image)
                .dontAnimate()
                .into(productImage)

            repository.isFavourite(products[index].productID, star)
        }

        override fun onClick(v: View) {
            val i = bindingAdapterPosition
            if (v is ImageView) listener.onListItemClick(products[i].productID)
            else if (v is CheckBox) listener.onStarItemClick(products[i].productID, v)
        }
    }

    interface ListItemClickListener {
        fun onListItemClick(productID: String?)
        fun onStarItemClick(productID: String?, view: View?)
    }
}