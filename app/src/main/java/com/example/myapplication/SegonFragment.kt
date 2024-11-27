package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.Data.Academic
import com.example.myapplication.databinding.FragmentSegonBinding
import com.google.gson.Gson

class SegonFragment : Fragment() {
    private var academic: Academic? = null
    private val gson = Gson()

    private lateinit var binding: FragmentSegonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSegonBinding.inflate(layoutInflater)
        var academicJsonString: String? = null

        //A partir dels arguments rebuts, rebo els valor desats de dins i els guardo en les propietats
        arguments?.let {
             academicJsonString = it.getString(Academic.ARG_ACADEMIC)
        }
        //Assigno el valor de les propietats al text de cada view
        if (!academicJsonString.isNullOrEmpty()) {
            academic = gson.fromJson(academicJsonString, Academic::class.java)
            if (academic != null) {
                binding.tvPrimerLayoutAnys.text = academic!!.anys
                binding.tvPrimerLayoutEntitat.text = academic!!.entitat
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