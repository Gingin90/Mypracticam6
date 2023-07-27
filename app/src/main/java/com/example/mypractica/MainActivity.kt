package com.example.mypractica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mypractica.databinding.ActivityMainBinding

//[]Recycler view
//[]Room
//[] dao
//[] base datos
//[] entity
//[] crear interfaz
//[] fragmento listado
//[] fragmento agregar
//[] navigation
// **
class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}