package com.example.aboutm // Created on 11th May,2020

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutm.R
import com.example.aboutm.MyName
import com.example.aboutm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding// ( activity_main + Binding )
    private val myName: MyName = MyName("Suprabhat kumar")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        val pressButton =  binding.doneButton //findViewById<Button>(R.id.done_button)
        pressButton.setOnClickListener{addNickname(it)}

        //findViewById<TextView>(R.id.nickname_text)
            binding.nicknameText.setOnClickListener{updateNickName(it)}
    }

    //There is no change in functionality. Optionally, you can now eliminate the view parameter
    // and update all uses of view to use binding.doneButton inside this function.

    private fun addNickname(view: View){

        binding.apply {
        val editText =   binding.nicknameEdit //findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView =  binding.nicknameText //findViewById<TextView>(R.id.nickname_text)

       // binding.nicknameText.text = binding.nicknameEdit.text.toString()  // Putting the value input by the user into

           myName?.nickname = nicknameEdit.text.toString()       // textview from editview
//After the nickname is set, you want your code to refresh the UI with the new data. To do this, you must invalidate all binding expressions
// so that they are recreated with the correct data.
           invalidateAll()

           editText.visibility = View.GONE  // We need to hide the editText as it is converted
           // into TextView
           //view.visibility = View.GONE
           binding.doneButton.visibility = View.GONE

           nicknameTextView.visibility = View.VISIBLE
       }
       }

    // Hide the keyboard(Both the lines are important)
//    val inputMethodManager = getSystemS ervice(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//    InputMethodService.hideSoftInputFromWindow(view.windowToken, 1)

    private fun updateNickName(view: View){
        val editText = binding.nicknameEdit //findViewById<EditText>(R.id.nickname_edit)
        val doneButton = binding.doneButton //findViewById<Button>(R.id.done_button)

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus() // Set the focus to the edit text.
        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)

    }

}
