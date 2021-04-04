package com.example.youtube

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.youtube.R.layout.activity_main)

        val bottomNav: BottomNavigationView = findViewById(com.example.youtube.R.id.bottomNavigationView)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

        supportFragmentManager.beginTransaction().replace(com.example.youtube.R.id.frag_container, HomeFragment()).commit()

    }

    private val navListener: BottomNavigationView.OnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
            var selectedFragment: Fragment?  = null
            val bottomSheet = BottomSheetDialog()
            when (item.itemId) {
                R.id.home -> selectedFragment = HomeFragment()
                com.example.youtube.R.id.explore-> selectedFragment = ExploreFragment()
                com.example.youtube.R.id.Add-> bottomSheet.show(supportFragmentManager, "exampleBottomSheet")
                com.example.youtube.R.id.subscriptions-> selectedFragment = SubscFragment()
                com.example.youtube.R.id.library-> selectedFragment = LibraryFragment()
            }
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction().replace(
                    com.example.youtube.R.id.frag_container, selectedFragment
                ).commit()
            }
            else {
                supportFragmentManager.beginTransaction().replace(
                    com.example.youtube.R.id.frag_container, HomeFragment()
                ).commit()
            }
            true
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(com.example.youtube.R.menu.topbar, menu)
        return true
    }
}