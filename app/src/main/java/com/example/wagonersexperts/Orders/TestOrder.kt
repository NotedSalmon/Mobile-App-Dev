package com.example.wagonersexperts.Orders

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.Customer.globalCustomer
import com.example.wagonersexperts.Menu.CustomerTest
import com.example.wagonersexperts.Payment.Payment_Pay
import com.example.wagonersexperts.R

class TestOrder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_customer_order_page)
    }

    fun btnBackToTests(view: View){
        val intent = Intent(this@TestOrder, CustomerTest::class.java)
        startActivity(intent)

    }
}