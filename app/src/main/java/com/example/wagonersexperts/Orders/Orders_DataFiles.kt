package com.example.wagonersexperts.Orders

data class OrdersData(
    val orderID: Int,
    var customerID: Int,
    var orderDate: String, //java.time.LocalDate
    var orderTime: String, // java.util.Date
    var orderStatus: String
    ) {

    override fun toString(): String{
        return "Order(customerID='$customerID', order date=$orderDate, order time=$orderTime, status=$orderStatus)"
    }
}

data class OrderDetails(
    val orderDetailsID: Int,
    val orderID: Int,
    val productID: Int,
) {

    override fun toString(): String{
        return "Order_Details(orderID ='$orderID', productID = '$productID')"
    }

}