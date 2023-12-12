package com.example.wagonersexperts.Customer

data class CustomerData(
    val id: Int,
    var fullName: String,
    var email: String,
    var phoneNumber: String,
    var username: String,
    var password: String,
    var isActive: Boolean) {

    override fun toString(): String{
        return "Customer(name='$fullName', email=$email, phone number=$phoneNumber, username=$username, password=$password, isActive=$isActive)"
    }
}