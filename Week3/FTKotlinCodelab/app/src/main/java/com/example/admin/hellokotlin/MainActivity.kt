package com.example.admin.hellokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.tvMain

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toastMe(view: View) {
        val myToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun countMe(view: View) {
        //By importing the tvMain i get access to it

        //Get the text view
//        val showCountTextView = findViewById(R.id.tvMain) as TextView

        //Get the value of the text view
//        val countString = showCountTextView.text.toString()
        val countString = tvMain.text.toString()

        //Conver value to a number and increment it
        var count: Int = Integer.parseInt(countString)
        count++

        //Display the new value in the text view
//        showCountTextView.text = count.toString()
        tvMain.text = count.toString()

    }



    fun randomMe(view: View) {
        val count = Integer.parseInt(tvMain.text.toString())

        val randomIntent = Intent(this, SecondActivity::class.java)
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)
        startActivity(randomIntent)
    }
}
