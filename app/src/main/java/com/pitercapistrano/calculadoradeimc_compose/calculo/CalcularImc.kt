package com.pitercapistrano.calculadoradeimc_compose.calculo

import androidx.compose.ui.graphics.Color
import com.pitercapistrano.calculadoradeimc_compose.ui.theme.Bege
import com.pitercapistrano.calculadoradeimc_compose.ui.theme.Black
import com.pitercapistrano.calculadoradeimc_compose.ui.theme.DarkGreen
import com.pitercapistrano.calculadoradeimc_compose.ui.theme.DarkRed
import com.pitercapistrano.calculadoradeimc_compose.ui.theme.Orange
import com.pitercapistrano.calculadoradeimc_compose.ui.theme.Red
import com.pitercapistrano.calculadoradeimc_compose.ui.theme.Yellow
import java.text.DecimalFormat

class CalcularImc {

    private var resultadoImc: String = ""
    private var corResultado: Color = Black // Cor padrão
    private var resultadoCor: Color = Black

    fun calcularImc(peso: String, altura: String){

        val pesoConvartido = peso.toDouble()
        val alturaConvertida = altura.toDouble()

        val resultado: String


        val imc = pesoConvartido / (alturaConvertida * alturaConvertida)
        val decimalFormat = DecimalFormat("0.00")

        // Verifica a faixa do IMC e define o texto e cor do resultado
        if (imc < 18.5) {
            resultado = "Peso Baixo\nIMC: ${decimalFormat.format(imc)}"
            corResultado = Yellow // Exemplo de cor para peso baixo
        } else if (imc <= 24.9) {
            resultado = "Peso Normal\nIMC: ${decimalFormat.format(imc)}"
            corResultado = DarkGreen // Exemplo de cor para peso normal
        } else if (imc <= 29.9) {
            resultado = "Sobrepeso\nIMC: ${decimalFormat.format(imc)}"
            corResultado = Bege// Exemplo de cor para sobrepeso
        } else if (imc <= 34.9) {
            resultado = "Obesidade (Grau I)\nIMC: ${decimalFormat.format(imc)}"
            corResultado = Orange // Exemplo de cor para obesidade grau I
        } else if (imc <= 39.9) {
            resultado = "Obesidade Severa (Grau II)\nIMC: ${decimalFormat.format(imc)}"
            corResultado = Red // Exemplo de cor para obesidade grau II
        } else {
            resultado = "Obesidade Mórbida (Grau III)\nIMC: ${decimalFormat.format(imc)}"
            corResultado = DarkRed // Exemplo de cor para obesidade grau III
        }
        resultadoImc = resultado
        resultadoCor = corResultado
    }

    fun resultadoImc(): String{
        return resultadoImc
    }

    fun corResultado(): Color{
        return resultadoCor
    }
}