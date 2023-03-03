package br.com.fran.confchat.data.repository.interfaces

import br.com.fran.confchat.data.model.RequestLogin
import br.com.fran.confchat.data.model.RequestRegister
import br.com.fran.confchat.data.model.ResponseToken

interface IAuthRepository {
    suspend fun register(register:RequestRegister):String
    suspend fun login(login:RequestLogin):ResponseToken
}