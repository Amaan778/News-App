package com.example.news_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_headlines.*

class TechnologyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_technology, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler.layoutManager= LinearLayoutManager(this.activity)
        val arrayl=ArrayList<Constructor>()
        val adap=RecyclerAdap(this.activity,arrayl)
        recycler.adapter=adap



        val queues = Volley.newRequestQueue(context)
        val url="https://newsdata.io/api/1/news?apikey=pub_87623e3da181cb3fe96be13c32e0314e65ce&q=Technology&language=en"


        val jsonObject = JsonObjectRequest(
            Request.Method.GET,url,null, {

                val a=it.getJSONArray("results")
                for (i in 0 until a.length()){
                    val b=a.getJSONObject(i)
                    val author=b.getString("pubDate")
                    val title=b.getString("title")
                    val des=b.getString("description")
                    val imga=b.getString("image_url")
                    val link=b.getString("link")
                    arrayl.add(Constructor(title,des,author,imga,link))
                }
                adap.notifyDataSetChanged()

            }, {
                Toast.makeText(context,"Error", Toast.LENGTH_LONG).show()
            }
        )

        queues.add(jsonObject)
    }
}