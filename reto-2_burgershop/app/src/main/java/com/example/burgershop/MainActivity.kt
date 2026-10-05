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