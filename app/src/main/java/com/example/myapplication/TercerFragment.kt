package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.Data.Laboral
import com.example.myapplication.databinding.FragmentTercerBinding
import com.google.gson.Gson

class TercerFragment : Fragment() {
    private var laboral: Laboral? = null
    private val gson = Gson()

    private lateinit var binding: FragmentTercerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentTercerBinding.inflate(layoutInflater)
        var laboralJsonString: String? = null

        //A partir dels arguments rebuts, rebo els valor desats de dins i els guardo en les propietats
        arguments?.let {
            laboralJsonString = it.getString(Laboral.ARG_LABORAL)
        }
        //Assigno el valor de les propietats al text de cada view
        if (!laboralJsonString.isNullOrEmpty()) {
            laboral = gson.fromJson(laboralJsonString, Laboral::class.java)
            if (laboral != null) {
                binding.tvPrimerLayoutPeriode.text = laboral!!.preiode
                binding.tvPrimerLayoutTipusFeina.text = laboral!!.tipusFeina
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}