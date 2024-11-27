package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.Data.Personal
import com.example.myapplication.databinding.FragmentPrimerBinding
import com.google.gson.Gson

class PrimerFragment : Fragment() {
    private var personal: Personal? = null
    val gson = Gson()

    lateinit var binding: FragmentPrimerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPrimerBinding.inflate(layoutInflater)
        var personalJsonString: String? = null

        //A partir dels arguments rebuts, rebo els valor desats de dins i els guardo en les propietats
        arguments?.let {
            personalJsonString = it.getString(Personal.ARG_PERSONAL)
        }
        //Assigno el valor de les propietats al text de cada view
        if (!personalJsonString.isNullOrEmpty()) {
            personal = gson.fromJson(personalJsonString, Personal::class.java)
            if (personal != null) {
                binding.tvPrimerLayoutNom.text = personal!!.nom
                binding.tvPrimerLayoutCognom.text = personal!!.cognom
                binding.tvPrimerLayoutDataNaixement.text = personal!!.dataNaixement
                binding.tvPrimerLayoutLlocNaixement.text = personal!!.llocNaixement
            }
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return binding.root
    }
}