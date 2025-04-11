package com.example.newsapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.R

class RegisterActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var signInText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ẮN đúng layout activity_register.xml
        setContentView(R.layout.acitivity_register)

        // Ánh xạ view
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        confirmPasswordEditText = findViewById(R.id.confirm_password)
        registerButton = findViewById(R.id.register_button)
        signInText = findViewById(R.id.sign_in)

        // Đăng ký
        registerButton.setOnClickListener {
            registerUser()
        }

        // Chuyển qua LoginActivity
        signInText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun registerUser() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val confirmPassword = confirmPasswordEditText.text.toString()

        if (email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show()

        // Chuyển sang LoginActivity sau khi đăng ký
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
