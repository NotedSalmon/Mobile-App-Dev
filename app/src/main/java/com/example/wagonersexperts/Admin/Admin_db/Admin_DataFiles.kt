package com.example.wagonersexperts.Admin.Admin_db

data class Admin_DataFiles(
    val AdminId: Int,
    val AdminFullName: String,
    val AdminEmail: String,
    val AdminPhoneNo: String,
    val AdminUserName: String,
    val AdminPassword: String,
    val AdminActive: Boolean,
    val AdminPriveleges: Boolean,
) {

    override fun toString(): String{
        return "Admin(AdminName='$AdminFullName', AdminEmail='$AdminFullName', AdminPhoneNo='$AdminPhoneNo', AdminUserName='$AdminUserName', AdminPassword='$AdminPassword', AdminActive='$AdminActive', AdminHasPriviliges='$AdminPriveleges'"
    }
}