package com.my_try.retrofitvkapi.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.my_try.retrofitvkapi.Model.*
import com.my_try.retrofitvkapi.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*

class MyMovieAdapter(private val context: Context, private val friendList: List<Items>): RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val photo: ImageView = itemView.photo
        val txt_name: TextView = itemView.txt_name
        val txt_last_name: TextView = itemView.txt_last_name
        val txt_id: TextView = itemView.txt_id
        fun bind(listItem: Items) {
            photo.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.photo}", Toast.LENGTH_SHORT).show()
            }
            txt_name.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.txt_name.text}", Toast.LENGTH_SHORT).show()
            }
            txt_last_name.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.txt_last_name.text}", Toast.LENGTH_SHORT).show()
            }
            txt_id.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.txt_id.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }
    override fun getItemCount() = friendList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem: Items = friendList[position]
        holder.bind(listItem)

        Picasso.get().load(friendList[position].photo).into(holder.photo)
        holder.txt_name.text = friendList[position].first_name
        holder.txt_last_name.text = friendList[position].last_name
        holder.txt_id.text = friendList[position].id?.toString()
    }
//Parsing nested JSON retrofit
}