package com.example.spotifylab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var fragmentContainer: FragmentContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottomNAV_bottomNavActivity)
        setListeners()
        setFragment(First_fragment())
    }

    private fun setListeners() {
        bottomNav.setOnItemSelectedListener{
            when(it.itemId){
                R.id.menu_option_home -> setFragment(First_fragment())
                R.id.menu_option_search -> setFragment(SecondFragment())
                R.id.menu_option_library -> setFragment(ThirdFragment())
            }
            true
        }
    }

    private fun setFragment(fragment: Fragment){
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer_buttonNavigation, fragment)
        }
    }
}

