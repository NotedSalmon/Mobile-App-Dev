package com.example.wagonersexperts.Menu

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.R

class AdminMenubrowser: AppCompatActivity() {

    val dbHelper =  Menu_DBHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_menu)

        val listView = findViewById<ListView>(R.id.lstMenuAdmin)

        val menuItems = dbHelper.getAllMenuItems()

        val adapter = MenuAdapter(this, menuItems)

        listView.adapter = adapter
    }

    fun btnAddMenuItem(view: View){
        val intent = Intent(this@AdminMenubrowser, AdminAddProduct::class.java)
        startActivity(intent)
    }
}