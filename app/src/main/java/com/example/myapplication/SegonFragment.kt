package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentSegonBinding

class SegonFragment : Fragment() {
    private var entitat: String? = null
    private var anys: String? = null

    private lateinit var binding: FragmentSegonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSegonBinding.inflate(layoutInflater)

        //A partir dels arguments rebuts, rebo els valor desats de dins i els guardo en les propietats
        arguments?.let {
            entitat = it.getString(ARG_ENTITAT)
            anys = it.getString(ARG_ANYS)
        }
        //Assigno el valor de les propietats al text de cada view
        binding.tvPrimerLayoutEntitat.text = entitat
        binding.tvPrimerLayoutAnys.text = anys
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    companion object {
        const val ARG_ENTITAT = "Entitat"
        const val ARG_ANYS = "Anys"
    }
}