package com.my_try.retrofitvkapi.Common

import com.my_try.retrofitvkapi.Interface.RetrofitService
import com.my_try.retrofitvkapi.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://api.vk.com"
    val retrofitService: RetrofitService
        get() =  RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}
