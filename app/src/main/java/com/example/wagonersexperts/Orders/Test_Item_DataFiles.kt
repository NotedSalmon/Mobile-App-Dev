package com.example.wagonersexperts.Orders

data class Item(val name: String, var quantity: Int = 1, val price: Double) {
    override fun toString(): String {
        return "$name - $price (Qty: $quantity) "
    }
}

