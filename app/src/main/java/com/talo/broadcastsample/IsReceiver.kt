package com.talo.broadcastsample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class IsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "isReceiver", Toast.LENGTH_SHORT).show()
    }
}