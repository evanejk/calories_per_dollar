package com.happynicetime.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class WeightLossCalcActivity : AppCompatActivity() {
    private lateinit var editTextWeight: EditText
    private lateinit var editTextCalories: EditText
    private lateinit var textViewResults: TextView
    private lateinit var buttonCompute: Button
    private lateinit var buttonClear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wight_loss_calc)
        editTextWeight = findViewById<EditText>(R.id.numberWeightWL)
        editTextCalories = findViewById<EditText>(R.id.numberCaloritesWL)
        textViewResults = findViewById<TextView>(R.id.textViewWeightLossScore)
        buttonCompute = findViewById<Button>(R.id.buttonComputeWL)
        buttonClear = findViewById<Button>(R.id.buttonClearWL)

        buttonCompute.setOnClickListener{
            //println("clicked on button")
            // Check if any EditText fields are empty
            if (editTextWeight.getText().isEmpty() || editTextCalories.getText().isEmpty()) {
                textViewResults.setText("please enter values for all fields");
            }else {
                var weight = editTextWeight.getText().toString().toDouble()
                var caloriesPerServing = editTextCalories.getText().toString().toDouble()
                var score = weight / caloriesPerServing
                score = score * 10
                textViewResults.setText("$score g/10cals")
            }
        }
        buttonClear.setOnClickListener{
            editTextWeight.setText("")
            editTextCalories.setText("")
            editTextWeight.requestFocus()
            textViewResults.setText("____ g/10cals")
        }
    }
}