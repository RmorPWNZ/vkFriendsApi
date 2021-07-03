package com.my_try.retrofitvkapi.Common

import com.my_try.retrofitvkapi.Interface.RetrofitService
import com.my_try.retrofitvkapi.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://api.vk.com/method/"
    val retrofitService: RetrofitService
        get() =  RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}

//https://api.vk.com/method/friends.get?v=5.52&access_token=a9eefb34dd539ececf2d27d487809d08a244c361651c5eef46a848856014b2e0b17bde680acb40fe30538&fields=photo
//"https://www.simplifiedcoding.net/demos/"
//https://reqres.in/api/users?page=2