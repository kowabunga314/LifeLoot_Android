package com.kaiju.lifeloot

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class GameAdapter: BaseAdapter () {
    private val playerNumber = 0

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = p2?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        return inflater.inflate(R.layout.fragment_game, null)
    }

    override fun getItem(p0: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(p0: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }
}