package br.com.fran.confchat.presentation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fran.confchat.R
data class ItemUserProfile(val urlImg:String,val name:String,val code:String)
@Composable
fun Perfil(user:ItemUserProfile) {
    Column(
        modifier = Modifier
            .padding(32.dp)
    ) {
        Spacer(modifier = Modifier.height(height = 16.dp))
        Text(
            text = "Perfil",
            color = MaterialTheme.colors.onBackground,
            style = TextStyle(
                fontSize = 18.sp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(height = 32.dp))
        Row {
            Box(
                modifier = Modifier
                    .size(size = 56.dp)
                    .background(color = MaterialTheme.colors.primary))
            Spacer(modifier = Modifier.size(4.dp))
            Column {
                Row {
                    Text(
                        text = "Nome:",
                        color = MaterialTheme.colors.onBackground,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Light))
                    Icon(
                        painterResource(id = R.drawable.ic_edit),
                        contentDescription = "material-symbols:edit-document-outline-rounded",
                        tint = MaterialTheme.colors.onBackground.copy(alpha = 0.27f),
                        modifier = Modifier
                            .size(24.dp)
                            .padding(4.dp)
                    )
                }
                Spacer(
                    modifier = Modifier
                        .height(height = 4.dp))
                Text(
                    text = user.name,
                    color = MaterialTheme.colors.onBackground,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold))
            }
        }
        Spacer(
            modifier = Modifier
                .height(height = 16.dp))
        Row {
            Text(
                text = "Codigo:",
                color = MaterialTheme.colors.onBackground,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light))
            Icon(
                painterResource(id = R.drawable.ic_edit),
                contentDescription = "material-symbols:edit-document-outline-rounded",
                tint = MaterialTheme.colors.onBackground.copy(alpha = 0.27f),
                modifier = Modifier
                    .size(24.dp)
                    .padding(4.dp)
            )
        }
        Spacer(
            modifier = Modifier
                .height(height = 4.dp))
        Text(
            text = user.code,
            color = MaterialTheme.colors.onBackground,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold))
    }
}