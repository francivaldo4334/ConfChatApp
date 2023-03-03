package br.com.fran.confchat.presentation.ui.pages.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyTextField(value:String, onValue:(String)->Unit, placeholder: String){
    OutlinedTextField(
        value = value,
        onValueChange = onValue,
        placeholder = { Text(placeholder) },
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Light
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colors.onBackground,
            placeholderColor = MaterialTheme.colors.onBackground,
            backgroundColor = Color.Transparent,
            focusedBorderColor = MaterialTheme.colors.onBackground,
            unfocusedBorderColor = MaterialTheme.colors.onBackground
        ),
        maxLines = 1,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth())
}