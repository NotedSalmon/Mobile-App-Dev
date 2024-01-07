package com.example.wagonersexperts.Menu

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.R

class Admin_Menu_browser: AppCompatActivity() {

    val dbHelper =  Menu_DBHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_menu)

        val listView = findViewById<ListView>(R.id.lstMenuAdmin)

        val menuItems = dbHelper.getAllMenuItems()

        val adapter = MenuAdapter(this, menuItems)

        listView.adapter = adapter
    }
}