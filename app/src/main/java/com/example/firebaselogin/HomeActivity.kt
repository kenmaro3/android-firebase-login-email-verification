package com.example.firebase_realtime1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
        val signOutButton = findViewById<Button>(R.id.signOutButton)

        auth = FirebaseAuth.getInstance()

        val user = auth.currentUser
        user?.let {
            welcomeTextView.text = "Welcome, ${user.email}"
        }

        signOutButton.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
