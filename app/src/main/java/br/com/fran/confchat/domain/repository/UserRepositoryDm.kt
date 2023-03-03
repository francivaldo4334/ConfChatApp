package br.com.fran.confchat.domain.repository

import br.com.fran.confchat.data.model.*
import br.com.fran.confchat.data.repository.UserRepository
import br.com.fran.confchat.domain.model.*
import br.com.fran.confchat.domain.repository.interfaces.IUserRepositoryDm

class UserRepositoryDm : IUserRepositoryDm{
    override suspend fun getProfile(): ResponseUserDm {
        return UserRepository().getProfile().toData()
    }

    override suspend fun getNotifications(): List<ResponseNotificationDm> {
        return UserRepository().getNotifications().map { it.toData() }
    }

    override suspend fun getMessages(code: String): List<ResponseMessageDm> {
        return UserRepository().getMessages(code).map { it.toData() }
    }

    override suspend fun getContacts(): List<ResponseContactDm> {
        return  UserRepository().getContacts().map { it.toData() }
    }

    override suspend fun sendMessage(body: RequestMessageDm): String {
        return UserRepository().sendMessage(body.toData())
    }

    override suspend fun newContact(code: String): ResponseContactDm {
        return UserRepository().newContact(code).toData()
    }

}