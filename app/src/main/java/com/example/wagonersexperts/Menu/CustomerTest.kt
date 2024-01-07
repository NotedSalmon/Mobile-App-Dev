package com.example.wagonersexperts.Menu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.Customer.CustomerLogin
import com.example.wagonersexperts.Customer.Customer_Account_Settings
import com.example.wagonersexperts.Customer.globalCustomer
import com.example.wagonersexperts.Feedback.Feedback
import com.example.wagonersexperts.Orders.Basket
import com.example.wagonersexperts.Payment.Payment_Pay
import com.example.wagonersexperts.R

var currentUser: String = "" //Sets the variable currentUser as empty for now
class CustomerTest : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_test)
        currentUser = intent.getStringExtra("customer").toString()

        val testFeedbackButton: Button = findViewById(R.id.btnTestFeedback) //User is redirected to the Feedback Page
        testFeedbackButton.setOnClickListener {
            val intent = Intent(this@CustomerTest, Feedback::class.java)
            intent.putExtra("customer", globalCustomer) //This extra is how the global customer will be sent between activities
            startActivity(intent)
        }

        val testPaymentButton: Button = findViewById(R.id.btnTestPayment) //User is redirected to the Customer Payment Page
        testPaymentButton.setOnClickListener {
            val intent = Intent(this@CustomerTest, Payment_Pay::class.java)
            intent.putExtra("customer", globalCustomer) //This extra is how the global customer will be sent between activities
            startActivity(intent)
        }

        val testBasketButton: Button = findViewById(R.id.btnTestBasket) //User is redirected to the Basket Page
        testBasketButton.setOnClickListener {
            val intent = Intent(this@CustomerTest, Basket::class.java)
            intent.putExtra("customer", globalCustomer) //This extra is how the global customer will be sent between activities
            startActivity(intent)
        }

        val testAccountButton: Button = findViewById(R.id.btnTestCustomerSettings) //User is redirected to the Customer Account Page
        testAccountButton.setOnClickListener {
            val intent = Intent(this@CustomerTest, Customer_Account_Settings::class.java)
            intent.putExtra("customer", globalCustomer) //This extra is how the global customer will be sent between activities
            startActivity(intent)
        }
    }
}