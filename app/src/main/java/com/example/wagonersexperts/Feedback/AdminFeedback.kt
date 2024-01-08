package com.example.wagonersexperts.Feedback

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.R

class AdminFeedback: AppCompatActivity() {
    val dbHelper = Feedback_DBHelper(this)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceBundle: Bundle?){
        super.onCreate(savedInstanceBundle)
        setContentView(R.layout.activity_feedback)

        val listView = findViewById<ListView>(R.id.lstFeedback)

        val FeedbackList = dbHelper.getAllFeedback()

        val adapter = FeedbackAdapter(this, FeedbackList)

        listView.adapter = adapter

    }
}