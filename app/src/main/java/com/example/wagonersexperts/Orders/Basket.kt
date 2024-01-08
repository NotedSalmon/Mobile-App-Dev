package com.example.wagonersexperts.Orders

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.Payment.Payment_Pay
import com.example.wagonersexperts.R

class Basket : AppCompatActivity() {
    val dbHelper: OrderDetails_DBHelper = OrderDetails_DBHelper(this) //Defines dbHelper
    private lateinit var listView: ListView
    private lateinit var totalTextView: TextView
    private lateinit var itemAdapter: ArrayAdapter<Item>

    private val dummyItemList = mutableListOf(
        Item("Sandwich", 1,  10.0),
        Item("Donuts", 3,  15.0),
        Item("Coffee", 4,  8.0),
        Item("Cake", 2,  12.0),
        Item("Cookies", 2,  5.0)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)

        listView = findViewById(R.id.listView)
        totalTextView = findViewById(R.id.txtBasketTotal)

        itemAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dummyItemList)
        listView.adapter = itemAdapter

        updateTotal()
    }

    private fun updateTotal() {
        val total = dummyItemList.sumByDouble { it.price * it.quantity }
        totalTextView.text = "Total: $$total"
    }

    fun removeSelectedItems(view: View) {
        val selectedIndices = listView.checkedItemPositions
        for (i in selectedIndices.size() - 1 downTo 0) {
            if (selectedIndices.valueAt(i)) {
                val selectedItem = itemAdapter.getItem(selectedIndices.keyAt(i))
                if (selectedItem != null) {
                    if (selectedItem.quantity > 1) {
                        // If quantity is more than 1, reduce the quantity
                        selectedItem.quantity -= 1
                    } else {
                        // If quantity is 1, remove the item from the list
                        itemAdapter.remove(selectedItem)
                    }
                }
            }
        }
        itemAdapter.notifyDataSetChanged()
        updateTotal()
    }


    fun btnPay(view: View){
        val intent = Intent(this@Basket, Payment_Pay::class.java)
        startActivity(intent)
    }
}