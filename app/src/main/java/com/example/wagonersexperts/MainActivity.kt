package com.example.wagonersexperts

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.Admin.Admin_login
import com.example.wagonersexperts.Customer.CustomerLogin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         /*
         A channel needs to be created to be able to send notifications to the users phone
         This is a one-off operation and can then be called anywhere in the program.
          */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "777"
            val channelName = "Wagon Experts"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, channelName, importance)
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        val customerButton: Button = findViewById(R.id.btnCustomer) //User is redirected to the Customer Login/Register Page
        customerButton.setOnClickListener {
            val intent = Intent(this@MainActivity, CustomerLogin::class.java)
            startActivity(intent)
        }

        val adminButton: Button = findViewById(R.id.btnAdmin) //User is redirected to the Admin Login/Register Page
        adminButton.setOnClickListener{
            val intent = Intent(this@MainActivity, Admin_login::class.java)
            startActivity(intent)
        }
    }
}