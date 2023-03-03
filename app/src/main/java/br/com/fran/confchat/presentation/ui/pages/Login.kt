package br.com.fran.confchat.presentation.ui.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import br.com.fran.confchat.presentation.ui.pages.componentes.MyTextField

@Composable
fun Login(onLogin:(email:String,password:String)->Unit,onRegister:()->Unit) {
    var emaiTF by remember{ mutableStateOf("") }
    var passTF by remember{ mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
    ) {
        MyTextField(emaiTF,{emaiTF = it},"E-mail")
        Spacer(modifier = Modifier.size(16.dp))
        MyTextField(passTF,{passTF = it},"Senha")
        Spacer(
            modifier = Modifier
                .height(height = 32.dp))
        Text(
            text = "esqueci a senha",
            textAlign = TextAlign.End,
            color = MaterialTheme.colors.onBackground,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Light,
            style = TextStyle(
                fontSize = 12.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp))
        Spacer(
            modifier = Modifier
                .height(height = 12.dp))
        Button(
            onClick = {
                onLogin.invoke(emaiTF,passTF)
            },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 56.dp)){
            Text(
                text = "Logar",
                color = MaterialTheme.colors.onPrimary,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold))
        }
        Spacer(
            modifier = Modifier
                .height(height = 22.dp))
        Text(
            text = "criar cadastro!",
            color = MaterialTheme.colors.onBackground,
            style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 14.sp),
            modifier = Modifier.clickable {
                onRegister.invoke()
            })
    }
}