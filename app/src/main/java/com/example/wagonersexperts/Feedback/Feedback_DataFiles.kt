package com.example.wagonersexperts.Feedback

data class Feedback_DataFiles(
    val feedbackID: Int,
    val usernameFeedback: String,
    val feedback: String,
    val stars: Int
) {
    override fun toString(): String {
        return "User:'$usernameFeedback', Feedback:'$feedback', Stars:'$stars'"
    }
}
