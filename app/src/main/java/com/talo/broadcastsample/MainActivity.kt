package com.talo.broadcastsample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.talo.broadcastsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var receiver: BroadcastReceiver
    private lateinit var binding: ActivityMainBinding
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        broadcastFunction()
    }

    private fun broadcastFunction() {
        val filler = IntentFilter()
        filler.addAction(Intent.ACTION_POWER_CONNECTED)
        filler.addAction(Intent.ACTION_POWER_DISCONNECTED)
        receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Toast.makeText(context, intent?.action, Toast.LENGTH_SHORT).show()
            }
        }
        registerReceiver(receiver, filler)
        binding.btnPress.setOnClickListener {
            sendBroadcast(Intent(context, IsReceiver::class.java))
        }
    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }
}