package com.example.burgershop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.burgershop.ui.theme.BurgerShopTheme


// ACTIVITY PRINCIPAL
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            // BurgerShopTheme: aplica los colores y
            // tipografías por defecto a todo lo que hay dentro
            BurgerShopTheme {
                // Surface: el "Lienzo" de fondo que ocupa la pantalla.
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CatalogoHamburguesas(catalogoHamburguesas)
                }
            }
        }
    }
}
// MODELO DE DATOS
// EL MOLDE QUE DEFINE QUÉ INFORMACIÓN TIENE CADA PRODUCTO

data class Producto (
    val nombre : String,
    val precio : String,
    val imagenResId : Int // el identificador de la imagen res/drawable
)

// DATOS DE PRUEBA (HARDCODEADOS)
// DE MOMENTO VIVEN AQUÍ MISMO, EN EL CÓDIGO. NO VIENEN DE NINGÚN SERVIDOR NI BBDD.

val catalogoHamburguesas = listOf (
    Producto (
        nombre = "Burger Clásica",
        precio = "6,50 €",
        imagenResId = R.drawable.burger_clasica
    ),
    Producto (
        nombre = "Burger BBQ",
        precio = "7,50 €",
        imagenResId = R.drawable.burger_bbq
    ),
    Producto (
        nombre = "Burger Doble",
        precio = "7,50 €",
        imagenResId = R.drawable.burger_doble
    ),
    Producto (
        nombre = "Burger Picante",
        precio = "8,50 €",
        imagenResId = R.drawable.burger_picante
    ),
    Producto (
        nombre = "Burger Pollo",
        precio = "7,50 €",
        imagenResId = R.drawable.burger_pollo
    ),
    Producto (
        nombre = "Burger Vegetariana",
        precio = "7,50 €",
        imagenResId = R.drawable.burger_vegetariana
    )
)

// CATÁLOGO
// LazyColumn: pinta una lista que se puede recorrer en scroll en vertical.
// Solo dibuja en memoria lo que se ve en pantalla (por eso se llama "lazy", perezoso): es eficiente
// aunque la lista tenga cientos de elementos.
@Composable
fun CatalogoHamburguesas (productos : List<Producto>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues (16.dp), // Márgen alrededor de toda la lista.
        verticalArrangement = Arrangement.spacedBy(16.dp) // Espacio entre elementos.
    ) {
        items(productos) { producto ->
            TarjetaProducto(producto)
        }
    }
}
// TARJETA DE PRODUCTO
// Un "caja" (card) con imagen arriba y datos + botón.
@Composable
fun TarjetaProducto(producto: Producto) {
    // Card: una superficie elevada, con sombra y border redondeados // por defecto - ideal para
    // agrupar visualmente la info de un producto.
    Card (
        modifier = Modifier.fillMaxWidth()
    ) {
        Column (
            modifier = Modifier.padding(16.dp)
        ) {
            // Column: apila sus elementos de arriba a abajo (flexbox).
            Column {
                Image(
                    painter = painterResource(
                        id = producto.imagenResId
                    ),
                    // Para accesibilidad (lectores de pantalla)
                    contentDescription = producto.nombre,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp), // Alto - fijo es justo -- "se rompe al rotar"
                    contentScale = ContentScale.Crop // Recorta la imagen sin deformar
                )
                // Segunda Column, con margen interior, para el texto y el botón.
                Column (
                    modifier = Modifier.padding(12.dp)
                ) {
                    Text (
                        text = producto.nombre,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp)) // Hueco pequeño.
                    Text (
                        text = producto.precio,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.primary // Color del tema.
                    )
                    Spacer(modifier = Modifier.height(8.dp)) // Hueco mediano.

                    Button (
                        onClick = {
                            // De momento, no hace nada: la interactividad.
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Añadir al carrito")
                    }
                }
            }
        }
    }
}
