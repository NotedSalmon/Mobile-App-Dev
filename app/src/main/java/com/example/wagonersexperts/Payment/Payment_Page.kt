package com.example.wagonersexperts.Payment

import android.Manifest
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.wagonersexperts.MainActivity
import com.example.wagonersexperts.Menu.Menu_DBHelper
import com.example.wagonersexperts.Orders.TestOrder
import com.example.wagonersexperts.R

class Payment_Pay : AppCompatActivity() {
    private lateinit var editTextCardNumber: EditText
    private lateinit var editTextExpiryDate: EditText
    private lateinit var editTextCVV: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        editTextCardNumber = findViewById(R.id.editTextCardNumber)
        editTextExpiryDate = findViewById(R.id.editTextExpiryDate)
        editTextCVV = findViewById(R.id.editTextCVV)


    }

    fun btnMakePayment(view: View){
        val cardNumber = editTextCardNumber.text.toString()
        val expiryDate = editTextExpiryDate.text.toString()
        val cvv = editTextCVV.text.toString()

        // Validate card details (You should perform more robust validation in a real application)
        if (cardNumber.isNotEmpty() && expiryDate.isNotEmpty() && cvv.isNotEmpty()) {
            //Would send to the database and sends notification to the user
            sendNotification()
            Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show()
        } else {
            // Display an error message if any of the fields are empty
            Toast.makeText(this, "Please enter valid card details", Toast.LENGTH_SHORT).show()
        }
    }

    fun sendNotification(){ //Sends notification to the user
        val notificationId = 1

        val channelId = "777"
        val title = "Payment Accepted"
        val contentText = "Order is being prepared"

        val notificationIntent = Intent(this, TestOrder::class.java) //Where I want the OnClick to send the user
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
