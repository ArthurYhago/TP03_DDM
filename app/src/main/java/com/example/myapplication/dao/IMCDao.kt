package com.example.myapplication.dao

import com.example.myapplication.model.Aluno

class IMCDao (val peso:String, val altura: String) {
    companion object { //deixa estático para passar ele posteriormente (pertence a classe e não ao objeto)
        private var imc: IMCDao? = null
        fun salvar(peso: String, altura: String) {
            imc = IMCDao(peso, altura)
        }

        fun buscar(): IMCDao? {
            return imc
        }
    }
}