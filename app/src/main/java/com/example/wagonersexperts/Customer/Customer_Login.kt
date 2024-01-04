package com.example.wagonersexperts.Customer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.Feedback.Feedback
import com.example.wagonersexperts.R
import com.example.wagonersexperts.extra.SHAEncryption.shaEncrypt

var globalCustomer: String = ""
class CustomerLogin : AppCompatActivity(){

    val dbHelper: DBHelper = DBHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_login)

        val customerButton: Button = findViewById(R.id.btnCustomer_Register)
        customerButton.setOnClickListener {
            val intent = Intent(this@CustomerLogin, CustomerRegister::class.java)
            startActivity(intent)
        }
    }

    fun btnCustomerLogin(view: View){
        val username = shaEncrypt(findViewById<EditText>(R.id.txtCustomer_Username).text.toString())
        val password = shaEncrypt(findViewById<EditText>(R.id.txtCustomer_Password).text.toString())

        if (dbHelper.ValidateUser(username,password)) {
            // Credentials are valid so should go to Menu Activity
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            globalCustomer = username

            val intent = Intent(this@CustomerLogin, Feedback::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Username or Password Incorrect", Toast.LENGTH_SHORT).show()

        }

    }
}