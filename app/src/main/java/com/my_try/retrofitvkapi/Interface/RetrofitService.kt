package com.my_try.retrofitvkapi.Interface

import com.my_try.retrofitvkapi.Model.vkFriends
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    @GET("friends.get?v=5.52&access_token=a9eefb34dd539ececf2d27d487809d08a244c361651c5eef46a848856014b2e0b17bde680acb40fe30538&fields=photo")
    fun getFriendList(): Call<MutableList<vkFriends>>
}