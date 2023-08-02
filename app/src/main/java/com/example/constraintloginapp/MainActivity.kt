package com.example.constraintloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var pwd: EditText
    private lateinit var login: Button
    private lateinit var register: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name_et)
        pwd = findViewById(R.id.pwd_et)
        login = findViewById(R.id.login_btn)
        register = findViewById(R.id.register_tv)

        login.setOnClickListener {
           val name = name.text.toString().trim()
           val pwd = pwd.text.toString()

            if(name.isEmpty() && pwd.isEmpty()) {
                showToast("Please enter Username and password")
            } else if (pwd.isEmpty()){
                showToast("Please enter Password")
            }else if (name.isEmpty()){
                showToast("Please enter username")
            } else if (name.isNotEmpty() && pwd.isNotEmpty()){
                if(passwordValidate(pwd)){
                    showToast("Password is valid")
                } else {
                    showToast("Password should contain atleast 1 small letter, 1 capital letter, 1 number and 1 special character and length should be 6-8 characters.")
                }
            }else {
                val intent = Intent(this,MainActivity2::class.java )
                startActivity(intent)
            }


        }
    }

    private fun passwordValidate(pwd: String): Boolean {
        val minLength = 6
        val maxLength = 8
        val pwdLength = pwd.length
        val regexPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,8}$"
//        return pwdLength in minLength..maxLength
        if (pwdLength < minLength || pwdLength > maxLength) {
            return false
        }
        val regex = Regex(regexPattern)
        return regex.matches(pwd)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}