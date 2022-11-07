package com.example.news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = FragmentAdap(supportFragmentManager)
        fragment.add(HeadlinesFragment(),"Headlines")
        fragment.add(BussinessFragment(),"Bussiness")
        fragment.add(EntertainmentFragment(),"Entertainment")
        fragment.add(HeadlinesFragment(),"Health")
        fragment.add(ScienceFragment(),"Science")
        fragment.add(SportsFragment(),"Sports")
        fragment.add(TechnologyFragment(),"Technology")

        view.adapter=fragment
        tabLayout.setupWithViewPager(view)





    }
}