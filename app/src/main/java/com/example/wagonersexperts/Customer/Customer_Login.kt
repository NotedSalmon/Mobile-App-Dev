package com.example.wagonersexperts.Customer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.Feedback.Feedback
import com.example.wagonersexperts.Menu.CustomerTest
import com.example.wagonersexperts.R
import com.example.wagonersexperts.extra.SHAEncryption.shaEncrypt

var globalCustomer: String = "" //This global variable will be used to store the current user
class CustomerLogin : AppCompatActivity(){

    val dbHelper: Customer_DBHelper = Customer_DBHelper(this) //Defines the correct DB Helper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_login)

        //If the Register button is clicked, then it will go to another activity
        val customerButton: Button = findViewById(R.id.btnCustomer_Register)
        customerButton.setOnClickListener {
            val intent = Intent(this@CustomerLogin, CustomerRegister::class.java)
            startActivity(intent)
        }
    }
    /*
    This function uses (view: View) this means that in the activity_login layout, the login button will have a
    OnClick listener that, when clicked, will run this function.

    This function then calls the DB Helper and the fun ValidateUser within it.
     */
    fun btnCustomerLogin(view: View){
        val username = findViewById<EditText>(R.id.txtCustomer_Username).text.toString()
        val password = shaEncrypt(findViewById<EditText>(R.id.txtCustomer_Password).text.toString())

        if (dbHelper.ValidateUser(username,password)) {
            // Credentials are valid so should go to Menu Activity
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            globalCustomer = username //Sets the Global Customer as the Username

            val intent = Intent(this@CustomerLogin, CustomerTest::class.java)
            intent.putExtra("customer", globalCustomer) //This extra is how the global customer will be sent between activities
            startActivity(intent)
        } else {
            Toast.makeText(this, "Username or Password Incorrect", Toast.LENGTH_SHORT).show()

        }

    }
}