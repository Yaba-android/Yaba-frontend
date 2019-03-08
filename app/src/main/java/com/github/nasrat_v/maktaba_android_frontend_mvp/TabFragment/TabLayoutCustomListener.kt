package com.github.nasrat_v.maktaba_android_frontend_mvp.TabFragment

import android.content.Context
import android.graphics.Typeface
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.github.nasrat_v.maktaba_android_frontend_mvp.R

class TabLayoutCustomListener(var context: Context) {

    fun setListenerTabLayout(tabLayout: TabLayout) {
        tabLayout.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                setTabTextToBold(tabLayout, tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                setTabTextToNormal(tabLayout, tab.position)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
    }

    fun setTabTextToBold(tabLayout: TabLayout, indexTab: Int) {
        val linearLayout = (tabLayout.getChildAt(0) as ViewGroup).getChildAt(indexTab) as LinearLayout
        val tabTextView = linearLayout.getChildAt(1) as TextView

        tabTextView.setTypeface(tabTextView.typeface, Typeface.BOLD)
        tabTextView.setTextColor(ContextCompat.getColor(context, R.color.colorTextBlack))
    }

    fun setTabTextToNormal(tabLayout: TabLayout, indexTab: Int) {
        val linearLayout = (tabLayout.getChildAt(0) as ViewGroup).getChildAt(indexTab) as LinearLayout
        val tabTextView = linearLayout.getChildAt(1) as TextView

        tabTextView.setTypeface(null, Typeface.NORMAL)
        tabTextView.setTextColor(ContextCompat.getColor(context, R.color.colorTextGrey))
    }
}