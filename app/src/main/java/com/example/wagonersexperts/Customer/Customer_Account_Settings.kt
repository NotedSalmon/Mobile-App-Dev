package com.example.wagonersexperts.Customer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.MainActivity
import com.example.wagonersexperts.Menu.CustomerTest
import com.example.wagonersexperts.R

class Customer_Account_Settings : AppCompatActivity() {
    val dbHelper: Customer_DBHelper = Customer_DBHelper(this)
    var currentUser: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_account_settings)
        currentUser = intent.getStringExtra("customer").toString()

        val txtCurrentUser : TextView = findViewById(R.id.txtCurrentCustomer)
        txtCurrentUser.text = currentUser

        getUserDetails()

    }

    fun getUserDetails(){
        val txtFullName : TextView = findViewById(R.id.txtCustomerDetails_FullName)
        val fullname = txtFullName.toString()
        val txtEmail : TextView = findViewById(R.id.txtCustomerDetails_Email)
        val txtPhone : TextView = findViewById(R.id.txtCustomerDetails_PhoneNumber)


        val displayCustomerData = dbHelper.getCustomer(currentUser)

        if (displayCustomerData != null) {
            txtFullName.text = displayCustomerData.fullName
            txtEmail.text = displayCustomerData.email
            txtPhone.text = displayCustomerData.phoneNumber
        } else {
            Toast.makeText(this, "No customer found", Toast.LENGTH_SHORT).show()
        }
    }

    fun btnChangePassword(view: View){
        val txtCurrentPassword = findViewById<EditText>(R.id.txtOldPassword).text.toString()
        val txtNewPassword = findViewById<EditText>(R.id.txtNewPassword).text.toString()

        if (txtCurrentPassword.isEmpty() || txtNewPassword.isEmpty()){
            Toast.makeText(this, "Please enter a password", Toast.LENGTH_SHORT).show()
        } else {

            if ( dbHelper.changePassword(txtCurrentPassword, txtNewPassword, currentUser)){
                Toast.makeText(this, "Password changed", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Password not changed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun btnDeleteAccount(view: View){
        if (dbHelper.deleteCustomer(currentUser)){
            Toast.makeText(this, "Account Deleted", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@Customer_Account_Settings, MainActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Account not deleted", Toast.LENGTH_SHORT).show()
        }
    }

    fun btnLogOut(view: View){
        val intent = Intent(this@Customer_Account_Settings, MainActivity::class.java)
        startActivity(intent)
    }

}