package com.example.myapplication.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Domain.Location
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import java.util.ArrayList

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initLocation()
    }

    private fun initLocation() {
        val myRef: DatabaseReference = database.getReference("Location")
        val list: ArrayList<Location> = ArrayList()
        //1:29:24

    }

}