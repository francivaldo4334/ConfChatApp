package br.com.fran.confchat.domain.repository

import br.com.fran.confchat.data.model.toData
import br.com.fran.confchat.data.repository.AuthRepository
import br.com.fran.confchat.domain.model.RequestLoginDm
import br.com.fran.confchat.domain.model.RequestRegisterDm
import br.com.fran.confchat.domain.model.ResponseTokenDm
import br.com.fran.confchat.domain.model.toData
import br.com.fran.confchat.domain.repository.interfaces.IAuthRepositoryDm

class AuthRepositoryDm : IAuthRepositoryDm {
    override suspend fun register(register: RequestRegisterDm): String {
        return AuthRepository().register(register.toData())
    }

    override suspend fun login(login: RequestLoginDm): ResponseTokenDm {
        return AuthRepository().login(login.toData()).toData()
    }
}