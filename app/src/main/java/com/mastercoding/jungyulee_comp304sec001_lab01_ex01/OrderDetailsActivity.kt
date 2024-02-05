package com.mastercoding.jungyulee_comp304sec001_lab01_ex01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class OrderDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        val editTextProductName = findViewById<EditText>(R.id.editTextProductName)
        val editTextPrice = findViewById<EditText>(R.id.editTextPrice)
        val editTextQuantity = findViewById<EditText>(R.id.editTextQuantity)

        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)

        val textViewOutput = findViewById<TextView>(R.id.textViewOutput)

        buttonCalculate.setOnClickListener() {
            var intent = intent

            // retrieve the data from the intent
            var fullName = intent.getStringExtra("FULL_NAME")
            var email = intent.getStringExtra("EMAIL")
            var address = intent.getStringExtra("ADDRESS")

            var productName = editTextProductName.text.toString()

            // price validations
            var priceText = editTextPrice.text.toString()
            var price: Double? = null
            try {
                price = priceText.toDouble()
                if (price <= 0) {
                    // invalid price (less than or equal to 0)
                    editTextPrice.error = "Price must be greater than 0"
                    return@setOnClickListener
                }
            } catch (e: NumberFormatException) {
                // invalid number format for price
                editTextPrice.error = "Please enter a valid price"
                return@setOnClickListener
            }

            // quantity validations
            var quantityText = editTextQuantity.text.toString()
            var quantity: Int? = null
            try {
                quantity = quantityText.toInt()
                if (quantity < 1 || quantity > 10) {
                    //invalid quantity (less than 1 or greater than 10)
                    editTextQuantity.error = "Quantity must be between 1 and 10"
                    return@setOnClickListener
                }
            } catch (e: NumberFormatException) {
                // invalid number format for quantity
                editTextQuantity.error = "Please enter a valid quantity"
                return@setOnClickListener
            }

            var total = price * quantity

            // create the output text
            var outputText = "Full Name: $fullName" +
                    "\nEmail: $email" +
                    "\nAddress: $address" +
                    "\nProduct Name: $productName" +
                    "\nPrice: $price" +
                    "\nQuantity: $quantity" +
                    "\nTotal: $total"

            // display the output inside the textView
            textViewOutput.text = outputText

            // display using Toast as well
            Toast.makeText(this, outputText, Toast.LENGTH_SHORT).show()

        }
    }
}