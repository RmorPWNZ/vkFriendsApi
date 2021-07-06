package com.my_try.retrofitvkapi

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.my_try.retrofitvkapi.Adapter.MyMovieAdapter
import com.my_try.retrofitvkapi.Common.Common
import com.my_try.retrofitvkapi.Interface.RetrofitService
import com.my_try.retrofitvkapi.Model.*
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
    lateinit var dialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        getAllMovieList()
    }

    private fun getAllMovieList() {
        dialog.show()

        val mService: RetrofitService = Common.retrofitService
        CoroutineScope(Dispatchers.IO).launch {
            val response = mService.getFriendList()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    adapter = MyMovieAdapter(baseContext, response.body()?.response?.items as List<Items> )
                    adapter.notifyDataSetChanged()
                    recyclerMovieList.adapter = adapter
                    dialog.dismiss()
                }
            }
        }
    }
}
