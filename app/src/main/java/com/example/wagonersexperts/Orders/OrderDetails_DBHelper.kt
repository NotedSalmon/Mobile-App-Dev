package com.example.wagonersexperts.Orders

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

private val DataBaseName = "Wagon_Experts.db"
private val ver : Int = 1

class OrderDetails_DBHelper(context: Context) : SQLiteOpenHelper(context, DataBaseName, null, ver) {

    public val Table_Order = "tblOrderDetails"
    public val column_ID = "orderDetailsID"
    public val column_orderID = "orderID"
    public val column_productID = "productID"
    public val column_productQuantity = "ProductQuantity"

    override fun onCreate(db: SQLiteDatabase?) {
        val sqlCreateStatement: String = "CREATE TABLE " + Table_Order + " ( " + column_ID +
        " INTEGER PRIMARY KEY AUTOINCREMENT, " + column_orderID + " INTEGER, " + column_productID +
        " INTEGER, " + column_productQuantity + " INTEGER )"
        db?.execSQL(sqlCreateStatement)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}