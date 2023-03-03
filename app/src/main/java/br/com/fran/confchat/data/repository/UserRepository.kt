package br.com.fran.confchat.data.repository

import android.util.Log
import br.com.fcr.searchusergithub.data.request.RetrofitService
import br.com.fran.confchat.data.model.*
import br.com.fran.confchat.data.repository.interfaces.IUserRepository
import retrofit2.awaitResponse

class UserRepository :IUserRepository {
    override suspend fun getProfile(): ResponseUser {
        var res = ResponseUser("","","","","")
        try{
            res = RetrofitService.getService().user()
        }catch (e:Exception){
            Log.d(this.javaClass.simpleName,e.message!!)
        }
        return  res
    }

    override suspend fun getNotifications(): List<ResponseNotification> {
        var res = emptyList<ResponseNotification>()
        try{
            RetrofitService.getService().notifications()
        }catch (e:Exception){
            Log.d(this.javaClass.simpleName,e.message!!)
        }
        return  res
    }

    override suspend fun getMessages(code: String): List<ResponseMessage> {
        var res = emptyList<ResponseMessage>()
        try{
            res = RetrofitService.getService().messages(code)
        }catch (e:Exception){
            Log.d(this.javaClass.simpleName,e.message!!)
        }
        return  res
    }

    override suspend fun getContacts(): List<ResponseContact> {
        var res = emptyList<ResponseContact>()
        try{
            res = RetrofitService.getService().contacts()
        }catch (e:Exception){
            Log.d(this.javaClass.simpleName,e.message!!)
        }
        return  res
    }

    override suspend fun sendMessage(body: RequestMessage): String {
        var res = ""
        try{
            res = RetrofitService.getService().sendMessage(body)
        }catch (e:Exception){
            Log.d(this.javaClass.simpleName,e.message!!)
        }
        return  res
    }

    override suspend fun newContact(code: String): ResponseContact {
        var res = ResponseContact("",false,0,0,0)
        try{
            res = RetrofitService.getService().newContact(code)
        }catch (e:Exception){
            Log.d(this.javaClass.simpleName,e.message!!)
        }
        return  res
    }
}