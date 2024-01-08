package com.example.wagonersexperts.Menu

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.sql.Blob
import java.sql.SQLException

private val DataBaseName = "Wagon_Experts.db"
private val ver : Int = 1

class Menu_DBHelper(context: Context) : SQLiteOpenHelper(context, DataBaseName, null, ver) {

    public val TableMenu = "tblMenu"
    public val columnID = "productID"
    public val columnName = "ProductName"
    public val columnPrice = "Price"
    public val columnImage = "Image"
    public val columnAvailable = "Available"
    val columnType = "Type"
    override fun onCreate(db: SQLiteDatabase?) {
        val sqlCreateStatement: String = "CREATE TABLE " + TableMenu + " ( " + columnID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + columnName + " TEXT, " +
                columnPrice + " INTEGER " + columnImage + " BLOB " + columnType + " TEXT " + columnAvailable + " INTEGER )"
        db?.let{ db.execSQL(sqlCreateStatement)}
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion < newVersion)
            db!!.execSQL("ALTER TABLE $TableMenu ADD COLUMN $columnType TEXT")
    }


    /**
     * Something along these lines below to get menu items.
     */
   fun getMenuItem(Id: Int) : Menu_DataFiles {
       val db: SQLiteDatabase = this.writableDatabase
       val sqlStatement = "SELECT * FROM $TableMenu WHERE $columnID = $Id AND $columnAvailable = 1"

       val cursor: Cursor = db.rawQuery(sqlStatement, null)
       if(cursor.moveToFirst()){
           db.close()
           return Menu_DataFiles(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getBlob(3), cursor.getString(4), cursor.getInt(5))
       }
       else {
           db.close()
           return Menu_DataFiles(0, "No Product", 0, byteArrayOf(), "", 0)
       }
   }

    fun addMenuItem(menu: Menu_DataFiles): Long{
        val db: SQLiteDatabase = this.writableDatabase
        val cv: ContentValues = ContentValues();

        cv.put(columnName, menu.product_Name)
        cv.put(columnPrice, menu.product_Price)
        cv.put(columnImage, menu.product_image)
        cv.put(columnType, menu.product_type)
        cv.put(columnAvailable, 1)

        print(cv)
        var success = -1L
        try{
           success = db.insert(TableMenu, null, cv)
        }
        catch (e: SQLException){
            Log.e("SQLiteError", "Error inserting data: ${e.message}")
        }
        finally{
            db.close()
        }
        return success
    }

    fun getAllMenuItems(): List<Menu_DataFiles>{
        val menuList = mutableListOf<Menu_DataFiles>()
        val db: SQLiteDatabase = this.writableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TableMenu", null)

        cursor.use{
            while (it.moveToNext()){
                val id: Int = cursor.getInt(0)
                val itemName: String = cursor.getString(1)
                val price: Int = cursor.getInt(2)
                val itemImage: ByteArray? = cursor.getBlob(3)
                val type: String = cursor.getString(4)

                val menuItem = Menu_DataFiles(id, itemName, price, itemImage, type, 1)

                menuList.add(menuItem)
            }
        }
        cursor.close()

        return menuList
    }



}