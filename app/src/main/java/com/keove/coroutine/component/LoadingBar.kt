package com.keove.coroutine_retrofit.component

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.keove.coroutine.R

class LoadingBar {
    companion object{

        fun dialogBar(context : Context, layoutInflater: LayoutInflater?): AlertDialog.Builder {

            val promptView: View = layoutInflater!!.inflate(R.layout.loading_bar, null)
            var builder = AlertDialog.Builder(context)
            builder.setCancelable(false)
            builder.setView(promptView)
            var usersTxt: TextView = promptView.findViewById(R.id.usersTxt)
            usersTxt.text = "Lütfen bekleyim. Kullanıcılar yükleniyor."
            return builder
        }
    }
}