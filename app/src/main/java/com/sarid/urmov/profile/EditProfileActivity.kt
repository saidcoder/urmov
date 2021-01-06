package com.sarid.urmov.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sarid.urmov.R
import com.sarid.urmov.sign.signin.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_edit_profile.btn_home
import kotlinx.android.synthetic.main.activity_edit_profile.et_email
import kotlinx.android.synthetic.main.activity_edit_profile.et_nama
import kotlinx.android.synthetic.main.activity_edit_profile.et_password
import kotlinx.android.synthetic.main.activity_edit_profile.et_username
import kotlinx.android.synthetic.main.activity_edit_profile.imageView3

class EditProfileActivity : AppCompatActivity() {
    lateinit var mDatabase: DatabaseReference
    private var dataList = ArrayList<User>()

    lateinit var sUsername:String
    lateinit var sPassword:String
    lateinit var sNama:String
    lateinit var sEmail:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val data = intent.getParcelableExtra<User>("data")

        mDatabase = FirebaseDatabase.getInstance().getReference("User")
                .child(data.email.toString())

//        et_username.text = data.username
//        et_password.text = data.password
//        et_nama.text = data.nama
//        et_email.text = data.email


        btn_home.setOnClickListener {
            sUsername = et_username.text.toString()
            sPassword = et_password.text.toString()
            sNama = et_nama.text.toString()
            sEmail = et_email.text.toString()

            if (sUsername.equals("")) {
                et_username.error = "Silahkan isi Username"
                et_username.requestFocus()
            } else if (sPassword.equals("")) {
                et_password.error = "Silahkan isi Password"
                et_password.requestFocus()
            } else if (sNama.equals("")) {
                et_nama.error = "Silahkan isi Nama"
                et_nama.requestFocus()
            } else if (sEmail.equals("")) {
                et_email.error = "Silahkan isi Email"
                et_email.requestFocus()
            } else {

                var statusUsername = sUsername.indexOf(".")
                if (statusUsername >=0) {
                    et_username.error = "Silahkan tulis Username Anda tanpa ."
                    et_username.requestFocus()
                } else {
                    saveUser(sUsername, sPassword, sNama, sEmail)
                }

            }
        }

        imageView3.setOnClickListener {
            finish()
        }

    }
}

private fun saveUser(sUsername: String, sPassword: String, sNama: String, sEmail: String) {

    val user = User()
    user.email = sEmail
    user.username = sUsername
    user.nama = sNama
    user.password = sPassword



}

