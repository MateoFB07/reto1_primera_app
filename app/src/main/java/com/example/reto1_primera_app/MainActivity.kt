package com.example.reto1_primera_app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Android la necesita; aquí casi nunca se toca nada más
// que la línea setContent { ... }.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aplicamos el tema de colores
            MaterialTheme {
                // Surface el "lienzo" de fondo que ocupa toda la pantalla
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Aquí llamamos a NUESTRA función, la que dibuja la tarjeta
                    TarjetaPresentacion()
                }
            }
        }
    }
}

@Composable
fun TarjetaPresentacion() {
    // LocalContext: así un Composable "pide prestado" el contexto de Android
    // Lo necesitamos para poder abrir el navegador o el visor desde el botón.
    val context = LocalContext.current

    // 1. COLUMN: apila los elementos de arriba a abajo (como un flexbox vertical)
    Column(
        modifier = Modifier
            .fillMaxSize() // ocupa toda la pantalla
            .padding(all = 16.dp), // margen para que nada toque los bordes
        horizontalAlignment = Alignment.CenterHorizontally, // centra en el eje X
        verticalArrangement = Arrangement.Center // centra en el eje Y
    ) {
        // 2. IMAGE: la foto de perfil
        // Requiere un archivo 'fotomia' dentro de res/drawable
        Image(
            painter = painterResource(id = R.drawable.fotomia),
            contentDescription = "Foto de perfil de usuario", // para accesibilidad (lectores de pantalla)
            modifier = Modifier
                .size(150.dp) // tamaño fijo: 150x150
                .clip(CircleShape), // la recorta en forma de círculo
            contentScale = ContentScale.Crop // rellena el círculo sin deformar la imagen
        )

        // Hueco vacío entre la imagen y el texto
        Spacer(modifier = Modifier.height(24.dp))

        // 3. TEXT: nombre
        Text(
            text = "Mateo Fernández Blasco",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        // TEXT: rol o profesión
        Text(
            // cada alumno pone el suyo
            text = "Desarrollador de DAM",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.secondary // color secundario del tema
        )

        // Hueco más grande antes del botón
        Spacer(modifier = Modifier.height(32.dp))

        // 4. BUTTON 1: Enlace a GitHub
        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/MateoFB07"))
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth(fraction = 0.8f) // ocupa el 80% del ancho de pantalla
        ) {
            Text(text = "Mi Perfil de GitHub")
        }

        Spacer(modifier = Modifier.height(12.dp))

        // BUTTON 2: Enlace a LinkedIn
        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/tu-usuario"))
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth(fraction = 0.8f)
        ) {
            Text(text = "Mi Perfil de LinkedIn")
        }

        Spacer(modifier = Modifier.height(12.dp))

        // BUTTON 3: Descargar / Ver CV desde la carpeta res/raw
        Button(
            onClick = {
                // Ruta local directa al archivo PDF en la carpeta res/raw
                // Asegúrate de que el archivo se llama 'cv.pdf' dentro de res/raw
                val uriPdf = Uri.parse("android.resource://" + context.packageName + "/" + R.raw.cvingles)
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    setDataAndType(uriPdf, "application/pdf")
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                }
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth(fraction = 0.8f)
        ) {
            Text(text = "Descargar / Ver CV")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TarjetaPreview() {
    MaterialTheme {
        TarjetaPresentacion()
    }
}