package br.com.fran.confchat.domain.model

import br.com.fran.confchat.presentation.ui.pages.ItemUserProfile

data class ResponseUserDm(
    val code: String,
    val email: String,
    val permitions: String,
    val photoUrl: String,
    val name:String
)
fun ResponseUserDm.toVM()=ItemUserProfile(
    urlImg = this.photoUrl,
    name = this.name,
    code = this.code
)