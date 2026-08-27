package com.example.myapplication.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.dao.AlunoDao
import com.example.myapplication.dao.IMCDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class IMCActivity : AppCompatActivity(R.layout.activity_imcactivity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtPeso = findViewById<EditText>(R.id.edt_peso)
        val edtAltura= findViewById<EditText>(R.id.edt_altura)
        val btnSalvar = findViewById<Button>(R.id.btn_salvarIMC)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fab_avancaIMC)
        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_volta)
        val dao = IMCDao

        btnSalvar.setOnClickListener {
            val peso = edtPeso.text.toString()
            val altura = edtAltura.text.toString()
            IMCDao.salvar(peso, altura)
            Log.d("ESTADO", "SALVO")
            edtPeso.setText("")
            edtAltura.setText("")
        }
        fabAvanca.setOnClickListener {
            val intent = Intent(this, ResultadoIMCActivity::class.java)
            startActivity(intent)
        }
        fabVolta.setOnClickListener {
            finish()
        }
    }
}