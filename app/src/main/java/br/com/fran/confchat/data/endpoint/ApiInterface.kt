package br.com.fcr.searchusergithub.data.endpoint

import br.com.fran.confchat.data.model.*
import retrofit2.http.*

interface ApiInterface{
    @POST("auth/register")
    suspend fun register(@Body body: RequestRegister): String
    @POST("auth/login")
    suspend fun login(@Body login: RequestLogin):ResponseToken
    @GET("user")
    suspend fun user():ResponseUser
    @GET("user/notifications")
    suspend fun notifications():List<ResponseNotification>
    @GET("user/messages/{code}")
    suspend fun messages(@Path("code") code:String):List<ResponseMessage>
    @GET("user/contacts")
    suspend fun contacts():List<ResponseContact>
    @POST("user/send_message")
    suspend fun sendMessage(@Body body:RequestMessage):String
    @POST("user/notification/{code}")
    suspend fun sendNotification(@Path("code") code:String,@Body body:RequestNotification):ResponseNotification
    @POST("user/contact/{code}")
    suspend fun newContact(@Path("code") code:String):ResponseContact
}