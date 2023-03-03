package br.com.fran.confchat.domain.model

data class ResponseTokenDm(
    val id: Int,
    val token: String,
    val type: String
)
fun ResponseTokenDm.toVM(){

}