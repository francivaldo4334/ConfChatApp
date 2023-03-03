package br.com.fran.confchat.data.model

data class RequestNewPassword(
    val code: Int,
    val newPassword: String
)