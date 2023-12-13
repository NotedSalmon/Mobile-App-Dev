package com.example.wagonersexperts.Orders

data class OrderDetails(
    val orderDetailsID: Int,
    val orderID: Int,
    val productID: Int,
    val productQuantity: Int
) {

    override fun toString(): String{
        return "Order_Details(orderID ='$orderID', productID ='$productID', product quantity='$productQuantity')"
    }
}