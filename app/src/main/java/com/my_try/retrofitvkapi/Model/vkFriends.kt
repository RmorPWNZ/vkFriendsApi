package com.my_try.retrofitvkapi.Model

//check this link https://mocki.io/v1/85533f74-542c-4336-9419-809280940808 to see how required looks like
// however it was free fake json api for test and it can be non-working
data class vkFriends(
    var response: Response? = null
)
data class Response(
    var count: Int? = null,
    var items: List<Items>? = null
)
data class Items(
    var first_name: String? = null,
    var id: Int? = null,
    var last_name: String? = null,
    var photo: String? = null,
    var track_code: String? = null
)
