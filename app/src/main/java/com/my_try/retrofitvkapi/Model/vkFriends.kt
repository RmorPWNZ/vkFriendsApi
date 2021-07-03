package com.my_try.retrofitvkapi.Model

data class vkFriends(
    var response: ArrayList<Response>? = null
)
data class Response(
    val count: Int? = null,
    val items: ArrayList<Items>? = null
)
data class Items(
    val first_name: String? = null,
    val id: String? = null,
    val last_name: String? = null,
    val photo: String? = null,
    val treckcode: String? = null
)
