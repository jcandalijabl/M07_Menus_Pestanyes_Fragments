package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.myapplication.Data.Academic
import com.example.myapplication.Data.Laboral
import com.example.myapplication.Data.Personal
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var navigation: BottomNavigationView
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Faig que el primer fragment es mostri només d'executar l'aplicació
        val personal = Personal(
            nom = "Jan",
            cognom = "Candalija",
            dataNaixement = "02/06/2005",
            llocNaixement = "Girona"
        )
        val bundle = bundleOf("personal" to gson.toJson(personal))
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<PrimerFragment>(R.id.fragmentContainer, args = bundle)
        }


        navigation = findViewById(R.id.navMenu)

        // Faig l'onclick listener detectant ab quin item interactuo per mostrar-te un ragment o un altre
        navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.PrimerFragment-> {
                    val personal = Personal(
                        nom = "Jan",
                        cognom = "Candalija",
                        dataNaixement = "02/06/2005",
                        llocNaixement = "Girona"
                    )
                    val bundle = bundleOf(Personal.ARG_PERSONAL to gson.toJson(personal))
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<PrimerFragment>(R.id.fragmentContainer, args = bundle)
                    }
                    return@setOnItemSelectedListener true
                }
                R.id.SegonFragment-> {
                    val academic = Academic(
                        entitat = "Institut Rafael Campalans",
                        anys = "4 anys"
                    )
                    val bundle = bundleOf(Academic.ARG_ACADEMIC to gson.toJson(academic))
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<SegonFragment>(R.id.fragmentContainer, args = bundle)
                    }
                    return@setOnItemSelectedListener true
                }
                R.id.TercerFragment-> {
                    val laboral = Laboral(
                        tipusFeina = "Programador Android",
                        preiode = "8 anys"
                    )
                    val bundle = bundleOf(Laboral.ARG_LABORAL to gson.toJson(laboral))
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<TercerFragment>(R.id.fragmentContainer, args = bundle)
                    }
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}