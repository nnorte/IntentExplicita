package com.nnorte.appintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    //Apresenta os dados Ja processados no Snackbar
    fun calculadoraIdade(view: View){

        Snackbar.make(view,calculo(),Snackbar.LENGTH_INDEFINITE).show()
    }

    //Passa os dados processados para a segunda actividade
    
    fun calcularUsandoIntent(view: View){

        val intencoes = Intent(this,SegundaActivity::class.java)

        intencoes.putExtra("resultado",calculo())
        startActivity(intencoes)
    }

    // Metodo que recebe Informações digitadas pelo utilizador e processa
    fun calculo():String{
        val nomeCompleto = ed_nome_completo.text.toString()
        val anoNascimento = ed_anoNascimento.text.toString().toInt()
        val anoActual = Calendar.getInstance().get(Calendar.YEAR)

        return "$nomeCompleto tens ${anoActual-anoNascimento} anos"
    }
}
