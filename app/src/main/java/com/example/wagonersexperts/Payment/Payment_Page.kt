package com.example.wagonersexperts.Payment

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.Menu.Menu_DBHelper
import com.example.wagonersexperts.R

class Payment_Pay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
    }

    fun btnPay(view: View){
        val intent = Intent(this@Payment_Pay, Menu::class.java)
        startActivity(intent)
    }
}