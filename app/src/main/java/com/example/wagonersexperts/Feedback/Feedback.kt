package com.example.wagonersexperts.Feedback

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.R

class Feedback : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        val txtFeedback: EditText = findViewById(R.id.txtFeedback)
        val ratingBar: RatingBar = findViewById(R.id.ratingBar)
        val btnSubmitFeedback: Button = findViewById(R.id.btnSubmitFeedback)

        btnSubmitFeedback.setOnClickListener {
            val feedbackText = txtFeedback.text.toString()
            val rating = ratingBar.rating

            // TODO: Save feedback into another DB Table?

            Toast.makeText(
                this,
                "Feedback submitted. Thank You",
                Toast.LENGTH_SHORT
            ).show()
        }

        fun btnSubmitFeedback(view: View)
        {

        }
    }
}
