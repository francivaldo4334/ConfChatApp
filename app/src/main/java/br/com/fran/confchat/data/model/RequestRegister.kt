package br.com.fran.confchat.data.model

data class RequestRegister(
    val email: String,
    val name: String,
    val password: String
)