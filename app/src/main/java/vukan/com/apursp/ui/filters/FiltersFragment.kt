package vukan.com.apursp.ui.filters

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.firebase.Timestamp
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
    private lateinit var adapter1: ArrayAdapter<String?>

    companion object {
        val filters = arrayOfNulls<String>(6)
        private val c1 = Calendar.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.filters)
        cenaOd = view.findViewById(R.id.cenaOd)
        cenaDo = view.findViewById(R.id.cenaDo)
        val datumOd = view.findViewById<Button>(R.id.datumOd)
        val primeni = view.findViewById<Button>(R.id.primeni)
        opadajuce = view.findViewById(R.id.opadajuce)
        rastuce = view.findViewById(R.id.rastuce)
        val filtersViewModel = ViewModelProvider(this).get(FiltersViewModel::class.java)
        val spinner = view.findViewById<Spinner>(R.id.spinner)

        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.gradovi,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this
        kategorije = view.findViewById(R.id.kategorija)

        filtersViewModel.categories.observe(
            viewLifecycleOwner, { categories: List<ProductCategory?> ->
                this.categories = categories
                val list: MutableList<String?> = ArrayList()
                list.add(getString(R.string.sve))
                for (category in this.categories) list.add(category?.name)

                adapter1 =
                    ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, list)

                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                kategorije.onItemSelectedListener = this
                kategorije.adapter = adapter1
            })

        datumOd.setOnClickListener {
            val newFragment: DialogFragment = DatePickerFragment()
            newFragment.show(parentFragmentManager, "datumOd")
        }

        primeni.setOnClickListener {
            filters[0] = cenaOd.text.toString()
            filters[1] = cenaDo.text.toString()

            if (opadajuce.isChecked)
                filters[3] = "opadajuce"
            else if (rastuce.isChecked)
                filters[3] = "rastuce"

            val action = FiltersFragmentDirections.filteriToPocetnaFragmentAction()
            action.filters = filters
            Navigation.findNavController(requireView()).navigate(action)
        }
    }

    override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
        if (adapterView.id == R.id.spinner)
            filters[4] = adapterView.getItemAtPosition(i).toString()
        else {
            for (category in categories) {
                if (adapterView.getItemAtPosition(i).toString() == category?.name)
                    filters[5] = category.categoryID
            }
        }
    }

    override fun onNothingSelected(adapterView: AdapterView<*>?) {}

    class DatePickerFragment : DialogFragment(), OnDateSetListener {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val year: Int = c1[Calendar.YEAR]
            val month: Int = c1[Calendar.MONTH]
            val day: Int = c1[Calendar.DAY_OF_MONTH]
            return DatePickerDialog(requireActivity(), this, year, month, day)
        }

        override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
            val date = Timestamp(c1.time)
            c1[Calendar.YEAR] = year
            c1[Calendar.MONTH] = month
            c1[Calendar.DAY_OF_MONTH] = day
            filters[2] = date.seconds.toString()
        }
    }
}