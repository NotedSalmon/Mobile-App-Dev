package com.example.wagonersexperts.Admin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.R

class AdminHomePage : AppCompatActivity() {

    override fun onCreate(savedInstantState: Bundle?){
        super.onCreate(savedInstantState)
        setContentView(R.layout.activity_admin_login)
    }

    fun btnRegisterAdmin(){
        val intent = Intent(this@AdminHomePage, AdminRegister::class.java)
        startActivity(intent)
    }

}