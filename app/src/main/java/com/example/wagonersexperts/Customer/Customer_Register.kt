package com.example.wagonersexperts.Customer
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.R
import com.example.wagonersexperts.extra.SHAEncryption.shaEncrypt
class CustomerRegister : AppCompatActivity() {

    val dbHelper: Customer_DBHelper = Customer_DBHelper(this) //The dbHelper is defined

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_register)

        val backButton: Button = findViewById(R.id.btnBack) //A back button in case user made the wrong choice
        backButton.setOnClickListener {
            val intent = Intent(this@CustomerRegister, CustomerLogin::class.java)
            startActivity(intent)
        }
    }

    /*
    This function uses (view: View) which means the Register button in the activity_customer_register has a OnClickListener
    that links back to this function. The function turns all the EditText fields and turns them into strings to later be used
    in creating the database entry
     */
    fun btnRegisterCustomer(view: View) {
        val customerName = findViewById<EditText>(R.id.txtFullName).text.toString()
        val customerEmail = findViewById<EditText>(R.id.txtEmail).text.toString()
        val customerPhone = findViewById<EditText>(R.id.txtPhoneNumber).text.toString()
        val customerUsername = findViewById<EditText>(R.id.txtUsername).text.toString()
        val customerPassword = shaEncrypt(findViewById<EditText>(R.id.txtPassword).text.toString()) //Encryption used for password only
        val customerIsActive = 1

        val customer = CustomerData(0,customerName,customerEmail,customerPhone,customerUsername, customerPassword, customerIsActive)
        if(dbHelper.addCustomer(customer)){ //Calls function addCustomer within the dbHelper
            Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CustomerLogin::class.java) //Sends user to the Login Activity
            startActivity(intent)
        }
        else Toast.makeText(this, "Error: Account not created", Toast.LENGTH_SHORT).show() //Error message
    }
}