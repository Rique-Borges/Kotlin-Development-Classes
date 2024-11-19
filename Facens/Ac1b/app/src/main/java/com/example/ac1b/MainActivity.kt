package com.example.ac1b

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.ac1b.ui.theme.Ac1bTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ac1bTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController) }
                    composable("adega_da_morena") { DetalhesAdegaDaMorena() }
                    composable("smallbig_bar") { DetalhesSmallbigBar() }
                    composable("mavs_pub") { DetalhesMavsPub() }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) 
    ) {
        Text(
            text = "Guia de Sorocaba",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LocalListItem(
            imageResId = R.drawable.adega_da_morena_1,
            name = "Adega da Morena",
            onClick = { navController.navigate("adega_da_morena") }
        )
        LocalListItem(
            imageResId = R.drawable.smallbig_bar_1,
            name = "Smallbig Bar",
            onClick = { navController.navigate("smallbig_bar") }
        )
        LocalListItem(
            imageResId = R.drawable.mavs_pub_1,
            name = "Mavs Pub",
            onClick = { navController.navigate("mavs_pub") }
        )
    }
}

@Composable
fun LocalListItem(imageResId: Int, name: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(bottom = 8.dp)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Button(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
            Text("Saiba Mais")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalhesLocal(nome: String, endereco: String, site: String, telefone: String, imageResIds: List<Int>) {
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = nome, fontWeight = FontWeight.Bold, fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))
        imageResIds.forEach { imageResId ->
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 16.dp),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val gmmIntentUri = Uri.parse("geo:0,0?q=$endereco")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            context.startActivity(mapIntent)
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Ver no Mapa")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(site))
            context.startActivity(intent)
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Abrir Site")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para fazer uma ligação
        Button(onClick = {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$telefone")
            context.startActivity(intent)
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Fazer uma Ligação")
        }
    }
}

@Composable
fun DetalhesAdegaDaMorena() {
    DetalhesLocal(
        nome = "Adega da Morena",
        endereco = "R. Dr. Américo Figueiredo, 132 - Jardim Simus, Sorocaba - SP, 18055-131",
        site = "https://www.instagram.com/adega_da_morenah?igshid=YmMyMTA2M2Y%3D",
        telefone = "15 99822 5575",
        imageResIds = listOf(R.drawable.adega_da_morena_1, R.drawable.adega_da_morena_2)
    )
    Column(modifier = Modifier.padding(top = 656.dp)) {
        Text(
            text = "⭐1.8 - Barzinho insalubre com copão de 5 reais e narguile. Ideal pra quem não se importa com higiene ou saúde pública. Sente falta de emoção na vida? Venha arriscar!",
            fontSize = 16.sp
        )
    }
}

@Composable
fun DetalhesSmallbigBar() {
    DetalhesLocal(
        nome = "Smallbig Bar",
        endereco = "Av. Dr. Armando Pannunzio, 1330 - Jardim São Paulo, Sorocaba - SP, 18051-735",
        site = "https://www.facebook.com/thesmallbigbar/?hc_ref=PAGES_TIMELINE&paipv=0&eav=Afa85O35bv7yTyTw5v5IUYWIPXl-juvZ10CDY_aSs5lgv-KOkJXzMvHq4L3_ZCsJBSg&_rdr",
        telefone = "15 98803 9700",
        imageResIds = listOf(R.drawable.smallbig_bar_1, R.drawable.smallbig_bar_2)
    )
    Text(
        text = "⭐3.2 - O ponto de encontro universitário de Sorocaba. Bom pra socializar ou... tentar. Expectativa: amizades. Realidade: nunca se sabe quem você vai encontrar. Boa sorte!",
        fontSize = 16.sp,
        modifier = Modifier.padding(top = 656.dp)
    )
}

@Composable
fun DetalhesMavsPub() {
    DetalhesLocal(
        nome = "Mavs Pub",
        endereco = "Av. Dr. Armando Pannunzio, 1330 - Jardim São Paulo, Sorocaba - SP, 18051-735",
        site = "https://www.instagram.com/explore/locations/217381011627979/mavs-pub/",
        telefone = "15 3318 0126",
        imageResIds = listOf(R.drawable.mavs_pub_1, R.drawable.mavs_pub_2)
    )
    Text(
        text = "⭐4.0 - Balada porão com vibes góticas e synthwave. Se você gosta de luz baixa, música alternativa e questionar suas escolhas de vida, esse é o seu lugar!",
        fontSize = 16.sp,
        modifier = Modifier.padding(top = 656.dp)
    )
}

