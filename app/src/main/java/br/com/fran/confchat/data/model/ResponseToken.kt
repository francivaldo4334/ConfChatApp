package br.com.fran.confchat.data.model

import br.com.fran.confchat.domain.model.ResponseTokenDm

data class ResponseToken(
    val id: Int,
    val token: String?,
    val type: String?
)
fun ResponseToken.toData(): ResponseTokenDm {
    return ResponseTokenDm(
        id = this.id,
        token = if(this.token==null) "" else this.token,
        type = if(this.type == null) "" else this.type
    )
}