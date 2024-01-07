package com.example.wagonersexperts.Menu

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

private val DataBaseName = "Wagon_Experts.db"
private val ver : Int = 1

class Menu_DBHelper(context: Context) : SQLiteOpenHelper(context, DataBaseName, null, ver) {

    public val Table_Menu = "tblMenu"
    public val column_ID = "product_ID"
    public val column_Name = "ProductName"
    public val column_Price = "Price"
    public val column_Image = "Image"
    public val column_Type = "Type"
    public val column_Available = "Available"
    override fun onCreate(db: SQLiteDatabase?) {
        val sqlCreateStatement: String = "CREATE TABLE " + Table_Menu + " ( " + column_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + column_Name + " TEXT, " +
                column_Price + " INTEGER " + column_Image + " BLOB " + column_Type + " TEXT " + column_Available + " INTEGER )"
        db?.execSQL(sqlCreateStatement)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


    /**
     * Something along these lines below to get menu items.
     */
  // fun getMenuItems(btnMenuOption: String) : Menu_DataFiles {
  //     val db: SQLiteDatabase = this.writableDatabase
  //     val sqlStatement = "SELECT * FROM $Table_Menu WHERE $column_Type = $btnMenuOption AND $column_Available = 1"

  //     val cursor: Cursor = db.rawQuery(sqlStatement, null)
  //     if(cursor.moveToFirst()){
  //         db.close()
  //         return Menu_DataFiles(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getInt(4))
  //     }
  //     else {
  //         db.close()
  //         return Menu_DataFiles(0, "No Product", 0, "", 0)
  //     }
  // }

    fun addMenuItem(menu: Menu_DataFiles): Boolean{
        val db: SQLiteDatabase = this.writableDatabase
        val cv: ContentValues = ContentValues();

        cv.put(column_Name, menu.product_Name)
        cv.put(column_Price, menu.product_Price)
        cv.put(column_Image, menu.product_image)
        cv.put(column_Type, menu.product_type)
        cv.put(column_Available, menu.available)

        val success = db.insert(Table_Menu, null, cv)
        db.close()
        return success != -1L
    }




}