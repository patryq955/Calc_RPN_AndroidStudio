package com.example.patryk.calcrpn

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_settings.*
import java.util.*
import kotlin.math.pow
import kotlin.math.sign
import kotlin.math.sqrt
import android.content.Intent.getIntent
import android.graphics.Color
import android.graphics.Movie
import android.net.Uri
import android.os.ResultReceiver


class SettingsActivity : AppCompatActivity() {


     private var calculator = Calculator()
     private var key : String =""
     private var value : String =""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        var tmp = intent.extras.getSerializable("Calc") as Calculator
        radioGroup.check(redRadioButton.id)
        tmp.AddToStack("111")
    }

    public fun ChangePrecission (v:View){
        value = editTextPrecission.text.toString()
        val data = Intent()
        data.putExtra("Precission",value)
        setResult(Activity.RESULT_OK,data)
        finish()
    }

    public  fun ChangeColor(v:View){
        val data = Intent()
        val color: String
        when(radioGroup.checkedRadioButtonId){
            redRadioButton.id ->{
                color = "Red"
            }
            whiteRadioButton.id ->{
                color = "White"
            }
            greenRadioButton.id ->{
                color = "Green"
            }
            else ->{
                color = "White"
            }
        }
        data.putExtra("Color", color)
        setResult(Activity.RESULT_OK,data)
        finish()
    }

}
