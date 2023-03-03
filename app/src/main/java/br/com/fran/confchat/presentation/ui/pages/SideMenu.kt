package br.com.fran.confchat.presentation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fran.confchat.R

data class ItemMenu(val iconId: Int,val text: String,val onclick:()->Unit)
@Composable
fun SideMenu(items: List<ItemMenu>) {
    Column (
        modifier = Modifier
            .fillMaxWidth(1.1f)
            .fillMaxHeight()
            .background(MaterialTheme.colors.primary)
    ){
        Spacer(modifier = Modifier.size(72.dp))
        LazyColumn(content = {
            items(items){
                item(it.iconId,it.text,it.onclick)
            }
        })
    }
}
@Composable
private fun item(iconId:Int,text:String,onclick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .clickable {
                onclick.invoke()
            }
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        Row (verticalAlignment = Alignment.CenterVertically) {
            Icon(painterResource(id = iconId), contentDescription = null,
                modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = text,
                color = MaterialTheme.colors.onPrimary,
                style = TextStyle(
                    fontSize = 12.sp))
        }
        Spacer(modifier = Modifier.size(16.dp))
        Divider(color = MaterialTheme.colors.onPrimary)
    }
}
@Composable
fun LeftBar(openMenu:()->Unit){
    Box(
        modifier = Modifier
            .width(32.dp)
            .fillMaxHeight(),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(modifier = Modifier
            .fillMaxHeight()
            .width(16.dp)
            .background(MaterialTheme.colors.primary))
        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier
            .height(72.dp)
            .width(32.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colors.primary)
            .clickable { openMenu.invoke() }){
            Icon(
                painterResource(id = R.drawable.ic_open_menu),
                tint = MaterialTheme.colors.onPrimary,
                contentDescription = null,
                modifier = Modifier.size(24.dp))
        }
    }
}