package com.example.wagonersexperts.Menu

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.Orders.Basket
import com.example.wagonersexperts.R
import java.util.ArrayList
import kotlin.collections.mutableListOf

class CustomerMenu() : AppCompatActivity(){

    val dbHelper : Menu_DBHelper = Menu_DBHelper(this)
    val basket: MutableList<Any> = mutableListOf()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceBundle: Bundle?){
        super.onCreate(savedInstanceBundle)
        setContentView(R.layout.activity_customer_menu)

        val getItems = dbHelper.getAllMenuItems()

        val listView = findViewById<ListView>(R.id.lstCustomerMenuItems)
        val adapter = MenuAdapter(this, getItems)

        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener {
            parent, view, position, id -> val selectedItem = parent.getItemAtPosition(position)
            basket.add(selectedItem)
        }
    }

    fun btnAddToCart(view: View){
        val intent = Intent(this@CustomerMenu, Basket::class.java)
        intent.putExtra("basket", ArrayList(basket))
        startActivity(intent)
    }

}