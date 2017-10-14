package com.natan.tabs

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView() {
        setSupportActionBar(myToolbar)
        myViewPager.adapter = MyViewPagerAdapter(this, supportFragmentManager)
        myTabLayout.setupWithViewPager(myViewPager)
    }
}

class MyViewPagerAdapter(val context: Context, fragmentManager: FragmentManager?): FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return MyFirstFragment()
            1 -> return MySecondFragment()
        }
        return null
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return context.getString(R.string.first)
            1 -> return context.getString(R.string.second)
        }
        return null
    }
}
