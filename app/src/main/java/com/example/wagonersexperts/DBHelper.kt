package com.example.wagonersexperts

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


/* Database Config*/
private val DataBaseName = "DB_Customer.db"
private val ver : Int = 1


class  DBHelper(context: Context) : SQLiteOpenHelper(context, DataBaseName, null, ver) {

    /*This is the values for the Customer Table */
        public val Table_Customer_Details = "TblCustomer_Details"
        public val column_ID = "id"
        public val column_FullName = "FullName"
        public val column_Email = "Email"
        public val column_PhoneNumber = "PhoneNumber"
        public val column_Username = "Username"
        public val column_Password = "Password"
        public val column_isActive = "CustomerIsActive"

    //This is called the first time a database is accessed
    // Creates a new DB

    override fun onCreate(db: SQLiteDatabase?) {
        val sqlCreateStatement: String = "CREATE TABLE " + Table_Customer_Details + " ( " + column_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + column_FullName + " TEXT, " + column_Email + " TEXT, " +
                column_PhoneNumber + " TEXT, " + column_Username + " TEXT, " + column_Password + " TEXT, " + column_isActive + " BOOLEAN )"
        db?.execSQL(sqlCreateStatement)
    }

    //This is called if the database version is changed
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not Yet implemented")
    }

    fun addCustomer(customer: CustomerData) : Boolean {
        //WriteableDatabase for insert actions
        val db: SQLiteDatabase = this.writableDatabase
        val cv: ContentValues = ContentValues()

        cv.put(column_FullName, customer.fullName)
        cv.put(column_Email, customer.email)
        cv.put(column_PhoneNumber, customer.phoneNumber)
        cv.put(column_Username, customer.username)
        cv.put(column_Password, customer.password)

        val success = db.insert(Table_Customer_Details, null, cv)
        db.close()
        return success != -1L
    }

    fun deleteCustomer(customer: CustomerData) : Boolean{

        val db: SQLiteDatabase = this.writableDatabase
        val result = db.delete(Table_Customer_Details, "$column_ID = ${customer.id}", null) == 1

        db.close()
        return result
    }

    fun getCustomer(cUsername: String, cPassword: String) : CustomerData {
        val db: SQLiteDatabase = this.writableDatabase
        val sqlStatement = "SELECT * FROM $Table_Customer_Details WHERE $column_Username = $cUsername AND $column_Password = $cPassword"

        val cursor: Cursor = db.rawQuery(sqlStatement, null)
        if(cursor.moveToFirst()){
            db.close()
            return CustomerData(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6) == 1)
        }
        else {
            db.close()
            return CustomerData(0, "Customer does not exist", "", "", "", "", false )
        }
    }

    fun ValidateUser(username: String, password: String): Boolean {
        val db = this.readableDatabase
        val columns = arrayOf(column_Username, column_Password)
        val selection = "$column_Username = ? AND $column_Password = ?"
        val selectionArgs = arrayOf(username, password)
        val cursor: Cursor = db.query(Table_Customer_Details, columns, selection, selectionArgs, null, null, null)
        val count = cursor.count

        cursor.close()
        return count > 0
    }

    fun getAllCustomer() : ArrayList<CustomerData> {
        val customerList = ArrayList<CustomerData>()
        val db: SQLiteDatabase = this.readableDatabase
        val sqlStatement = "SELECT * FROM $Table_Customer_Details"

        val cursor: Cursor = db.rawQuery(sqlStatement, null)

        if(cursor.moveToFirst())
            do {
                val id: Int = cursor.getInt(0)
                val FullName: String = cursor.getString(1)
                val Email: String = cursor.getString(2)
                val PhoneNumber: String = cursor.getString(3)
                val Username: String = cursor.getString(4)
                val Password: String = cursor.getString(5)
                val isActive: Boolean = cursor.getInt(6) == 1

                val customer = CustomerData(id, FullName, Email, PhoneNumber, Username, Password, isActive)
                customerList.add(customer)
            }while (cursor.moveToNext())
            cursor.close()
        db.close()

        return customerList
    }


}