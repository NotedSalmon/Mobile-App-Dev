package com.example.wagonersexperts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customerButton: Button = findViewById(R.id.btnCustomer)
        customerButton.setOnClickListener {
            val intent = Intent(this@MainActivity, CustomerLogin::class.java)
            startActivity(intent)
        }
    }
}