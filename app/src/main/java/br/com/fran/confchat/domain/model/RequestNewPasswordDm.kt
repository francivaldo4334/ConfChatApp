package br.com.fran.confchat.domain.model

data class RequestNewPasswordDm(
    val code: Int,
    val newPassword: String
)