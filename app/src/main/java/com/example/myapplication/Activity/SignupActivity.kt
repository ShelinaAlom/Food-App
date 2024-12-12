package com.example.myapplication.Activity

import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.myapplication.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : BaseActivity() {
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setVariables()
    }

    private fun setVariables() {
        binding.signup.setOnClickListener {
            val email = binding.useredit.text.toString()
            val password = binding.passedit.text.toString()

            if (password.length < 6) {
                Toast.makeText(this@SignupActivity, "Your password must be at least 6 characters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener(this@SignupActivity) { task ->
                if (task.isSuccessful) {
                    Log.i(tag, "onComplete: User created successfully")
                    startActivity(Intent(this@SignupActivity, MainActivity::class.java))
                } else {
                    Log.e(tag, "onComplete: Failure", task.exception)
                    Toast.makeText(this@SignupActivity, "Authentication failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
