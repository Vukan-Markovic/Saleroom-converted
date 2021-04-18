package vukan.com.apursp.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import vukan.com.apursp.R
import vukan.com.apursp.adapters.ProductRecyclerViewAdapter

class FavoritesFragment : Fragment(), ProductRecyclerViewAdapter.ListItemClickListener {
    private lateinit var adapter: ProductRecyclerViewAdapter
    private lateinit var favoritesViewModel: FavoritesViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.favorites)
        favoritesViewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view_omiljeni)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager
        adapter = ProductRecyclerViewAdapter(this)
        recyclerView.adapter = adapter
        products
    }

    override fun onListItemClick(productID: String?) {
        val action = FavoritesFragmentDirections.omiljeniToProizvodFragmentAction()
        if (productID != null) action.productId = productID
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun onStarItemClick(productID: String?, view: View?) {
        favoritesViewModel.removeProductFromFavourites(productID)
        products
    }

    private val products: Unit
        get() {
            favoritesViewModel.favouriteProducts.observe(viewLifecycleOwner) { products ->
                adapter.setProducts(products)
                recyclerView.adapter = adapter
            }
        }
}