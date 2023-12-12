package com.example.wagonersexperts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.Customer.CustomerLogin

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