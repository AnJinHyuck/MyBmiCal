package com.example.mybmi_calcualtor

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.round

class ResultActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        //BMI 계산
        var value = weight / (height/100.0).pow(2.0)
        value = round(value * 10)/10

        var resultText = ""
        var resultImage = 0
        var resultColor = 0

        if (value < 18.5) {
            resultText = "저체중"
            resultImage = R.drawable.level1
            resultColor = Color.YELLOW
        } else if (value >= 18.5 && value < 23.0) {
            resultText = "정상 체중"
            resultImage = R.drawable.level2
            resultColor = Color.GREEN
        } else if (value >= 23.0 && value < 25.0) {
            resultText = "과체중"
            resultImage = R.drawable.level3
            resultColor = Color.BLACK
        } else if (value >= 25.5 && value < 30.0) {
            resultText = "경도 비만"
            resultImage = R.drawable.level4
            resultColor = Color.BLUE
        } else if (value >= 30.0 && value < 35.0) {
            resultText = "고도 비만"
            resultImage = R.drawable.level5
            resultColor = Color.MAGENTA
        }
        val tv_resValue =  findViewById<TextView>(R.id.tv_resValue)
        val tv_resText =  findViewById<TextView>(R.id.tv_resText)
        val tv_image =  findViewById<ImageView>(R.id.iv_image)
        val btn_back = findViewById<Button>(R.id.btn_Back)

            tv_resValue.text = value.toString()
            tv_resText.text = resultText
            tv_image.setImageResource(resultImage)
            tv_resText.setTextColor(resultColor)

            btn_back.setOnClickListener {
                finish()
            }
    }
}