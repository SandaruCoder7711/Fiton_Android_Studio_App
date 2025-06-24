package com.example.snoozelog.viewmodel

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.snoozelog.R
import com.example.snoozelog.view.MainActivity

class Signin : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        editTextEmail = findViewById(R.id.editTextText47)
        editTextPassword = findViewById(R.id.editTextText46)
        val loginBtn = findViewById<Button>(R.id.loginBtn)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        loginBtn.setOnClickListener {
            val inputEmail = editTextEmail.text.toString().trim()
            val inputPassword = editTextPassword.text.toString().trim()

            if (inputEmail.isEmpty() || inputPassword.isEmpty()) {
                // Show a Toast message if any field is empty
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            } else {
                val savedEmail = sharedPreferences.getString("Email", "")
                val savedPassword = sharedPreferences.getString("Password", "")

                if (inputEmail == savedEmail && inputPassword == savedPassword) {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                    // Navigate to MainActivity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()  // Optional: close the Signin activity so the user can't go back to it
                } else {
                    Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
