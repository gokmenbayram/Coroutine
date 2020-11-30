package com.keove.coroutine_retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.keove.coroutine.R
import com.keove.coroutine_retrofit.model.Users

class UsersAdapter(private val usersList: ArrayList<Users>): RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_users_view, parent,false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return usersList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bindItems(usersList[position])
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var usersInfoTxt = view.findViewById<TextView>(R.id.usersInfoTxt)

        fun bindItems(usersList: Users) {

            usersInfoTxt.text = "Ad Soyad: ${usersList.name}\nKullanıcı Adı: ${usersList.username}\nEmail: ${usersList.email}"
        }
    }
}