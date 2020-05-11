package com.example.aboutm

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pressButton = findViewById<Button>(R.id.done_button)
        pressButton.setOnClickListener{addNickname(it)}

        findViewById<TextView>(R.id.nickname_text).setOnClickListener{updateNickName(it)}
    }

    private fun addNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        nicknameTextView.text = editText.text // Putting the value input by the user into
                                             // textview from editview
        editText.visibility = View.GONE  // We need to hide the editText as it is converted
                                        // into TextView
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
    }

    // Hide the keyboard(Both the lines are important)
//    val inputMethodManager = getSystemS ervice(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//    InputMethodService.hideSoftInputFromWindow(view.windowToken, 1)

    private fun updateNickName(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus() // Set the focus to the edit text.

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)

    }

}
