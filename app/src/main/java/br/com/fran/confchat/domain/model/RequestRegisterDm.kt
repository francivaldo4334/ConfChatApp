package br.com.fran.confchat.domain.model

import br.com.fran.confchat.data.model.RequestRegister

data class RequestRegisterDm(
    val email: String,
    val name: String,
    val password: String
)
fun RequestRegisterDm.toData():RequestRegister{
    return RequestRegister(
        email = this.email,
        name = this.name,
        password = this.password
    )
}