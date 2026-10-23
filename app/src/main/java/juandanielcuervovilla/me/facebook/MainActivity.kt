package juandanielcuervovilla.me.facebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import juandanielcuervovilla.me.facebook.ui.screens.FacebookLoginScreen
import juandanielcuervovilla.me.facebook.ui.screens.FacebookRegisterScreen
import juandanielcuervovilla.me.facebook.ui.screens.FeedScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val myNavController = rememberNavController()
            NavHost(
                navController = myNavController,
                startDestination = "Login",
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = "Login"){
                    FacebookLoginScreen(
                        onClickRegister = {
                            myNavController.navigate("register")
                        },
                        onClickIniciarSesion = {
                            myNavController.navigate("feed")
                        })
                }
                composable(route = "register") {
                    FacebookRegisterScreen(onClickBack = {
                        myNavController.popBackStack()
                    })
                }
                composable(route = "feed") {
                    FeedScreen()
                }
            }
        }
    }
}


