package br.com.fran.confchat.presentation.ui.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Register(onRegister:(name:String,email:String,password:String)->Unit,onLogin:()->Unit){
    var emaiTF by remember{ mutableStateOf("") }
    var nameTF by remember{ mutableStateOf("") }
    var passTF by remember{ mutableStateOf("") }
    var passConfirmTF by remember{ mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
    ) {
        MyTextField("Nome:",nameTF,{nameTF = it})
        Spacer(modifier = Modifier.size(16.dp))
        MyTextField("E-mail:",emaiTF,{emaiTF = it})
        Spacer(modifier = Modifier.size(16.dp))
        MyTextField("Senha:",passTF, {passTF = it})
        Spacer(modifier = Modifier.size(16.dp))
        MyTextField("Confirmar:",passConfirmTF, {passConfirmTF = it})
        Spacer(modifier = Modifier.size(56.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedButton(
                onClick = onLogin,
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color.Transparent
                ),
                border = BorderStroke(1.dp,MaterialTheme.colors.onBackground),
                modifier = Modifier
                    .weight(1f)
                    .height(height = 56.dp)){
                Text(
                    text = "voltar",
                    color = MaterialTheme.colors.onBackground,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium)
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                onClick = {
                    if(passTF.equals(passConfirmTF)) {
                        onRegister.invoke(nameTF,emaiTF,passTF)
                    }
                },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                modifier = Modifier
                    .weight(1f)
                    .height(height = 56.dp)){
                Text(
                    text = "cadastrar",
                    color = MaterialTheme.colors.onPrimary,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium)
                )
            }
        }
    }
}
@Composable
private fun MyTextField(text:String, value:String, onValue:(String)->Unit) {
    Column(modifier = Modifier.fillMaxWidth()){
        Text(text = text, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        OutlinedTextField(
            value = value,
            onValueChange = onValue,
            maxLines = 1,
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colors.onBackground,
                backgroundColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(4.dp))
        Divider(color = MaterialTheme.colors.onBackground, modifier = Modifier.height(2.dp))
    }
}