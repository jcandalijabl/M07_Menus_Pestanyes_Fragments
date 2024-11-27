package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Faig que el primer fragment es mostri només d'executar l'aplicació
        val bundle2 = bundleOf(
            PrimerFragment.ARG_NOM to "Jan",
            PrimerFragment.ARG_COGNOM to "Candalija",
            PrimerFragment.ARG_DATA_NAIXEMENT to "02/07/2005",
            PrimerFragment.ARG_LLOC_NAIXEMENT to "Girona"
        )
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<PrimerFragment>(R.id.fragmentContainer, args = bundle2)
        }

        navigation = findViewById(R.id.navMenu)

        // Faig l'onclick listener detectant ab quin item interactuo per mostrar-te un ragment o un altre
        navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.PrimerFragment-> {
                    val bundle = bundleOf(
                        // Utilitzant les constants públiques de la class asseguro utilitzar la mateixa key
                        PrimerFragment.ARG_NOM to "Jan",
                        PrimerFragment.ARG_COGNOM to "Candalija",
                        PrimerFragment.ARG_DATA_NAIXEMENT to "02/07/2005",
                        PrimerFragment.ARG_LLOC_NAIXEMENT to "Girona"
                    )
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<PrimerFragment>(R.id.fragmentContainer, args = bundle)
                    }
                    return@setOnItemSelectedListener true
                }
                R.id.SegonFragment-> {
                    val bundle = bundleOf(
                        // Utilitzant les constants públiques de la class asseguro utilitzar la mateixa key
                        SegonFragment.ARG_ENTITAT to "Institut Campalans",
                        SegonFragment.ARG_ANYS to "4 anys"
                    )
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<SegonFragment>(R.id.fragmentContainer, args = bundle)
                    }
                    return@setOnItemSelectedListener true
                }
                R.id.TercerFragment-> {
                    val bundle = bundleOf(
                        // Utilitzant les constants públiques de la class asseguro utilitzar la mateixa key
                        TercerFragment.ARG_TIPUS_FEINA to "Programador Android",
                        TercerFragment.ARG_PERIODE to "8 any"
                    )
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