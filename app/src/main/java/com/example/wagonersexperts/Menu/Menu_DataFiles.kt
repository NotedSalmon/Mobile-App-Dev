package com.example.wagonersexperts.Menu

data class Menu_DataFiles(
    val product_ID: Int,
    val product_Name: String,
    val product_Price: Int,
    val product_image: String,
    val product_type: String,
    val available: Int
) {
    override fun toString(): String{
        return "Product(product name='$product_Name', product price='$product_Price', product image='$product_image', type= '${product_type}, available='$available')"
    }
}
