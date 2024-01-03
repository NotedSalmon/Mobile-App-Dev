package com.example.wagonersexperts.Feedback

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

private val DataBaseName = "Wagon_Experts.db"
private val ver : Int = 1

class Feedback_DBHelper(context: Context) : SQLiteOpenHelper(context, DataBaseName, null, ver)
{
    public val Table_Feedback = "tblFeedback"
    public val column_ID = "feedbackID"
    public val column_User = "User"
    public val column_Feedback = "Feedback"
    public val column_Stars = "Stars"
    override fun onCreate(db: SQLiteDatabase?) {
        val sqlCreateStatement: String = "CREATE Table " + Table_Feedback + " ( " + column_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + column_User + " TEXT, " + column_Feedback +
                " TEXT, " + column_Stars + " INTEGER)"
        db?.execSQL(sqlCreateStatement)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun addFeedback(Feedback: Feedback_DataFiles) : Boolean {
        val db: SQLiteDatabase = this.writableDatabase
        val cv: ContentValues = ContentValues()

        cv.put(column_User, Feedback.usernameFeedback)
        cv.put(column_Feedback, Feedback.feedback)
        cv.put(column_Stars, Feedback.stars)

        val success = db.insert(Table_Feedback, null, cv)
        db.close()
        return success != -1L
    }

    fun getAllFeedback() : ArrayList<Feedback_DataFiles> {
        val feedbackList = ArrayList<Feedback_DataFiles>()
        val db: SQLiteDatabase = this.readableDatabase
        val sqlStatement = "SELECT * FROM $Table_Feedback"

        val cursor: Cursor = db.rawQuery(sqlStatement, null)

        if(cursor.moveToFirst())
            do {
                val id: Int = cursor.getInt(0)
                val User: String = cursor.getString(1)
                val Feedback: String = cursor.getString(2)
                val Stars: Int = cursor.getInt(3)

                val feedback = Feedback_DataFiles(id, User, Feedback, Stars)
                feedbackList.add(feedback)
            } while (cursor.moveToNext())
            cursor.close()
        db.close()

        return feedbackList
    }

}