package com.example.news_app

import android.content.Context
import android.content.Intent
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.row.view.*


class RecyclerAdap(val context: FragmentActivity?, val arrayList: ArrayList<Constructor>) : RecyclerView.Adapter<RecyclerAdap.Viewholder>(){
    class Viewholder (itemView: View):RecyclerView.ViewHolder(itemView){
        val te=itemView.text
        val description=itemView.Description
        val image=itemView.image
        val author=itemView.author
        val link=itemView.link
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view =LayoutInflater.from(context).inflate(R.layout.row,parent,false)

        return Viewholder(view)

    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.te.text=arrayList[position].text
        holder.description.text=arrayList[position].description
        holder.author.text=arrayList[position].autor
        holder.link.text=arrayList[position].link

        Glide.with(holder.itemView.context).load(arrayList[position].img).into(holder.image)

        holder.itemView.setOnClickListener(View.OnClickListener {

            val intent=Intent(context,WebActivity::class.java)
            intent.putExtra("link",arrayList[position].link)
            context?.startActivity(intent)

        })

    }

    override fun getItemCount(): Int {
         return arrayList.size
    }
}