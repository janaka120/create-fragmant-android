package com.example.firstfragmentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    lateinit var replaceBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        val firstFragment = FirstFragment()
        fragmentTransaction.add(R.id.frame, firstFragment)
        fragmentTransaction.commit()

        replaceBtn = findViewById(R.id.buttonReplace)

        replaceBtn.setOnClickListener {
            val secondFragmentManager: FragmentManager = supportFragmentManager
            val secondFragmentTransaction: FragmentTransaction = secondFragmentManager.beginTransaction()
            val secondFragment = SecondFragment()

            secondFragmentTransaction.addToBackStack(null)

            secondFragmentTransaction.replace(R.id.frame, secondFragment)
            secondFragmentTransaction.commit()
        }
    }
}