package br.com.fran.confchat.presentation.ui.pages.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun MessageDialog(message:String,openDialog:Boolean,onResume:()->Unit,onClick:()->Unit) {
    if(openDialog) {
        AlertDialog(
            onDismissRequest = onResume,
            shape = RoundedCornerShape(20.dp),
            backgroundColor = MaterialTheme.colors.background,
            buttons = {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)) {
                    Spacer(modifier = Modifier.size(40.dp))
                    Text(text = message,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth())
                    Spacer(modifier = Modifier.size(52.dp))
                    Button(
                        onClick = onClick,
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height = 56.dp)){
                        Text(
                            text = "Ok",
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