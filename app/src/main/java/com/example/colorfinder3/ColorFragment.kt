package com.example.colorfinder3

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.SurfaceView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_layout.*
import java.lang.ClassCastException

class ColorFragment : AppCompatActivity() {

    var value1 = 0
    var value2 = 0
    var value3 = 0

    var value = intArrayOf(0, 0, 0)


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_layout)
        //setSupportActionBar(toolbar)


        //val view = inflater?.inflate(R.layout.fragment_layout, container, false)




        val seekBar1 = this.findViewById<SeekBar>(R.id.SeekBarRed)
        val seekBar2 = this.findViewById<SeekBar>(R.id.SeekBarGreen)
        val seekBar3 = this.findViewById<SeekBar>(R.id.SeekBarBlue)

        val seekVal1 = this.findViewById<TextView>(R.id.SeekValRed)
        val seekVal2 = this.findViewById<TextView>(R.id.SeekValGreen)
        val seekVal3 = this.findViewById<TextView>(R.id.SeekValBlue)

        seekBar1.progress = value1
        seekBar2.progress = value2
        seekBar3.progress = value3

        val surface4 = this.findViewById<SurfaceView>(R.id.surfaceView)

        //val doneButton: Button? = view?.findViewById(R.id.save)

        //***************************************************************************
        // Seek bar 1 controls
        seekBar1?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onProgressChanged(seekBar: SeekBar?, i: Int, b: Boolean) {
                value1 = i
                seekVal1?.text = "$value1"
                seekVal1?.setTextColor(Color.rgb(value1, 0, 0))
                surface4?.setBackgroundColor(Color.rgb(value1, value2, value3))
                value[0] = i
                //activityCallback?.onButtonCl
            }
        })
        //****************************************************************************
        // Seek bar 2 controls

        seekBar2?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onProgressChanged(seekBar: SeekBar?, i: Int, b: Boolean) {
                value2 = i
                seekVal2?.text = "$value2"
                seekVal2?.setTextColor(Color.rgb(0, value2, 0))
                surface4?.setBackgroundColor(Color.rgb(value1, value2, value3))
                value[1] = i
            }
        })
        //***************************************************************************
        // Seek bar 3 controls
        seekBar3?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar?) {} // unused
            override fun onStartTrackingTouch(seekBar: SeekBar?) {} // unused
            override fun onProgressChanged(seekBar: SeekBar?, i: Int, b: Boolean) {
                value3 = i
                seekVal3?.text = "$value3"
                seekVal3?.setTextColor(Color.rgb(0, 0, value3))
                surface4?.setBackgroundColor(Color.rgb(value1, value2, value3))
                value[2] = i
            }
        })
        //***************************************************************************

        //doneButton?.setOnClickListener { doneButtonClicked(it) }

        //return inflater.inflate(R.layout.fragment_layout, container, false)

    } // End of on_Create
/*
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    */
/*
    private fun doneButtonClicked(view: View) {
        activityCallback?.onDoneClick1(value)
    }
*/



}


