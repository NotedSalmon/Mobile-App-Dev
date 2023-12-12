package com.example.wagonersexperts.Orders

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


// Database Config

private val DataBaseName = "Wagon_Experts.db"
private val ver : Int = 1
class Orders_DBHelper(context: Context) : SQLiteOpenHelper(context, DataBaseName, null, ver) {

    public val Table_Order = "tblOrders"
    public val column_ID = "orderID"
    public val column_customerID = "customerID"
    public val column_orderDate = "OrderDate"
    public val column_orderTime = "OrderTime"
    public val column_orderStatus = "OrderStatus"

    override fun onCreate(db: SQLiteDatabase?) {
        val sqlCreateStatement: String = "CREATE TABLE " + Table_Order + " ( " + column_ID +
        " INTEGER PRIMARY KEY AUTOINCREMENT, " + column_customerID + " INTEGER, " + column_orderDate +
        " TEXT, " + column_orderTime + " TEXT, " + column_orderStatus + " TEXT )"
        db?.execSQL(sqlCreateStatement)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}