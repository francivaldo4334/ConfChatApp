package br.com.fran.confchat.domain.model

import br.com.fran.confchat.data.model.RequestLogin

data class RequestLoginDm(
    val email: String,
    val password: String
)
fun RequestLoginDm.toData():RequestLogin{
    return RequestLogin(
        email = this.email,
        password = this.password
    )
}