package com.example.patryk.calcrpn

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.Ref

class MainActivity : AppCompatActivity() {

    private var numberToSend = ""
    private var calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            var color = Color.WHITE
            if((requestCode == 0) && (resultCode == Activity.RESULT_OK)) {
                if (data != null) {
                    if (data.hasExtra("Precission")) {
                        //calculator.SetPrecission("Precission")
                        calculator.SetPrecission((data.getStringExtra("Precission")))
                    }
                    if (data.hasExtra("Color")) {
                        var colorString = data.getStringExtra("Color")
                        when (colorString) {
                            "Red" -> {
                                color = Color.RED
                            }
                            "White" ->{
                                color = Color.WHITE
                            }
                            "Green" ->{
                                color = Color.GREEN
                            }
                        }
                        textView.setBackgroundColor(color)
                        textViewCurrentText.setBackgroundColor(color)
                    }
                }
            }
        RefreshTextView()
    }

    public fun OpenSetting(v:View){
        val intent = Intent(this,SettingsActivity::class.java)
        intent.putExtra("Calc", calculator)
        startActivityForResult(intent,0);
    }

    public fun AddOne(v: View){
        numberToSend += "1"
        SetValue()
    }

    public fun AddTwo(v: View){
        numberToSend += "2"
        SetValue()
    }

    public fun AddThree(v: View){
        numberToSend += "3"
        SetValue()
    }

    public fun AddFour(v: View){
        numberToSend += "4"
        SetValue()
    }

    public fun AddFive(v: View){
        numberToSend += "5"
        SetValue()
    }

    public fun AddSix(v: View){
        numberToSend += "6"
        SetValue()
    }

    public fun AddSeven(v: View){
        numberToSend += "7"
        SetValue()
    }

    public fun AddEight(v: View){
        numberToSend += "8"
        SetValue()
    }

    public fun AddNine(v: View){
        numberToSend += "9"
        SetValue()
    }

    public fun AddZero(v:View){
        numberToSend +="0"
        SetValue()
    }

    public fun AddPoint(v:View){
        if(!numberToSend.contains("."))
        {
            numberToSend += "."
        }
        SetValue()
    }

    public fun AddElement(v: View){
        calculator.AddToStack(numberToSend)
        ClearValue()
        RefreshTextView()
    }

    public fun RemoveLastElement(v: View){
        calculator.DropWithStack()
        RefreshTextView()
    }

    public fun ClearElement(v:View){
        calculator.ClearStack()
        RefreshTextView()
    }

    public fun DeleteDigit(v:View){
        if(numberToSend.length == 0)
            return
        numberToSend = numberToSend.dropLast(1)
        SetValue()
    }

    public fun UndoOperation(v: View){
        calculator.UndoOperation()
        RefreshTextView(true)
    }

    public fun SwapElement(v:View){
        calculator.SwapStack()
        RefreshTextView()
    }

    public fun ChangeSign(v:View){
        calculator.ChangeSignLastElemt()
        RefreshTextView()
    }

    public fun Sum(v: View){
        calculator.OperationOnStack(Operation.Sum)
        RefreshTextView()
    }

    public  fun Minus(v:View){
        calculator.OperationOnStack(Operation.Minus)
        RefreshTextView()
    }

    public fun Devided(v:View){
        calculator.OperationOnStack(Operation.Devided)
        RefreshTextView()
    }

    public fun Multiple(v:View){
        calculator.OperationOnStack(Operation.Multiple)
        RefreshTextView()
    }

    public fun Power(v:View){
        calculator.OperationOnStack(Operation.Power)
        RefreshTextView()
    }

    public fun Sqrt(v:View){
        calculator.OperationOnStack(Operation.Sqrt)
        RefreshTextView()
    }

    private fun SetValue(){
        textViewCurrentText.text = numberToSend
    }

    private fun ClearValue(){
        numberToSend = ""
    }

    private fun RefreshTextView(isUndo  : Boolean = false){
        SetValue()
        textView.text = calculator.GetStack(isUndo)
        textViewCountStack.text = calculator.GetCountStack()
    }

}


