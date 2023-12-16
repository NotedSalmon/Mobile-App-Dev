package com.example.wagonersexperts.Admin.Admin_db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

private val DataBaseName = "Wagon_Experts.db"
private val ver : Int = 1

class Admin_DBHelper(context: Context) : SQLiteOpenHelper(context, DataBaseName, null, 1){

    private val tableAdminDetails = "tblAdmin_Details"
    private val adminId = "AdminId"
    private val adminFullName = "AdminFullName"
    private val adminEmail = "AdminEmail"
    private val adminPhoneNo = "AdminPhoneNo"
    private val adminUserName = "AdminUserName"
    private val adminPassword = "AdminPassword"
    private val adminActive = "AdminActive"
    private val adminPriveleges = "AdminPriveleges"

    override fun onCreate(db: SQLiteDatabase?) {
        val sqlCreateStatement: String = "CREATE TABLE" + tableAdminDetails + "(" + adminId + "INTEGER PRIMARY KEY AUTOINCREMENT" +
                adminFullName + "STRING" + adminFullName + "STRING" + adminEmail + "STRING" + adminPhoneNo + "STRING" +
                adminUserName + "STRING" + adminPassword + "STRING" + adminActive + "INTEGER DEFAULT 1" + adminPriveleges + "INTEGER" + ")"

        db?.execSQL(sqlCreateStatement)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}