package com.my_try.retrofitvkapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.my_try.retrofitvkapi.Adapter.MyMovieAdapter
import com.my_try.retrofitvkapi.Common.Common
import com.my_try.retrofitvkapi.Interface.RetrofitService
import android.app.AlertDialog
import android.util.Log
import com.my_try.retrofitvkapi.Model.vkFriends
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var mService: RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
    lateinit var dialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService
        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        getAllMovieList()
    }

    private fun getAllMovieList() {
        dialog.show()
        mService.getFriendList().enqueue(object : Callback<MutableList<vkFriends>> {
            override fun onFailure(call: Call<MutableList<vkFriends>>, t: Throwable) {
                t.printStackTrace()
            }
            override fun onResponse(call: Call<MutableList<vkFriends>>, response: Response<MutableList<vkFriends>>) {
                adapter = MyMovieAdapter(baseContext, response.body() as MutableList<vkFriends>)
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter
                dialog.dismiss()
            }
        })
    }
}
