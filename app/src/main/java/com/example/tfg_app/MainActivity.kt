package com.example.tfg_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.TipsAndUpdates
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.tfg_app.ui.theme.TFG_APPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TFG_APPTheme {
                val navController = rememberNavController()

                TFGScaffold(navController = navController)
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TFGScaffold(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomAppBar(navController) }
    ) {
        val paddingValues = it

        NavHost(navController = navController, startDestination = "LoginScreen") {

        }
        Text(text = "Hello World!!")
    }
}

@Composable
fun BottomAppBar(navController: NavHostController) {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Stats", "Profile", "Calculate", "Tips")
    val icons = listOf(
        Icons.Default.BarChart,
        Icons.Default.AccountCircle,
        Icons.Default.Calculate,
        Icons.Default.TipsAndUpdates
    )

    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("LoginScreen") },
            icon = { Icon(imageVector = Icons.Default.Logout, contentDescription = "Logout") },
            label = { Text(text = "Log Out") }
        )

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item+"Screen")
                },
                icon = { Icon(imageVector = icons[index], contentDescription = item) },
                label = { Text(text = item) }
            )
        }
    }
}