package br.com.fran.confchat.data.repository

import android.util.Log
import br.com.fcr.searchusergithub.data.request.RetrofitService
import br.com.fran.confchat.data.model.RequestLogin
import br.com.fran.confchat.data.model.RequestRegister
import br.com.fran.confchat.data.model.ResponseToken
import br.com.fran.confchat.data.repository.interfaces.IAuthRepository

class AuthRepository : IAuthRepository {
    override suspend fun register(register: RequestRegister): String {
        var resp = ""
        try {
            resp = RetrofitService.getService().register(register)
        } catch (e: Exception) {
            Log.d(this.javaClass.simpleName,e.message!!)
        }
        return resp
    }

    override suspend fun login(login: RequestLogin): ResponseToken {
        var resp = ResponseToken(0,"","")
        try {
            resp = RetrofitService.getService().login(login)
        } catch (e: Exception) {
            Log.d(this.javaClass.simpleName,e.message!!)
        }
        return resp
    }
}