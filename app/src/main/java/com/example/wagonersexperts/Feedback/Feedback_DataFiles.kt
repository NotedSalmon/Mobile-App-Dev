package com.example.wagonersexperts.Feedback

//Data class for Feedback table, includes the Username for identification of who sent the feedback.
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
