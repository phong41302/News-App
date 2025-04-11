package com.example.newsapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.R

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var signInText: TextView
    private lateinit var goToRegisterText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        registerButton = findViewById(R.id.register_button)
        signInText = findViewById(R.id.sign_in)
        goToRegisterText = findViewById(R.id.go_to_register)

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Vui lòng nhập email và mật khẩu", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, NewsActivity::class.java) // ✅ chuyển sang NewsActivity
                startActivity(intent)
                finish()
            }
        }

        signInText.setOnClickListener {
            Toast.makeText(this, "Tính năng đang phát triển!", Toast.LENGTH_SHORT).show()
        }

        goToRegisterText.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
