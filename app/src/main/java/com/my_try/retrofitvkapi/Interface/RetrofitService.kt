package com.my_try.retrofitvkapi.Interface

import com.my_try.retrofitvkapi.Model.People
import com.my_try.retrofitvkapi.Model.vkFriends
import retrofit2.Response
import retrofit2.http.*

//acces_token should be responded from vk developers redirect url
// or use this https://mocki.io/v1/85533f74-542c-4336-9419-809280940808 however it can be non-working because it was temporary link
// or see json file in project src folder
interface RetrofitService {
    @GET("method/friends.get?v=5.52&access_token=PASTE_ACCESS_TOKEN_HERE&fields=photo")
    suspend fun getFriendList(): Response<vkFriends>
}