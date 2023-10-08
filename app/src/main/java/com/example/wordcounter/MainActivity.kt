package com.example.wordcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInput = findViewById<EditText>(R.id.text_input)
        val charSpinner = findViewById<Spinner>(R.id.char_spinner)
        val countButton = findViewById<Button>(R.id.count_button)
        val countResultView = findViewById<TextView>(R.id.count_result_view)

        // Populate the Spinner object
        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter.createFromResource(
                this,
                R.array.count_options,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            charSpinner.adapter = adapter
        }

        countButton.setOnClickListener {
            val textInputString = textInput.text.toString()
            val chosenOptionSpinner = charSpinner.selectedItem.toString()
            var count = 0

            val resources = resources
            val countOptionsArray = resources.getStringArray(R.array.count_options)

            if (chosenOptionSpinner == countOptionsArray[0]){
                count = WordCounter.getWordCount(textInputString)
            }
            else if(chosenOptionSpinner == countOptionsArray[1]){
                count = WordCounter.getCharCount(textInputString)
            }
            countResultView.text = count.toString()
        }
    }
}