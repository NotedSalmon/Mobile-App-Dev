package com.example.wagonersexperts.Menu

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.example.wagonersexperts.R
import java.nio.ByteBuffer

class MenuAdapter (context: Activity, private val MenuList: List<Menu_DataFiles>) : ArrayAdapter<Menu_DataFiles>(context, R.layout.menu_list_item){

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate((R.layout.menu_list_item), null)

        val MenuImage : ImageView = view.findViewById(R.id.imgMenuImage)
        val MenuName : TextView = view.findViewById(R.id.txMenuName)
        val MenuPrice : TextView = view.findViewById(R.id.txtMenuPrice)


        MenuImage.setImageResource(ByteBuffer.wrap(MenuList[position].product_image).int)
        MenuName.text = MenuList[position].product_Name
        MenuPrice.text = MenuList[position].product_Price.toString()

        return view
    }
}