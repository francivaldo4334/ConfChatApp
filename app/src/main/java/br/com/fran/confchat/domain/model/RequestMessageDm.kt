package br.com.fran.confchat.domain.model

import br.com.fran.confchat.data.model.RequestMessage
import br.com.fran.confchat.data.model.ResponseMessage

data class RequestMessageDm(
    val code: String,
    val text: String
)
fun RequestMessageDm.toData():RequestMessage{
    return RequestMessage(
         code = this.code,
         text = this.text
    )
}