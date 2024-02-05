package com.mastercoding.jungyulee_comp304sec001_lab01_ex01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CustomerDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_details)

        val editTextFullName = findViewById<EditText>(R.id.editTextFullName)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextAddress = findViewById<EditText>(R.id.editTextAddress)

        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        buttonLogin.setOnClickListener() {
            // navigate to OrderDetailsActivity
            intent = Intent(this, OrderDetailsActivity::class.java).apply {
                // pass the intent object to startActivity method
                putExtra("FULL_NAME", editTextFullName.text.toString())
                putExtra("EMAIL", editTextEmail.text.toString())
                putExtra("ADDRESS", editTextAddress.text.toString())
            }
            startActivity(intent)
        }
    }
}