package com.example.tabuadakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var lblNum1:TextView
    lateinit var lblNum2:TextView
    lateinit var txtNumInformado: EditText
    lateinit var ratingBar:RatingBar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lblNum1 = findViewById(R.id.txtnum1)
        lblNum2 = findViewById(R.id.txtnum2)

        lblNum1.text = Random.nextInt(1,9).toString()
        lblNum2.text = Random.nextInt(1,9).toString()


    }

    fun iniciar_OnClick(view: View){
        lblNum1 = findViewById(R.id.txtnum1)
        lblNum2 = findViewById(R.id.txtnum2)
        txtNumInformado = findViewById(R.id.txtNumInformado)

        var resultado = lblNum1.text.toString().toInt() * lblNum2.text.toString().toInt()

        if(resultado == txtNumInformado.text.toString().toInt()){
            //acertou
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Resultado")
            builder.setMessage("Acertou!")
            builder.setNeutralButton("OK") { dialog, which -> dialog.cancel() }
            builder.show()
            lblNum1.text = Random.nextInt(1,9).toString()
            lblNum2.text = Random.nextInt(1,9).toString()
            atualizaRating(1)
        }else{
            //errou
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Resultado")
            builder.setMessage("Errou...")
            builder.setNeutralButton("OK") { dialog, which -> dialog.cancel() }
            builder.show()
            atualizaRating(0)

        }
        txtNumInformado.text.clear()
    }


    fun atualizaRating(acertou:Int){
        ratingBar = findViewById(R.id.ratingBar)
        if(acertou==1){
            if(ratingBar.rating<5){
                ratingBar.rating = ratingBar.rating + 1
            }else{
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Vencedor")
                builder.setMessage("Reiniciando o jogo")
                builder.setNeutralButton("OK") { dialog, which -> dialog.cancel() }
                builder.show()
                ratingBar.rating = 0F

            }
        }else{
            if(ratingBar.rating>0){
                ratingBar.rating = ratingBar.rating -1
            }

        }

    }
}