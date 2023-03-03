package br.com.fran.confchat.presentation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fran.confchat.R
import br.com.fran.confchat.presentation.model.ItemNotification

@Composable
fun Notifications(listItem:List<ItemNotification>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = "Convercas", modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.size(16.dp))
        Divider(
            Modifier
                .height(2.dp)
                .background(MaterialTheme.colors.onBackground))
        Spacer(modifier = Modifier.size(16.dp))
        LazyColumn{
            items(listItem){
                Component(it)
            }
        }
    }
}
@Composable
private fun Component(item:ItemNotification) {
    Column {
        Spacer(modifier = Modifier.size(16.dp))
        Row (verticalAlignment = Alignment.CenterVertically){
            Box(modifier = Modifier.size(40.dp), contentAlignment = Alignment.Center){
                Icon(
                    painterResource(id = R.drawable.ic_notification),
                    contentDescription = "icon notification",
                    modifier = Modifier.size(24.dp))
            }
            Text(
                text = item.title,
                color = MaterialTheme.colors.onBackground,
                style = TextStyle(
                    fontSize = 14.sp),
                modifier = Modifier.fillMaxWidth())
        }
        Spacer(modifier = Modifier.size(16.dp))
        Divider(
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(horizontal = 16.dp))
    }
}