package br.com.fran.confchat.presentation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fran.confchat.presentation.model.ItemContact
import br.com.fran.confchat.R
import br.com.fran.confchat.presentation.ui.pages.componentes.AddContactDialog

@Composable
fun Contacts(list: List<ItemContact>,onClickAdd:(String)->Unit) {
    var opendialogAdd by remember{
        mutableStateOf(false)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        contentAlignment = Alignment.BottomEnd){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "Convercas", modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.size(16.dp))
            Divider(modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colors.onBackground))
            Spacer(modifier = Modifier.size(32.dp))
            LazyColumn{
                items(list){
                    Component(it.urlimg,it.nameOrCode)
                }
            }
        }
        IconButton(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colors.onBackground)
                ,
            onClick = {opendialogAdd = true}) {
            Icon(painterResource(id = R.drawable.material_symbols_add),null, tint = MaterialTheme.colors.onPrimary, modifier = Modifier.size(24.dp))
        }
    }
    AddContactDialog(opendialogAdd,{opendialogAdd = false},onClickAdd)
}
@Composable
private fun Component(imgUrl:String,naemOrCode:String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 56.dp)
    ) {
        Box(
            modifier = Modifier
                .size(size = 40.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color = MaterialTheme.colors.primary))
        Spacer(
            modifier = Modifier
                .width(width = 16.dp))
        Text(
            text = naemOrCode,
            color = MaterialTheme.colors.onBackground,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold)
        )
    }
}