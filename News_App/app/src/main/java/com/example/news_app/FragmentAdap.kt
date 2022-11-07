package com.example.news_app

import android.icu.text.CaseMap
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class FragmentAdap(fm : FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    val fragmentlist : ArrayList<Fragment> = ArrayList()
    val fragmenttitle :ArrayList<String> = ArrayList()

    override fun getCount(): Int {
        return fragmentlist.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentlist[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmenttitle[position]
    }

    fun add(fragment: Fragment,title: String){
        fragmentlist.add(fragment)
        fragmenttitle.add(title)
    }

}