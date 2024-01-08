package com.example.wagonersexperts.admin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.Menu.AdminMenubrowser
import com.example.wagonersexperts.R

class AdminHomePage : AppCompatActivity() {

    override fun onCreate(savedInstantState: Bundle?){
        super.onCreate(savedInstantState)
        setContentView(R.layout.activity_admin_home_page)
    }

    fun btnRegisterAdmin(view: View){
        val intent = Intent(this@AdminHomePage, AdminRegister::class.java)
        startActivity(intent)
    }

    fun btnMenuOverview(view: View){
        val intent = Intent(this@AdminHomePage, AdminMenubrowser::class.java)
        startActivity(intent)
    }

}