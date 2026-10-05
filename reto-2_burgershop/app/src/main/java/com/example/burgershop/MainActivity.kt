package com.example.burgershop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
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
                    // CatalogoHamburguesas (catalogohamburguesas)
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
    ),



)
