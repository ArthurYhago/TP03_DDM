package com.example.myapplication.view

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.dao.AlunoDao
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text

class AlunoActivity : AppCompatActivity(R.layout.activity_aluno) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txvNomeAluno = findViewById<TextView>(R.id.txv_nomeAluno)
        val txvTurmaAluno = findViewById<TextView>(R.id.txv_turma)
        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_volta)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fab_avancaTP)
        val dao = AlunoDao
        txvNomeAluno.setText("Nome: ${dao.buscar()?.nome}")
        txvTurmaAluno.setText("Turma: ${dao.buscar()?.turma}")
        fabAvanca.setOnClickListener {
            val intent = Intent(this, IMCActivity::class.java)
            startActivity(intent)
        }
        fabVolta.setOnClickListener{
            finish()
        }
    }
}