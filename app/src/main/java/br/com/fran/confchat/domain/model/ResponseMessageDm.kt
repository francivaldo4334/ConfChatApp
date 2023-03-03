package br.com.fran.confchat.domain.model

data class ResponseMessageDm(
    val code: String,
    val contactId: Int,
    val id: Int,
    val person: Int,
    val text: String,
    val userId: Int,
    val visualized: Boolean
)