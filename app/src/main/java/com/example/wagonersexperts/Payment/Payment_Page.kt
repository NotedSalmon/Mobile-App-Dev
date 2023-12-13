package com.example.wagonersexperts.Payment

import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.Menu.Menu_DBHelper

class Payment_Page : AppCompatActivity() {

    val dbHelper: Payment_DBHelper = Payment_DBHelper(this)
    val menuDB: Menu_DBHelper = Menu_DBHelper(this)

    val menuItems = menuDB.getMenuItems("Drinks")
    val menuAdapter = MenuAdapter(menuItems)


}