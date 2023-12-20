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

    val dbHelper: DBHelper = DBHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_register)

        val backButton: Button = findViewById(R.id.btnBack)
        backButton.setOnClickListener {
            val intent = Intent(this@CustomerRegister, CustomerLogin::class.java)
            startActivity(intent)
        }
    }

    fun btnRegisterCustomer(view: View) {
        val customerName = shaEncrypt(findViewById<EditText>(R.id.txtFullName).text.toString())
        val customerEmail = shaEncrypt(findViewById<EditText>(R.id.txtEmail).text.toString())
        val customerPhone = shaEncrypt(findViewById<EditText>(R.id.txtPhoneNumber).text.toString())
        val customerUsername = shaEncrypt(findViewById<EditText>(R.id.txtUsername).text.toString())
        val customerPassword = shaEncrypt(findViewById<EditText>(R.id.txtPassword).text.toString())
        val customerIsActive = true



        val customer = CustomerData(0,customerName,customerEmail,customerPhone,customerUsername, customerPassword, customerIsActive)

        if(dbHelper.addCustomer(customer)){
            Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CustomerLogin::class.java)
            startActivity(intent)
        }
        else Toast.makeText(this, "Error: Account not created", Toast.LENGTH_SHORT).show()

    }
}