package com.happynicetime.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.happynicetime.myapplication.R.id.numberInputServings
import com.happynicetime.myapplication.R.id.numberInputCalories
import com.happynicetime.myapplication.R.id.numberInputPrice
import com.happynicetime.myapplication.R.id.resultsText

class MainActivity : AppCompatActivity() {
    private lateinit var buttonCompute: Button
    private lateinit var buttonClear: Button
    private lateinit var editTextNumberInputServings: EditText
    private lateinit var editTextNumberInputCalories: EditText
    private lateinit var editTextNumberInputPrice: EditText
    private lateinit var textViewResults: TextView
    private lateinit var buttonWeightLossCalc: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumberInputServings = findViewById<EditText>(numberInputServings)
        editTextNumberInputCalories = findViewById<EditText>(numberInputCalories)
        editTextNumberInputPrice = findViewById<EditText>(numberInputPrice)
        textViewResults = findViewById<TextView>(resultsText)

        //computeButton = R.id.buttonCompute
        buttonCompute = findViewById<Button>(R.id.buttonCompute)
        buttonCompute.setOnClickListener{
            //println("clicked on button")
            // Check if any EditText fields are empty
            if (editTextNumberInputServings.getText().isEmpty() || editTextNumberInputCalories.getText().isEmpty() || editTextNumberInputPrice.getText().isEmpty()) {
                textViewResults.setText("please enter values for all fields");
            }else {
                var servings = editTextNumberInputServings.getText().toString().toDouble()
                var calories = editTextNumberInputCalories.getText().toString().toDouble()
                var containerPrice = editTextNumberInputPrice.getText().toString().toDouble()
                var caloriesPerDollar = (servings * calories) / containerPrice

                textViewResults.setText("$caloriesPerDollar calories per dollar")
            }
        }
        buttonClear = findViewById<Button>(R.id.buttonClear)
        buttonClear.setOnClickListener{
            editTextNumberInputServings.setText("")
            editTextNumberInputCalories.setText("")
            editTextNumberInputPrice.setText("")
            editTextNumberInputPrice.requestFocus()
            textViewResults.setText("____ calories per dollar")
        }
        buttonWeightLossCalc = findViewById<Button>(R.id.buttonWeightLossCalculator)
        buttonWeightLossCalc.setOnClickListener(){
            //println("wlc button pressed")
            val intent: Intent = Intent(this, WeightLossCalcActivity::class.java)
            startActivity(intent)
        }
    }
}