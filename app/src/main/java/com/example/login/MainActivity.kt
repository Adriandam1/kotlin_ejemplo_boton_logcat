package com.example.login

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /*
            LoginTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }

             */
            Login()

        }
    }
}

@Composable
fun Login() {
    // Dos maneras diferentes de definir un estado
    // con el = necesitamos utilizar value
    // cualquier cambio de counter o name por aberlo puesto con mutablestateof programara una recomposicion, dibujara actualizara.
    //vease que permite que cuando haya cambios en las variables se va a "actualizar en la visualizacion"
    var counter by remember { mutableStateOf(0) }
    var name = remember { mutableStateOf("") }

    Column (
        modifier = Modifier.padding(vertical = 200.dp)

            )
    {
        //Log.d( "tag", "msg") --> Log.d("Contador de clicks", "ize click "+counter+" veces")
        // Usando el Logcat podemos poner mensajes en la consola de logs para hacer comprobaciones en este caso cuando pulsamos el boton
        TextButton(onClick = {counter++; Log.d("Contador de clicks", "ize click "+counter+" veces") }) {
            Text("CLICS: $counter", fontSize = 24.sp)
        }

        // mientras no tecleamos mas de tres caracteres no se muestra el saludo
        if (name.value.length > 3) {
            //Log cat para el cambio de nombre
            Log.d("Cambio de nombre", "se actualizo el nombre a "+name.value)
            Text(
                text = "Nombre: ${name.value}!",
                fontSize = 24.sp
            )
        }
        // campo de texto para rellenar
        OutlinedTextField(
            value = name.value,
            onValueChange = {
                name.value = it
            },
            label = { Text(text = "Name") }
        )

    }

    // creamos otro widget para mostrar el saludo
    //Greeting(name = name.value)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Column {
        Text(
            text = "Hello $name!",
            fontSize = 38.sp,
            // lo separamos del borde superior
            modifier = Modifier.padding(vertical = 150.dp)
        )
    }
}












