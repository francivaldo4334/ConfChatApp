package br.com.fran.confchat.presentation.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import br.com.fran.confchat.common.Constants
import br.com.fran.confchat.domain.model.RequestLoginDm
import br.com.fran.confchat.domain.model.RequestRegisterDm
import br.com.fran.confchat.domain.repository.AuthRepositoryDm
import br.com.fran.confchat.domain.repository.UserRepositoryDm
import kotlinx.coroutines.Dispatchers

class Repositories {
    companion object:ViewModel(){
        private val user = UserRepositoryDm()
        private val auth = AuthRepositoryDm()
        fun login(email:String,password:String)= liveData(Dispatchers.IO){
            var token = auth.login(RequestLoginDm(
                email = email,
                password = password
            ))
            var response = !token.token.isNullOrEmpty()
            if(response)
                Constants.TOKEN = token.token
            emit(response)
        }
        fun register(name:String,email:String,password:String)= liveData(Dispatchers.IO){
            auth.register(RequestRegisterDm(
                name = name,
                email = email,
                password = password
            ))
            emit(true)
        }
        fun contacts()= liveData(Dispatchers.IO) {
            emit(user.getContacts())
        }
        fun AddContact(code:String) = liveData(Dispatchers.IO) {
            var res = user.newContact(code)
            if(res.code.isEmpty())
                emit(false);
            emit(true);
        }
        fun notifications()= liveData(Dispatchers.IO) {
            emit(user.getNotifications())
        }
        fun user()= liveData(Dispatchers.IO) {
            emit(user.getProfile())
        }
    }

}