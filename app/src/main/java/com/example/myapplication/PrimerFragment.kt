package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentPrimerBinding

class PrimerFragment : Fragment() {
    private var nom: String? = null
    private var cognom: String? = null
    private var dataNaixement: String? = null
    private var llocNaixement: String? = null

    lateinit var binding: FragmentPrimerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPrimerBinding.inflate(layoutInflater)

        //A partir dels arguments rebuts, rebo els valor desats de dins i els guardo en les propietats
        arguments?.let {
            nom = it.getString(ARG_NOM)
            cognom = it.getString(ARG_COGNOM)
            dataNaixement = it.getString(ARG_DATA_NAIXEMENT)
            llocNaixement = it.getString(ARG_LLOC_NAIXEMENT)
        }
        //Assigno el valor de les propietats al text de cada view
        binding.tvPrimerLayoutNom.text = nom
        binding.tvPrimerLayoutCognom.text = cognom
        binding.tvPrimerLayoutDataNaixement.text = dataNaixement
        binding.tvPrimerLayoutLlocNaixement.text = llocNaixement
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return binding.root
    }

    companion object {
        const val ARG_NOM = "Nom"
        const val ARG_COGNOM = "Cognom"
        const val ARG_DATA_NAIXEMENT = "DataNaixement"
        const val ARG_LLOC_NAIXEMENT = "LlocNaixement"
    }
}