package com.example.wagonersexperts.admin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.admin.Admin_db.Admin_DBHelper
import com.example.wagonersexperts.R


class AdminLogin : AppCompatActivity(){

    private val dbHelper: Admin_DBHelper = Admin_DBHelper(this)
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)
    }

    fun btnAdminLogin(view: View){
        val username = findViewById<EditText>(R.id.editUsername).toString()
        val password = findViewById<EditText>(R.id.editPassword).toString()

        if (dbHelper.loginAdmin(username, password)) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@AdminLogin, AdminHomePage::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(
                this, "Login has failed",
                Toast.LENGTH_SHORT
            ).show()

        }
        }

    fun btnRegisterAdd(view: View){
        val intent = Intent(this@AdminLogin, AdminRegister::class.java)
        startActivity(intent)
    }
}
