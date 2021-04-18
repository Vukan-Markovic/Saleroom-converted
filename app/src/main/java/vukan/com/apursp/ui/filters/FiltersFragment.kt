package vukan.com.apursp.ui.filters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import vukan.com.apursp.R
import vukan.com.apursp.models.ProductCategory
import java.util.*

class FiltersFragment : Fragment(), OnItemSelectedListener {
    private lateinit var cenaOd: TextView
    private lateinit var cenaDo: TextView
    private lateinit var kategorije: Spinner
    private lateinit var opadajuce: RadioButton
    private lateinit var rastuce: RadioButton
    private lateinit var categories: List<ProductCategory?>
    private lateinit var adapter: ArrayAdapter<String?>

    companion object {
        var filters = arrayOfNulls<String>(6)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filters, container, false)
    }

    override fun onResume() {
        super.onResume()
        filters = arrayOfNulls(4)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.filters)
        cenaOd = view.findViewById(R.id.cenaOd)
        cenaDo = view.findViewById(R.id.cenaDo)
        val primeni = view.findViewById<Button>(R.id.primeni)
        opadajuce = view.findViewById(R.id.opadajuce)
        rastuce = view.findViewById(R.id.rastuce)
        val filtersViewModel = ViewModelProvider(this).get(FiltersViewModel::class.java)
        kategorije = view.findViewById(R.id.kategorija)

        filtersViewModel.categories.observe(
            viewLifecycleOwner, { categories: List<ProductCategory?> ->
                this.categories = categories
                val list: MutableList<String?> = ArrayList()
                list.add(getString(R.string.sve))
                for (category in this.categories) list.add(category?.name)

                adapter =
                    ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, list)

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                kategorije.onItemSelectedListener = this
                kategorije.adapter = adapter
            })

        primeni.setOnClickListener {
            if (cenaOd.text.toString().isNotEmpty() && cenaDo.text.toString()
                    .isNotEmpty() && cenaOd.text.toString().toInt() > cenaDo.text.toString().toInt()
            ) {
                Toast.makeText(context, R.string.invalid_prices, Toast.LENGTH_SHORT).show()
            } else {
                if (cenaOd.text.toString().isNotEmpty())
                    filters[0] = cenaOd.text.toString()

                if (cenaDo.text.toString().isNotEmpty())
                    filters[1] = cenaDo.text.toString()

                if (opadajuce.isChecked)
                    filters[2] = "opadajuce"
                else if (rastuce.isChecked)
                    filters[2] = "rastuce"

                val action = FiltersFragmentDirections.filteriToPocetnaFragmentAction()
                action.filters = filters
                Navigation.findNavController(requireView()).navigate(action)
            }
        }
    }

    override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        for (category in categories) {
            if (adapterView.getItemAtPosition(i).toString() == category?.name)
                filters[3] = category.categoryID
        }
    }

    override fun onNothingSelected(adapterView: AdapterView<*>?) {}
}