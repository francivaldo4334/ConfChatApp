package br.com.fran.confchat.domain.repository.interfaces

import br.com.fran.confchat.domain.model.RequestLoginDm
import br.com.fran.confchat.domain.model.RequestRegisterDm
import br.com.fran.confchat.domain.model.ResponseTokenDm

interface IAuthRepositoryDm {
    suspend fun register(register: RequestRegisterDm):String
    suspend fun login(login: RequestLoginDm): ResponseTokenDm
}