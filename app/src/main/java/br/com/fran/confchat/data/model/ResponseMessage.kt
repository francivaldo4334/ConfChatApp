package br.com.fran.confchat.data.model

import br.com.fran.confchat.domain.model.ResponseMessageDm

data class ResponseMessage(
    val code: String,
    val contactId: Int,
    val id: Int,
    val person: Int,
    val text: String,
    val userId: Int,
    val visualized: Boolean
)
fun ResponseMessage.toData():ResponseMessageDm{
    return ResponseMessageDm(
        code = this.code,
        contactId = this.contactId,
        id = this.id,
        person = this.person,
        text = this.text,
        userId = this.userId,
        visualized = this.visualized
    )
}