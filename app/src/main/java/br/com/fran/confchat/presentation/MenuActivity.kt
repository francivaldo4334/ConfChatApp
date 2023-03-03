package br.com.fran.confchat.presentation

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Message
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fran.confchat.R
import br.com.fran.confchat.domain.model.toVM
import br.com.fran.confchat.presentation.model.ItemContact
import br.com.fran.confchat.presentation.model.ItemNotification
import br.com.fran.confchat.presentation.repository.Repositories
import br.com.fran.confchat.presentation.ui.enum.Route
import br.com.fran.confchat.presentation.ui.pages.*
import br.com.fran.confchat.presentation.ui.pages.componentes.MessageDialog
import br.com.fran.confchat.presentation.ui.theme.ConfChatTheme
import kotlinx.coroutines.launch

class MenuActivity : ComponentActivity() {
    companion object{
        lateinit var navController: NavHostController;
    }
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
        setContent {
            ConfChatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var listItemContact by mutableStateOf(emptyList<ItemContact>())
                    var listItemNotifications by mutableStateOf(emptyList<ItemNotification>())
                    var user by remember {
                        mutableStateOf(ItemUserProfile("","",""))
                    }
                    var openMessageDialog by remember {
                        mutableStateOf(false)
                    }
                    val openMenu = rememberScaffoldState()
                    navController = rememberNavController()
                    val scope = rememberCoroutineScope()
                    Scaffold(
                        scaffoldState = openMenu,
                        drawerContent = {
                            val listItemMenu = mutableListOf<ItemMenu>()
                            listItemMenu.add(
                                ItemMenu(
                                    R.drawable.ic_chat,
                                    "Convercas"){
                                    navController.navigate(Route.Contact){popUpTo(0)}
                                    scope.launch {
                                        openMenu.drawerState.close()
                                    }
                                })
                            listItemMenu.add(
                                ItemMenu(
                                    R.drawable.ic_notification,
                                    "Notificacoes"
                                ){
                                    navController.navigate(Route.Notice) {popUpTo(0)}
                                    scope.launch {
                                        openMenu.drawerState.close()
                                    }
                                })
                            listItemMenu.add(
                                ItemMenu(
                                    R.drawable.ic_profile,
                                    "Perfil"){
                                    navController.navigate(Route.Perfil){popUpTo(0)}
                                    scope.launch {
                                        openMenu.drawerState.close()
                                    }
                                })
                            SideMenu(listItemMenu)
                        }
                    ) {
                        NavHost(navController = navController, startDestination = Route.Perfil){
                            composable(Route.Contact){
                                Repositories.contacts().observe(this@MenuActivity){
                                    listItemContact = it.map{
                                        it.toVM()
                                    }
                                }
                                Contacts(listItemContact,{
                                    Repositories.AddContact(it).observe(this@MenuActivity,{
                                        if(it){
                                            Repositories.contacts().observe(this@MenuActivity){
                                                listItemContact = it.map{
                                                    it.toVM()
                                                }
                                            }
                                        }else{
                                            openMessageDialog = true
                                        }
                                    })
                                })
                            }
                            composable(Route.Notice){
                                Repositories.notifications().observe(this@MenuActivity){
                                    listItemNotifications = it.map{
                                        it.toVM()
                                    }
                                }
                                Notifications(listItemNotifications)
                            }
                            composable(Route.Perfil){
                                Repositories.user().observe(this@MenuActivity){
                                    user = it.toVM()
                                }
                                Perfil(user) }
                        }
                        LeftBar{
                            scope.launch {
                                openMenu.drawerState.open()
                            }
                        }
                        MessageDialog(
                            message = "Nao foi possivel encontrar este usuario!",
                            openDialog = openMessageDialog,
                            onResume = { openMessageDialog = false}) {
                            openMessageDialog = false
                        }
                    }

                }
            }
        }
    }
}