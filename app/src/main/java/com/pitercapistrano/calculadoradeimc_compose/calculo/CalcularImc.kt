package com.pitercapistrano.calculadoradeimc_compose.calculo

import java.text.DecimalFormat

class CalcularImc {

    private var resultadoImc: String = ""

    fun calcularImc(peso: String, altura: String){

        val pesoConvartido = peso.toDouble()
        val alturaConvertida = altura.toDouble()

        val resultado: String

        val imc = pesoConvartido / (alturaConvertida * alturaConvertida)
        val decimalFormat = DecimalFormat("0.00")

        // Verifica a faixa do IMC e define o texto e cor do resultado
        if (imc < 18.5) {
            resultado = "Peso Baixo\nIMC: ${decimalFormat.format(imc)}"
        } else if (imc <= 24.9) {
            resultado = "Peso Normal\nIMC: ${decimalFormat.format(imc)}"
        } else if (imc <= 29.9) {
            resultado = "Sobrepeso\nIMC: ${decimalFormat.format(imc)}"
        } else if (imc <= 34.9) {
            resultado = "Obesidade (Grau I)\nIMC: ${decimalFormat.format(imc)}"
        } else if (imc <= 39.9) {
            resultado = "Obesidade Severa (Grau II)\nIMC: ${decimalFormat.format(imc)}"
        } else {
            resultado = "Obesidade Mórbida (Grau III)\nIMC: ${decimalFormat.format(imc)}"
        }
        resultadoImc = resultado
    }

    fun resultadoImc(): String{
        return resultadoImc
    }
}