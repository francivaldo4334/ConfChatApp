package br.com.fran.confchat.data.repository.interfaces

import br.com.fran.confchat.data.model.*

interface IUserRepository {
    suspend fun getProfile():ResponseUser
    suspend fun getNotifications():List<ResponseNotification>
    suspend fun getMessages(code:String):List<ResponseMessage>
    suspend fun getContacts():List<ResponseContact>
    suspend fun sendMessage(body:RequestMessage):String
    suspend fun newContact(code:String):ResponseContact
}