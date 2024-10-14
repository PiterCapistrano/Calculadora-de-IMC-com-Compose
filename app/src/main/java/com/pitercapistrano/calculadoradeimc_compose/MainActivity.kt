package com.pitercapistrano.calculadoradeimc_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pitercapistrano.calculadoradeimc_compose.ui.theme.Blue
import com.pitercapistrano.calculadoradeimc_compose.ui.theme.CalculadoraDeIMC_ComposeTheme
import com.pitercapistrano.calculadoradeimc_compose.ui.theme.DarkBlue
import com.pitercapistrano.calculadoradeimc_compose.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraDeIMC_ComposeTheme {
                CalculadoraImc()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculadoraImc(){

    var peso by remember {
        mutableStateOf("")
    }

    var altura by remember {
        mutableStateOf("")
    }

    var resultado by remember {

        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Calculadora de IMC", color = White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Blue)
                )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Text(
                text = "Calculadora de IMC",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Blue,
                modifier = Modifier.padding(50.dp)
                )

            OutlinedTextField(
                value = peso,
                onValueChange = {
                    peso = it
                },
                label = {
                    Text(text = "Peso (Kg)")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Blue,
                    focusedLabelColor = DarkBlue,
                    focusedBorderColor = Blue,
                    focusedTextColor = DarkBlue,
                    unfocusedTextColor = DarkBlue
                ),
                textStyle = TextStyle(DarkBlue, 18.sp),
                maxLines = 1,
                singleLine = true,
                modifier = Modifier
                    .padding(20.dp, 0.dp, 20.dp, 0.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                )
            )

            OutlinedTextField(
                value = altura,
                onValueChange = {
                    altura = it
                },
                label = {
                    Text(text = "Altura (m)")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Blue,
                    focusedLabelColor = DarkBlue,
                    focusedBorderColor = Blue,
                    focusedTextColor = DarkBlue,
                    unfocusedTextColor = DarkBlue
                ),
                textStyle = TextStyle(DarkBlue, 18.sp),
                maxLines = 1,
                singleLine = true,
                modifier = Modifier
                    .padding(20.dp, 10.dp, 20.dp, 0.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                )
            )
            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue,
                    contentColor = White
                ),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    text = "Calcular IMC",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                    )
            }

            Text(
                text = resultado,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = DarkBlue,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculadoraDeIMC_ComposeTheme {
        CalculadoraImc()
    }
}