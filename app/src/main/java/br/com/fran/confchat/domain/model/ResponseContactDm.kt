package br.com.fran.confchat.domain.model

import br.com.fran.confchat.presentation.model.ItemContact

data class ResponseContactDm(
    val code: String,
    val friend: Boolean,
    val friendId: Int,
    val id: Int,
    val userId: Int
)
fun ResponseContactDm.toVM()=ItemContact(
    this.code,
    this.code
)