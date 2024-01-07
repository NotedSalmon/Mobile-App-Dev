package com.example.wagonersexperts.Admin

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.Admin.Admin_db.Admin_DBHelper
import com.example.wagonersexperts.R
import com.example.wagonersexperts.extra.SHAEncryption.shaEncrypt

class AdminLogin : AppCompatActivity(){

    val dbHelper = Admin_DBHelper(this)
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)
    }

    fun btnAdminLogin(){
        val username = shaEncrypt(findViewById<EditText>(R.id.editUsername).toString())
        val password = shaEncrypt(findViewById<EditText>(R.id.editPassword).toString())
        var numTries = 3
        while (numTries > 0){
            if(dbHelper.loginAdmin(username,password)){
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@AdminLogin, AdminHomePage::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Login has failed $numTries attempts remaining", Toast.LENGTH_SHORT).show()
                numTries++
            }
        }
    }
}
