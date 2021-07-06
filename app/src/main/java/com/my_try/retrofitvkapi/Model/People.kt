package com.my_try.retrofitvkapi.Model

//https://reqres.in/api/users?page=2 this json
data class People(
        var page: Int? = null,
        var per_page: Int? = null,
        var total: Int? = null,
        var total_pages: Int? = null,
        var data: List<Data>,
        var support: Support
    //var response: Response? = null
)
data class Data(
        var id: Int? = null,
        var email: String? = null,
        var first_name: String? = null,
        var last_name: String? = null,
        var avatar: String? = null
)
data class Support(
        var url: String? = null,
        var text: String? = null
)
/*data class Response(
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
*/