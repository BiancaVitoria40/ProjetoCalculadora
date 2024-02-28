package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var resultadoTextView: TextView



    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultadoTextView = findViewById(R.id.text_view_selected)


        binding.radioGroup.setOnCheckedChangeListener{ _, checkedId ->
            when(checkedId){
                binding.radioSoma.id -> {
                    performSoma()

                }
                binding.radioSubtracao.id -> {
                    performSubtracao()
                }
                binding.radioMultiplicacao.id -> {
                    performMultiplicacao()
                }
                else -> {
                    performDivisao()

                }

            }

        }

        binding.buttonCalcular.setOnClickListener{
            val n = binding.editText2.text.toString().toFloat()
            Toast.makeText(this, n.toString(), Toast.LENGTH_SHORT).show()
            binding.editText2.setText((n*-1).toString())
        }

    }


    private fun performSoma() {
        val valor1 = binding.editText2.text.toString().toFloatOrNull()
        val valor2 = binding.editText3.text.toString().toFloatOrNull()


        if (valor1 != null && valor2 != null) {
            val resultado = valor1 + valor2
            exibirResultado(resultado)
        } else {
            Toast.makeText(this, "Digite números válidos", Toast.LENGTH_SHORT).show()
        }

    }

    private fun performSubtracao() {
        val valor1 = binding.editText2.text.toString().toFloatOrNull()
        val valor2 = binding.editText3.text.toString().toFloatOrNull()

        if (valor1 != null && valor2 != null) {
            val resultado = valor1 - valor2
            exibirResultado(resultado)
        } else {
            Toast.makeText(this, "Digite números válidos", Toast.LENGTH_SHORT).show()
        }

    }

    private fun performMultiplicacao() {
        val valor1 = binding.editText2.text.toString().toFloatOrNull()
        val valor2 = binding.editText3.text.toString().toFloatOrNull()

        if (valor1 != null && valor2 != null) {
            val resultado = valor1 * valor2
            exibirResultado(resultado)
        } else {
            Toast.makeText(this, "Digite números válidos", Toast.LENGTH_SHORT).show()
        }


    }

    private fun performDivisao() {
        val valor1 = binding.editText2.text.toString().toFloatOrNull()
        val valor2 = binding.editText3.text.toString().toFloatOrNull()

        if (valor1 != null && valor2 != null) {
            val resultado = valor1 / valor2
            exibirResultado(resultado)
        } else {
            Toast.makeText(this, "Digite números válidos", Toast.LENGTH_SHORT).show()
        }


    }

    private fun exibirResultado(resultado: Float) {
        resultadoTextView.text = "Resultado: $resultado"


    }
}