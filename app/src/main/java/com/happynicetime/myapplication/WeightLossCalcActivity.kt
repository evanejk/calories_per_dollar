package com.happynicetime.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class WeightLossCalcActivity : AppCompatActivity() {
    private lateinit var editTextNetWeight: EditText
    private lateinit var editTextServings: EditText
    private lateinit var editTextCalories: EditText
    private lateinit var textViewResults: TextView
    private lateinit var buttonCompute: Button
    private lateinit var buttonClear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wight_loss_calc)
        editTextNetWeight = findViewById<EditText>(R.id.numberNetWeightWL)
        editTextServings = findViewById<EditText>(R.id.numberServingsPerContainerWL)
        editTextCalories = findViewById<EditText>(R.id.numberCaloritesWL)
        textViewResults = findViewById<TextView>(R.id.textViewWeightLossScore)
        buttonCompute = findViewById<Button>(R.id.buttonComputeWL)
        buttonClear = findViewById<Button>(R.id.buttonClearWL)

        buttonCompute.setOnClickListener{
            //println("clicked on button")
            // Check if any EditText fields are empty
            if (editTextNetWeight.getText().isEmpty() || editTextServings.getText().isEmpty() || editTextCalories.getText().isEmpty()) {
                textViewResults.setText("please enter values for all fields");
            }else {
                var netWeight = editTextNetWeight.getText().toString().toDouble()
                var servingsPerContainer = editTextServings.getText().toString().toDouble()
                var caloriesPerServing = editTextCalories.getText().toString().toDouble()
                var score = netWeight / (servingsPerContainer * caloriesPerServing)
                score = score * 10
                textViewResults.setText("$score dag/c")
            }
        }
        buttonClear.setOnClickListener{
            editTextNetWeight.setText("")
            editTextServings.setText("")
            editTextCalories.setText("")
            editTextNetWeight.requestFocus()
            textViewResults.setText("____ dag/c")
        }
    }
}