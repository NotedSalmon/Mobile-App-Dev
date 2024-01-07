package com.example.wagonersexperts.Menu

import android.app.Activity
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.R
import kotlinx.coroutines.selects.select

class AdminAddProduct: AppCompatActivity() {
    private val imageRequest = 1
    var imageToByte: ByteArray? = null

    val dbHelper: Menu_DBHelper = Menu_DBHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_add_item)

        val uploadImage: Button = findViewById(R.id.btnMenuImage)
        uploadImage.setOnClickListener(){
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(intent, imageRequest)
        }
    }

     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         super.onActivityResult(requestCode, resultCode, data)
         if(requestCode == imageRequest && resultCode == Activity.RESULT_OK && data != null && data.data != null){
            val selectedImage = data.data
            val inputStream = contentResolver.openInputStream(selectedImage!!)
            imageToByte = inputStream?.readBytes()
            inputStream?.close()

        }
    }


    fun btnUpload(view: View) {
        val productName = findViewById<EditText>(R.id.editProductName).text.toString()
        val price = findViewById<EditText>(R.id.editPrice).text.toString().toInt()
        val type = findViewById<EditText>(R.id.editType).text.toString()
        val menu = Menu_DataFiles(0, productName, price, imageToByte, type, 1)

        if(dbHelper.addMenuItem(menu)){
            Toast.makeText(this, "menu added", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
        }
    }

}



