package br.com.fran.confchat.domain.model

import br.com.fran.confchat.presentation.model.ItemNotification

data class ResponseNotificationDm(
    val id: Int,
    val text: String,
    val title: String,
    val userId: Int
)
fun ResponseNotificationDm.toVM()=ItemNotification(
    id = this.id,
    title = this.title,
    content = this.text
)