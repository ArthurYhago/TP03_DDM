package com.example.myapplication.dao

import com.example.myapplication.model.Aluno

class AlunoDao {
    companion object { //deixa estático para passar ele posteriormente (pertence a classe e não ao objeto)
        private var aluno: Aluno? = null
        fun salvar(nome:String, turma:String) {
            aluno = Aluno(nome,turma)
        }
        fun buscar():Aluno? {
            return aluno
        }
    }

}
