package com.example.myapplication.view

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.dao.AlunoDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity() : AppCompatActivity(R.layout.activity_main), Parcelable {

    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtNomeAluno = findViewById<EditText>(R.id.edt_nomeAluno)
        val edtTurmaAluno = findViewById<EditText>(R.id.edt_turmaAluno)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fab_avanca)
        val dao = AlunoDao

        btnSalvar.setOnClickListener {
            val nomeAluno = edtNomeAluno.text.toString()
            val TurmaAluno = edtTurmaAluno.text.toString()
            AlunoDao.salvar(nomeAluno, TurmaAluno)
            Log.d("ESTADO", "SALVO")
            edtNomeAluno.setText("")
            edtTurmaAluno.setText("")
        }
        fabAvanca.setOnClickListener {
            val intent = Intent(this, AlunoActivity::class.java)
            startActivity(intent)
        }
    }
}


