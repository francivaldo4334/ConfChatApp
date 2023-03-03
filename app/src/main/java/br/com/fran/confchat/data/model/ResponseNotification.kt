package br.com.fran.confchat.data.model

import br.com.fran.confchat.domain.model.ResponseNotificationDm

data class ResponseNotification(
    val id: Int,
    val text: String,
    val title: String,
    val userId: Int
)
fun ResponseNotification.toData():ResponseNotificationDm{
    return ResponseNotificationDm(
        id = this.id,
        text = this.text,
        title = this.title,
        userId= this.userId
    )
}