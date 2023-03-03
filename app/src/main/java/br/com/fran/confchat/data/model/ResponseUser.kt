package br.com.fran.confchat.data.model

import br.com.fran.confchat.domain.model.ResponseUserDm

data class ResponseUser(
    val code: String,
    val email: String,
    val permitions: String,
    val photoUrl: String?,
    val name:String?
)
fun ResponseUser.toData():ResponseUserDm{
    return ResponseUserDm(
        code = this.code,
        email = this.email,
        permitions = this.permitions,
        photoUrl = if(this.photoUrl == null) "" else this.photoUrl,
        name = if(this.name == null) "" else this.name
    )
}