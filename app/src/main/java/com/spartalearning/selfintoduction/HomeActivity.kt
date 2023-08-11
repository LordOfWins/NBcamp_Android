package com.spartalearning.selfintoduction

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

class HomeActivity : AppCompatActivity() {
    private lateinit var terminate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        terminate = findViewById<Button>(R.id.terminate)

        val id = findViewById<TextView>(R.id.myId)
        val name= findViewById<TextView>(R.id.myName)
        val age=findViewById<TextView>(R.id.myAge)
        val mbti = findViewById<TextView>(R.id.myMbti)

        if (intent.hasExtra("id")) {
            id.text = "아이디 : " + intent.getStringExtra("id")
        }
        mbti.text = "MBTI : " + generateRandomMBTI()


        val photo = findViewById<ImageView>(R.id.profile)

        val profile = when ((1..6).random()) {
            1 -> R.drawable.pexels_ahmet_kurt_12662274
            2 -> R.drawable.pexels_baptiste_8829108
            3 -> R.drawable.pexels_damir_16432792
            4 -> R.drawable.pexels_marta_dzedyshko_16762858
            else -> {
                R.drawable.flower_7909902_1280
            }
        }

        photo.setImageDrawable(ResourcesCompat.getDrawable(resources, profile, null))
    }

    fun end(view: View) {
        finish()
    }

    fun generateRandomMBTI(): String {
        val firstLetterList = listOf("I", "E")
        val secondLetterList = listOf("S", "N")
        val thirdLetterList = listOf("T", "F")
        val fourthLetterList = listOf("P", "J")

        val firstLetter = firstLetterList.random()
        val secondLetter = secondLetterList.random()
        val thirdLetter = thirdLetterList.random()
        val fourthLetter = fourthLetterList.random()

        return "$firstLetter$secondLetter$thirdLetter$fourthLetter"
    } }