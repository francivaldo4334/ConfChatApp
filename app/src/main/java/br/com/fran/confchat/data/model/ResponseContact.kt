package br.com.fran.confchat.data.model

import br.com.fran.confchat.domain.model.ResponseContactDm

data class ResponseContact(
    val code: String,
    val friend: Boolean,
    val friendId: Int,
    val id: Int,
    val userId: Int
)
fun ResponseContact.toData():ResponseContactDm{
    return ResponseContactDm(
        code = this.code,
        friend = this.friend,
        friendId = this.friendId,
        id = this.id,
        userId = this.userId
    )
}