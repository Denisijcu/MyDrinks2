package com.example.mydrinks

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.mydrinks.ui.theme.MyDrinksTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyDrinksTheme {
                Scaffold() {
                    DrinkScreen()
                }
            }
        }
    }
}


@Composable
fun MyApp() {

    val imagenes = listOf(
        R.drawable.ron,
        R.drawable.wine,
        R.drawable.beer
    )

    val description = listOf("Ron","Wine","Beer")

    var imageIndex by remember { mutableStateOf(0) }

    var result by remember {
        mutableStateOf("Nice")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)

        ) {
            // Image
            Image(
                painter = painterResource(id = imagenes[imageIndex]),
                contentDescription = "Imagen de Bot",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(328.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Text
            Text(
                text = "Hola, Jetpack Compose! Esta mirando una botella de "+description[imageIndex],
                style = MaterialTheme.typography.labelLarge,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Row
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
              Text(text=result)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Button
            Button(onClick = {
                imageIndex = (imageIndex + 1) % imagenes.size

                if(imageIndex == 0){
                    result = "Nice"
                }else if(imageIndex==1) {
                    result = "Good"
                }else {
                    result = "Delicious"
                }


            }) {
                Text("Cambiar Imagen")
            }

            Spacer(modifier = Modifier.height(16.dp))


        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyDrinksTheme {
        MyApp()
    }
}