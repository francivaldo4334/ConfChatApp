package br.com.fran.confchat.presentation

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fran.confchat.common.Constants
import br.com.fran.confchat.presentation.repository.Repositories
import br.com.fran.confchat.presentation.ui.enum.Route
import br.com.fran.confchat.presentation.ui.pages.*
import br.com.fran.confchat.presentation.ui.pages.componentes.MessageDialog
import br.com.fran.confchat.presentation.ui.theme.ConfChatTheme

class MainActivity : ComponentActivity() {
    companion object{
        val PREFERENCES = "PREFERENCES"
        val EMAIL = "EMAIL"
        val PASSWORD = "PASSWORD"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var email = getMemory(EMAIL)
        var password = getMemory(PASSWORD)
        setContent {
            ConfChatTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var openDialogMessage by remember{
                        mutableStateOf(false)
                    }
                    var navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Route.Loading){
                        composable(Route.Loading){ Loading()}
                        composable(Route.Login){ Login(
                            onLogin = {e,p->
                                navController.navigate(Route.Loading){popUpTo(0)}
                                Repositories.login(e,p).observe(this@MainActivity){
                                    if(it){
                                        setMemory(EMAIL,e)
                                        setMemory(PASSWORD,p)
                                        startActivity(Intent(this@MainActivity,MenuActivity::class.java))
                                        finish()
                                    }
                                    else{
                                        openDialogMessage = true
                                        navController.navigate(Route.Login){popUpTo(0)}
                                    }
                                }
                            },
                            onRegister = {
                                navController.navigate(Route.Register){popUpTo(0)}
                            }
                        )}
                        composable(Route.Register){ Register(
                            onRegister = { n,e,p ->
                                navController.navigate(Route.Loading){popUpTo(0)}
                                Repositories.register(n,e,p).observe(this@MainActivity){
                                    navController.navigate(Route.Login){popUpTo(0)}
                                }
                            },
                            onLogin = {
                                navController.navigate(Route.Login){popUpTo(0)}
                            }
                        ) }
                    }
                    MessageDialog(
                        "Nao foi possivel logar nessa conta!\n Verifique seus dados e sua conexao com a internet ou tente mais tarde.",
                        openDialogMessage,
                        {openDialogMessage = false},
                        {openDialogMessage = false}
                    )
                    if(!email.isEmpty() && !password.isEmpty()){
                        Repositories.login(email,password).observe(this){
                            if(it){
                                startActivity(Intent(this@MainActivity,MenuActivity::class.java))
                                finish()
                            }
                            else
                                navController.navigate(Route.Login){popUpTo(0)}
                        }
                    }
                }
            }
        }
    }
    fun setMemory(value:String,it:String) {
        val editor: SharedPreferences.Editor = getSharedPreferences(PREFERENCES, MODE_PRIVATE).edit()
        editor.putString(value,it)
        editor.apply()
    }
    fun getMemory(value:String):String{
        val sharedPreferences: SharedPreferences = getSharedPreferences(PREFERENCES, MODE_PRIVATE)
        val token = sharedPreferences.getString(value, "")
        return token!!
    }
}