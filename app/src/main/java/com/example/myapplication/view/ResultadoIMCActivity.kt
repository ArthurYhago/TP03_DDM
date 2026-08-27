package com.example.myapplication.view

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.dao.AlunoDao
import com.example.myapplication.dao.IMCDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ResultadoIMCActivity : AppCompatActivity(R.layout.activity_resultado_imcactivity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_volta)
        val txvIMC = findViewById<TextView>(R.id.txv_resultIMC)
        val txvFrase = findViewById<TextView>(R.id.txv_fraseIMC)
        val dao = IMCDao


        val peso = dao.buscar()?.peso?.toFloat()
        val altura = (dao.buscar()?.altura?.toFloat())
        val imc = peso!! / (altura!! * altura!!)

        var resultImc:String = ""
        if(18.5>imc && imc<24.9) {
            resultImc = "Peso Normal"
        } else if (imc<18.5){
            resultImc = "Abaixo do Peso"
        } else if (imc>25){
            resultImc = "Acima do Peso"
        }

        txvIMC.setText("Seu IMC é: ${imc}")
        txvFrase.setText("Você está: ${resultImc}")
        fabVolta.setOnClickListener {
            finish()
        }
    }
}