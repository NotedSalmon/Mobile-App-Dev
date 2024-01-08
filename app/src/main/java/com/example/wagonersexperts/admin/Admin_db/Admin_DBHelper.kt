package com.example.wagonersexperts.admin.Admin_db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

private val DataBaseName = "Wagon_Experts.db"
private val ver : Int = 1

class Admin_DBHelper(context: Context) : SQLiteOpenHelper(context, DataBaseName, null, 1){

    val tableAdminDetails = "tblAdmin_Details"
    val adminId = "AdminId"
    val adminFullName = "AdminFullName"
    val adminEmail = "AdminEmail"
    val adminPhoneNo = "AdminPhoneNo"
    val adminUserName = "AdminUserName"
    val adminPassword = "AdminPassword"
    val adminActive = "AdminActive"
    val adminPriveleges = "AdminPriveleges"

    override fun onCreate(db: SQLiteDatabase?) {
        val sqlCreateStatement: String = "CREATE TABLE" + tableAdminDetails + "(" + adminId + "INTEGER PRIMARY KEY AUTOINCREMENT" +
                adminFullName + "STRING" + adminEmail + "STRING" + adminPhoneNo + "STRING" +
                adminUserName + "STRING" + adminPassword + "STRING" + adminActive + "INTEGER DEFAULT 1" + adminPriveleges + "INTEGER" + ")"

        db?.execSQL(sqlCreateStatement)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun addAdmin(admin: AdminData) : Boolean{
        val db: SQLiteDatabase = this.writableDatabase
        val cv: ContentValues = ContentValues();

        cv.put(adminFullName, admin.AdminFullName)
        cv.put(adminEmail, admin.AdminEmail)
        cv.put(adminPhoneNo, admin.AdminPhoneNo)
        cv.put(adminActive, admin.AdminActive)
        cv.put(adminPriveleges, admin.AdminPriveleges)

        val success = db.insert(tableAdminDetails, null, cv)
        db.close()
        return success != -1L
    }

    fun loginAdmin (Username: String, password: String): Boolean{
        val db = this.readableDatabase
        val columns = arrayOf(adminUserName, adminPassword)
        val selection= "$adminUserName = ? AND $adminPassword = ?"
        val args = arrayOf(Username, password)
        val cursor: Cursor = db.query(tableAdminDetails, columns, selection, args, null, null, null)
        val count = cursor.count

        cursor.close()
        return count > 0
    }

}