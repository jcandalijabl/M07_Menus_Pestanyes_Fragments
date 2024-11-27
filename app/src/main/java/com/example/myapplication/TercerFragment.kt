package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentTercerBinding

class TercerFragment : Fragment() {
    private var tipusFeina: String? = null
    private var periode: String? = null

    private lateinit var binding: FragmentTercerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentTercerBinding.inflate(layoutInflater)

        //A partir dels arguments rebuts, rebo els valor desats de dins i els guardo en les propietats
        arguments?.let {
            tipusFeina = it.getString(ARG_TIPUS_FEINA)
            periode = it.getString(ARG_PERIODE)
        }
        //Assigno el valor de les propietats al text de cada view
        binding.tvPrimerLayoutPeriode.text = periode
        binding.tvPrimerLayoutTipusFeina.text = tipusFeina
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    companion object {
        const val ARG_TIPUS_FEINA = "Feina"
        const val ARG_PERIODE = "Periode"
    }
}