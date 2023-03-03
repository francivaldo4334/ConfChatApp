package br.com.fcr.searchusergithub.data.request

import br.com.fcr.searchusergithub.data.endpoint.ApiInterface
import br.com.fran.confchat.common.Constants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitService{
    var gson = GsonBuilder()
        .setLenient()
        .create()
    var interceptor:HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val retrofit = Retrofit
        .Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(
            OkHttpClient.Builder()
                .connectTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .addInterceptor{
                    val request = it.request().newBuilder().addHeader("Authorization","Bearer ${Constants.TOKEN}").build()
                    it.proceed(request)
            }.build())
        .build()
    fun getService():ApiInterface{
        return retrofit.create(ApiInterface::class.java)
    }
}