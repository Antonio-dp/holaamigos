package com.example.examenu2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.principal)

        val button: Button = findViewById(R.id.button_detalles)
        button.setOnClickListener {
            var intent: Intent = Intent(this, detalles::class.java)
            startActivity(intent)
        }
    }
}