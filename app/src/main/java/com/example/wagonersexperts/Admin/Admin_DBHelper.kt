package com.example.wagonersexperts.Admin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

private val DataBaseName = "Wagon_Experts.db"
private val ver : Int = 1

/**
 * Remember to check Customer_DBHelper for hints on how to go about this
 * This is also where every function relating to login/registering will be kept
 * Also remember to use the same naming patterns I have ex. tblAdmin_Details
 *
 * Keep organised and create Class Files in the related packages.
 */

class Admin_DBHelper(context: Context) : SQLiteOpenHelper(context, DataBaseName, null, ver) {
    override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}