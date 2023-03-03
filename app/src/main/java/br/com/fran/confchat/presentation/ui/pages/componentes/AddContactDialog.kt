package br.com.fran.confchat.presentation.ui.pages.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun AddContactDialog(openDialog:Boolean,onResume:()->Unit,onClick:(String)->Unit) {
    if(openDialog) {
        AlertDialog(
            onDismissRequest = onResume,
            shape = RoundedCornerShape(20.dp),
            backgroundColor = MaterialTheme.colors.background,
            buttons = {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)) {
                    var codeTF by remember{
                        mutableStateOf("")
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = "Insira o codigo do usuarioa que pretende adicionar",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .fillMaxWidth())
                    Spacer(modifier = Modifier.size(32.dp))
                    MyTextField(codeTF,{codeTF = it},"Codigo")
                    Spacer(modifier = Modifier.size(52.dp))
                    Button(
                        onClick = {
                            onClick.invoke(codeTF)
                            onResume.invoke()
                        },
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height = 56.dp)){
                        Text(
                            text = "Adicionar",
                            color = MaterialTheme.colors.onPrimary,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold)
                        )
                    }
                }
            })
    }
}