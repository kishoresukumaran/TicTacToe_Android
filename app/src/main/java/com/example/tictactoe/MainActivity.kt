package com.example.tictactoe

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //Global variable for current game mode selected and the other game mode
    private var mCurrentPosition: Int = 1 // default and the first game mode selected
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv_1player = findViewById(R.id.tv_1player) as TextView
        val tv_2player = findViewById(R.id.tv_2player) as TextView
        val btn_play = findViewById(R.id.btn_play) as Button
        tv_1player.setOnClickListener(this)
        tv_2player.setOnClickListener(this)
        btn_play.setOnClickListener {
            val intent = Intent(this, GameScreen::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onClick(v: View?) {
        val tv_1player = findViewById(R.id.tv_1player) as TextView
        val tv_2player = findViewById(R.id.tv_2player) as TextView
        when (v?.id) {
            R.id.tv_1player -> {
                selectedOptionsView(tv_1player,1)
            }
            R.id.tv_2player -> {
                selectedOptionsView(tv_2player,2)
            }
        }
    }

    private fun selectedOptionsView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_gamemode_option
        )
    }

    private fun defaultOptionsView() {
        val tv_1player = findViewById(R.id.tv_1player) as TextView
        val tv_2player = findViewById(R.id.tv_2player) as TextView
        val options = ArrayList<TextView>()
        options.add(0,tv_1player)
        options.add(1,tv_2player)

        for (option in options) {
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,R.drawable.default_gamemode_option
            )
        }

    }
}