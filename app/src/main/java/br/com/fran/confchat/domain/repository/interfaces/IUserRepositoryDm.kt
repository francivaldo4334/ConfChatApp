package br.com.fran.confchat.domain.repository.interfaces

import br.com.fran.confchat.domain.model.*

interface IUserRepositoryDm {
    suspend fun getProfile(): ResponseUserDm
    suspend fun getNotifications(): List<ResponseNotificationDm>
    suspend fun getMessages(code:String): List<ResponseMessageDm>
    suspend fun getContacts(): List<ResponseContactDm>
    suspend fun sendMessage(body: RequestMessageDm):String
    suspend fun newContact(code:String): ResponseContactDm
}