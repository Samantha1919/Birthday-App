package com.example.happybirthday
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                            message = stringResource(R.string.happy_birthday_text), // R c pr dire le nom du dossier res et c une convention de nommmage
                            from = stringResource(R.string.signature_text),
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
            text = message, // la on definit sur quel texte on met le style
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center, // centre le texte
         // il faut declarer le modifier = Modifier pour y ajouter du .padding(16.dp)
        )
        Text(
            text = from, // la on definit sur quel texte on met le style
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally) // ou va se placer toute la boite qui entoure le texte genre dans laquelle le texte est
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty) // R c pr dire le nom du dossier res et c une convention de nommmage

    Box(modifier) {
        Image( // ca cest en fond, cest ce qui est au debut cest ce qui est en arriere plan genre z-index le plus bas (1)
            painter = image,
            contentDescription = null, // alt pr limage
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText( // le texte est par dessus limage
            message = message,
            from = from,
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp)
        )


    }
}

@Preview(showBackground = true)

// les fonctions Composable peuvent appeler d'autres fonctions Composable

/// ca cest la preview ce qui apparait !! pas sur le tel
@Composable
fun BirthdayCardPreview() { // permet de visualiser la fonction Greeting
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
                    message = stringResource(R.string.happy_birthday_text), // R c pr dire le nom du dossier res et c une convention de nommmage
                    from = stringResource(R.string.signature_text),
                )
            }
        }
    }
}