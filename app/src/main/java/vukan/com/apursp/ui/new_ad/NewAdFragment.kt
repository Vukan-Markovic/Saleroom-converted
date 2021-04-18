package vukan.com.apursp.ui.new_ad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import vukan.com.apursp.R

class NewAdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_ad, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.new_ad)
        val textView = view.findViewById<TextView>(R.id.text_novioglas)
        textView.setText(R.string.title_novioglas)
        val mAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.fade)
        mAnimation.duration = 150
        val odeca = view.findViewById<ImageView>(R.id.odeca)
        val obuca = view.findViewById<ImageView>(R.id.obuca)
        val aksesoari = view.findViewById<ImageView>(R.id.aksesoari)
        val decije = view.findViewById<ImageView>(R.id.decije)
        val knjige = view.findViewById<ImageView>(R.id.knjige)
        val biljke = view.findViewById<ImageView>(R.id.biljke)
        val ljubimci = view.findViewById<ImageView>(R.id.ljubimci)
        val uredjenje = view.findViewById<ImageView>(R.id.uredjenje)
        val bicikl = view.findViewById<ImageView>(R.id.bicikl)
        val igracke = view.findViewById<ImageView>(R.id.igracke)
        val sport = view.findViewById<ImageView>(R.id.sport)
        val muzika = view.findViewById<ImageView>(R.id.muzika)
        val mobilni = view.findViewById<ImageView>(R.id.mobilni)
        val kompjuter = view.findViewById<ImageView>(R.id.kompjuter)
        val tehnika = view.findViewById<ImageView>(R.id.tehnika)

        odeca.setOnClickListener { v: View ->
            v.startAnimation(mAnimation)
            val action = NewAdFragmentDirections.noviOglasToNovioglasprozorFragmentAction()
            action.id = 1
            Navigation.findNavController(v).navigate(action)
        }

        obuca.setOnClickListener { v: View ->
            v.startAnimation(mAnimation)
            val action = NewAdFragmentDirections.noviOglasToNovioglasprozorFragmentAction()
            action.id = 2
            Navigation.findNavController(v).navigate(action)
        }

        aksesoari.setOnClickListener { v: View ->
            v.startAnimation(mAnimation)
            val action = NewAdFragmentDirections.noviOglasToNovioglasprozorFragmentAction()
            action.id = 3
            Navigation.findNavController(v).navigate(action)
        }

        decije.setOnClickListener { v: View ->
            v.startAnimation(mAnimation)
            val action = NewAdFragmentDirections.noviOglasToNovioglasprozorFragmentAction()
            action.id = 4
            Navigation.findNavController(v).navigate(action)
        }

        knjige.setOnClickListener { v: View ->
            v.startAnimation(mAnimation)
            val action = NewAdFragmentDirections.noviOglasToNovioglasprozorFragmentAction()
            action.id = 5
            Navigation.findNavController(v).navigate(action)
        }

        biljke.setOnClickListener { v: View ->
            v.startAnimation(mAnimation)
            val action = NewAdFragmentDirections.noviOglasToNovioglasprozorFragmentAction()
            action.id = 6
            Navigation.findNavController(v).navigate(action)
        }

        ljubimci.setOnClickListener { v: View ->
            v.startAnimation(mAnimation)
            val action = NewAdFragmentDirections.noviOglasToNovioglasprozorFragmentAction()
            action.id = 7
            Navigation.findNavController(v).navigate(action)
        }

        uredjenje.setOnClickListener { v: View ->
            v.startAnimation(mAnimation)
            val action = NewAdFragmentDirections.noviOglasToNovioglasprozorFragmentAction()
            action.id = 8
            Navigation.findNavController(v).navigate(action)
        }

        bicikl.setOnClickListener { v: View ->
            v.startAnimation(mAnimation)
            val action = NewAdFragmentDirections.noviOglasToNovioglasprozorFragmentAction()
            action.id = 9
            Navigation.findNavController(v).navigate(action)
        }

        igracke.setOnClickListener { v: View ->
            v.startAnimation(mAnimation)
            val action = NewAdFragmentDirections.noviOglasToNovioglasprozorFragmentAction()
            action.id = 10
            Navigation.findNavController(v).navigate(action)
        }

        sport.setOnClickListener { v: View ->
            v.startAnimation(mAnimation)
            val action = NewAdFragmentDirections.noviOglasToNovioglasprozorFragmentAction()
            action.id = 11
            Navigation.findNavController(v).navigate(action)
        }

        muzika.setOnClickListener { v: View ->
            v.startAnimation(mAnimation)
            val action = NewAdFragmentDirections.noviOglasToNovioglasprozorFragmentAction()
            action.id = 12
            Navigation.findNavController(v).navigate(action)
        }

        mobilni.setOnClickListener { v: View ->
            v.startAnimation(mAnimation)
            val action = NewAdFragmentDirections.noviOglasToNovioglasprozorFragmentAction()
            action.id = 13
            Navigation.findNavController(v).navigate(action)
        }

        kompjuter.setOnClickListener { v: View ->
            v.startAnimation(mAnimation)
            val action = NewAdFragmentDirections.noviOglasToNovioglasprozorFragmentAction()
            action.id = 14
            Navigation.findNavController(v).navigate(action)
        }

        tehnika.setOnClickListener { v: View ->
            v.startAnimation(mAnimation)
            val action = NewAdFragmentDirections.noviOglasToNovioglasprozorFragmentAction()
            action.id = 15
            Navigation.findNavController(v).navigate(action)
        }
    }
}