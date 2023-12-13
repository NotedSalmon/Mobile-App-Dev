package com.example.wagonersexperts.Payment

data class PaymentData(
    val paymentID: Int,
    var orderID: Int,
    var paymentType: String, //java.time.LocalDate
    var amount: Int, // java.util.Date
    var paymentDate: String
) {

    override fun toString(): String{
        return "Order(orderID='$orderID', payment type=$paymentType, amount=$amount, payment date=$paymentDate)"
    }
}
