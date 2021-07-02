package com.example.bmiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var calculateButtonView: Button
    private lateinit var bmiTextView: TextView
    private lateinit var weightEditTextView: EditText
    private lateinit var heightEditTextView: EditText
    private lateinit var bmiImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateButtonView = findViewById(R.id.calculate_button)
        weightEditTextView = findViewById(R.id.weight_edit_text)
        heightEditTextView = findViewById(R.id.height_edit_text)
        bmiTextView = findViewById(R.id.bmi_text_view)
        bmiImageView = findViewById(R.id.bmi_image_view)

        calculateButtonView.setOnClickListener {
            calculateBmi()
        }
    }

    private fun calculateBmi() {
        if (weightEditTextView.text.isNotEmpty() && heightEditTextView.text.isNotEmpty()) {
            val weight = weightEditTextView.text.toString().toFloat()
            val height = heightEditTextView.text.toString().toFloat()

            val myBMI = (weight / (height * height))
            bmiTextView.text = myBMI.toString()
            when {
                myBMI <= 18.5 -> bmiImageView.setImageResource(R.drawable.underweight)
                myBMI in 18.5..24.9 -> bmiImageView.setImageResource(R.drawable.healthy)
                myBMI in 24.9..29.9 -> bmiImageView.setImageResource(R.drawable.overweight)
                myBMI >= 29.9 -> bmiImageView.setImageResource(R.drawable.obesity)
            }
        } else Toast.makeText(this, "Enter the needed fields", Toast.LENGTH_SHORT).show()
    }
}