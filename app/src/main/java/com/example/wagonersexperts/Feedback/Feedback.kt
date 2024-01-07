package com.example.wagonersexperts.Feedback

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.wagonersexperts.MainActivity
import com.example.wagonersexperts.R

class Feedback : AppCompatActivity() {
    val dbHelper: Feedback_DBHelper = Feedback_DBHelper(this) //Defines dbHelper
    var currentUser: String = "" //Sets the variable currentUser as empty for now


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)
        currentUser = intent.getStringExtra("customer").toString() //Extracts the variable and places in the currentUser variable
    }
        /*
        This function uses (view: View) which means that in the activity_feedback, the Submit Feedback button has a OnClick listener that
        calls this function.

        This function takes in the EditText box and also the value from the rating bar and turns them into their respective data types
        and stores this data in the database along with the Username as to know which user sent which feedback.
         */
        fun btnSubmitFeedback(view: View)
        {
            val txtFeedback: EditText = findViewById(R.id.txtFeedback)
            val ratingBar: RatingBar = findViewById(R.id.ratingBar)
            val feedbackText = txtFeedback.text.toString()
            val rating = ratingBar.rating.toInt()

            val feedback = Feedback_DataFiles(0, currentUser, feedbackText, rating)

            if(rating == 4){
                sendNotification() //TESTING NOTIFICATIONS - DELETE AFTER
            }

            if(rating >= 1){ //If statement to make sure that the rating bar is not empty
                if(dbHelper.addFeedback(feedback)) {
                    Toast.makeText(this, "Feedback Submitted", Toast.LENGTH_LONG).show()
                }
                else Toast.makeText(this, "Error submitting form", Toast.LENGTH_LONG).show()
            }
            else Toast.makeText(this, "Please submit at least 1 star", Toast.LENGTH_LONG).show()
        }
        fun sendNotification(){
            // Inside your activity or wherever you want to trigger the notification
            val notificationId = 1

            val channelId = "777"
            val title = "Order Status Update"
            val contentText = "Order is being prepared"

            val notificationIntent = Intent(this, MainActivity::class.java) //Where I want the OnClick to send the user
            val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)

            val builder = NotificationCompat.Builder(this, channelId) //Builds the notification with the title/logo/priority
                .setSmallIcon(R.drawable.app_logo)
                .setContentTitle(title)
                .setContentText(contentText)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent) //Sets the intent as pendingIntent that sends user to another activity

            val notificationManager = NotificationManagerCompat.from(this)
            if (ActivityCompat.checkSelfPermission( //Checks permissions (They are always set to yes)
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            notificationManager.notify(notificationId, builder.build()) //Sends notification
        }

}
