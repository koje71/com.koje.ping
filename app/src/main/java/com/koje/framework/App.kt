package com.koje.framework

import android.app.Application
import android.content.Context
import com.koje.ping.R


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {

        fun getPicMapId():Int{
            return R.drawable.picmap
        }

        fun getReceiversId(): Int {
            return R.id.receivers
        }

        fun getUseCustomFont(): Boolean {
            return true
        }

        lateinit var context: Context

        fun debugging(): Boolean {
            return true
        }

        fun getString(id: Int): String {
            return context.resources.getString(id)
        }

        fun getBoolean(id: Int): Boolean {
            return context.resources.getBoolean(id)
        }

    }


}