package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { // ce qui apparait sur le tel (emulateur)
            HappyBirthdayTheme {
                Scaffold( // pr chaque fenetre, element + grandd
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->
                    Surface( // pr + petits elements, y en a plusieurs
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background

                    ) {
                        GreetingImage(
                            "Happy Birthday Jouana!",
                            from = "From Samantha",
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.cat2)
    val image2 = painterResource(R.drawable.cat)
    Box(modifier) {
        Image( // ca cest en fond, cest ce qui est au debut cest ce qui est en arriere plan genre z-index le plus bas (1)
            painter = image,
            contentDescription = null // alt pr limage
        )
        GreetingText( // le texte est par dessus limage
            message = message,
            from = from,
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp)
        )
        Image( // ca cest en fond, cest ce qui est au debut cest ce qui est en arriere plan genre z-index le plus bas (1)
            painter = image2,
            contentDescription = null , // alt pr limage
            modifier =  modifier.align(Alignment.BottomCenter)
        )

    }
}

@Preview(showBackground = true)

// les fonctions Composable peuvent appeler d'autres fonctions Composable

/// ca cest la preview ce qui apparait !! pas sur le tel
@Composable
fun BirthdayCardPreview() { // permet de visualiser la fonction Greeting
    HappyBirthdayTheme {
        GreetingImage(message = "Happy Birthday Jouana!", from = "From Samantha")
    }
}