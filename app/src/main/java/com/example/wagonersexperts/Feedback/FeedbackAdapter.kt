package com.example.wagonersexperts.Feedback

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RatingBar
import android.widget.TextView
import com.example.wagonersexperts.R


class FeedbackAdapter (context: Activity, private val Feedback: List<Feedback_DataFiles>) :ArrayAdapter<Feedback_DataFiles>(context, R.layout.feedback_list){
    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View{
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate((R.layout.feedback_list), null)

        val feedback : TextView = view.findViewById(R.id.txtUserFeedback)
        val rating: RatingBar = view.findViewById(R.id.FeedbackRating)

        feedback.text = Feedback[position].feedback
        rating.numStars = Feedback[position].stars

        return view
    }

}