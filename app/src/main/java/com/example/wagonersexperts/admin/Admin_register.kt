package com.example.wagonersexperts.admin

import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wagonersexperts.admin.Admin_db.AdminData
import com.example.wagonersexperts.admin.Admin_db.Admin_DBHelper
import com.example.wagonersexperts.R

class AdminRegister : AppCompatActivity() {

   // val dbHelper = Admin_DBHelper(this)
   // override fun onCreate(savedInstanceState: Bundle?){
   //     super.onCreate(savedInstanceState)
   //     setContentView(R.layout.activity_admin_register)
   // }
   // fun btnAdminRegister(){
   //     val adminFullName = findViewById<EditText>(R.id.txtAdminName).toString()
   //     val adminEmail = findViewById<EditText>(R.id.txtAdminEmail).toString()
   //     val adminPhoneNo = findViewById<EditText>(R.id.txtAdminPhone).toString()
   //     val adminUserName = findViewById<EditText>(R.id.txtUserName).toString()
   //     val adminPassword = findViewById<EditText>(R.id.txtAdminPassword).toString()
   //     val adminActive = findViewById<CheckBox>(R.id.chkAdminActive).isChecked
   //     val adminHasPriviliges = findViewById<CheckBox>(R.id.chkAdminPriveleges).isChecked
//
   //     val Admin = AdminData(0, adminFullName, adminEmail, adminPhoneNo, adminUserName, adminPassword, adminActive, adminHasPriviliges)
   //     if(dbHelper.addAdmin(Admin)) {
   //         Toast.makeText(this, "Account creation successful", Toast.LENGTH_SHORT).show()
   //     }
   //     else{
   //         Toast.makeText(this, "Account creation failed", Toast.LENGTH_SHORT).show()
   //     }
   // }
}



