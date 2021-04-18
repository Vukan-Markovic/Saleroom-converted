package vukan.com.apursp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import vukan.com.apursp.R
import vukan.com.apursp.adapters.ProductRecyclerViewAdapter
import vukan.com.apursp.models.Product

class HomeFragment : Fragment(), ProductRecyclerViewAdapter.ListItemClickListener,
    OnRefreshListener {
    private lateinit var adapter: ProductRecyclerViewAdapter
    private lateinit var search: SearchView
    private lateinit var filters: Button
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var mSwipeRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.app_name)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        adapter = ProductRecyclerViewAdapter(this)
        recyclerView.adapter = adapter
        search = view.findViewById(R.id.searchView)
        filters = view.findViewById(R.id.filters)
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_container)
        mSwipeRefreshLayout.setOnRefreshListener(this)

        mSwipeRefreshLayout.setColorSchemeResources(
            R.color.colorPrimary,
            R.color.colorAccent,
            R.color.colorPrimary,
            android.R.color.holo_green_dark
        )

        filters.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(HomeFragmentDirections.pocetnaToFilteriFragmentAction())
        }

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                adapter.filter(query)
                recyclerView.adapter = adapter
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                adapter.filter(newText)
                recyclerView.adapter = adapter
                return true
            }
        })
    }

    override fun onResume() {
        super.onResume()

        mSwipeRefreshLayout.post {
            mSwipeRefreshLayout.isRefreshing = true
            loadRecyclerViewData()
        }
    }

    override fun onListItemClick(productID: String?) {
        search.setQuery("", false)
        search.clearFocus()
        val action = HomeFragmentDirections.pocetnaToProizvodFragmentAction()
        if (productID != null) action.productId = productID
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun onStarItemClick(productID: String?, view: View?) {
        val star = view as CheckBox

        if (star.isChecked) {
            star.background = ContextCompat.getDrawable(requireContext(), R.drawable.ic_star_border)
            homeViewModel.removeProductFromFavourites(productID.toString())
        } else {
            star.background = ContextCompat.getDrawable(requireContext(), R.drawable.ic_star)
            homeViewModel.addProductToFavourites(productID.toString())
        }
    }

    override fun onRefresh() {
        loadRecyclerViewData()
    }

    private fun loadRecyclerViewData() {
        mSwipeRefreshLayout.isRefreshing = true

        if (arguments != null && requireArguments().getStringArray("filters") != null) {
            homeViewModel.filterProducts(HomeFragmentArgs.fromBundle(requireArguments()).filters)
                .observe(viewLifecycleOwner, { products: MutableList<Product> ->
                    adapter.setProducts(products)
                    recyclerView.adapter = adapter
                    mSwipeRefreshLayout.isRefreshing = false

                    if (products.isEmpty()) Toast.makeText(
                        context,
                        R.string.no_results,
                        Toast.LENGTH_SHORT
                    ).show()
                })
        } else {
            homeViewModel.products.observe(viewLifecycleOwner, { products: MutableList<Product> ->
                adapter.setProducts(products)
                recyclerView.adapter = adapter
                mSwipeRefreshLayout.isRefreshing = false

                if (products.isEmpty()) Toast.makeText(
                    context,
                    R.string.no_results,
                    Toast.LENGTH_SHORT
                ).show()
            })
        }
    }
}