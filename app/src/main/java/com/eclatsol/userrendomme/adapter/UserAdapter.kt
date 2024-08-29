package com.eclatsol.userrendomme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.eclatsol.userrendomme.R
import com.eclatsol.userrendomme.R.layout.item_add
import com.eclatsol.userrendomme.model.ResultsItem

class UserAdapter(val context : Context, private val userList : List<ResultsItem?>?) : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    inner class UserViewHolder(itemView: View) : ViewHolder(itemView){
        val tvGender = itemView.findViewById<TextView>(R.id.tvGender)
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvFirst = itemView.findViewById<TextView>(R.id.tvFirst)
        val tvLast = itemView.findViewById<TextView>(R.id.tvLast)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(item_add,parent,false))
    }

    override fun getItemCount(): Int {
        return userList!!.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.tvGender.text = userList?.get(position)!!.gender
        holder.tvTitle.text = userList?.get(position)!!.name?.title
        holder.tvGender.text = userList?.get(position)!!.name?.first
        holder.tvGender.text = userList?.get(position)!!.name?.last
    }
}