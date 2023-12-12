package com.example.wagonersexperts.Payment

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


private val DataBaseName = "Wagon_Experts.db"
private val ver : Int = 1

class Payment_DBHelper(context: Context) : SQLiteOpenHelper(context, DataBaseName, null, ver) {

    public val Table_Payment = "tblPaymentDetails"
    public val column_id = "paymentID"
    public val column_orderID = "orderID"
    public val column_paymentType = "PaymentType"
    public val column_amount = "Amount"
    public val column_paymentDate = "PaymentDate"
    override fun onCreate(db: SQLiteDatabase?) {
        val sqlCreateStatement: String = "CREATE TABLE " + Table_Payment + " ( " + column_id +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + column_orderID + " INTEGER, " + column_paymentType +
                " TEXT, " + column_amount + " INTEGER, " + column_paymentDate + " TEXT )"
        db?.execSQL(sqlCreateStatement)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}