package com.example.colorfinder3

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.SurfaceView
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.io.Serializable


class MainActivity : AppCompatActivity() {

    //private var frag1: Fragment? = null // fragment to call

    var textValue = 0
    //these arrays are the ones that need to be changed
    //you just need to get the saved color from the other ap and change these array values
    var color1 = intArrayOf(100, 5, 239)
    var color2 = intArrayOf(100, 150, 20)
    //this array is for the merged one
    var color3 = intArrayOf(0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button1 = this.findViewById<Button>(R.id.pick1)


        var surface1 = this.findViewById<SurfaceView>(R.id.mirror)
        var surface2 = this.findViewById<SurfaceView>(R.id.mirror2)
        var seekBar1 = this.findViewById<SeekBar>(R.id.seekBar)
        var colorVal = this.findViewById<TextView>(R.id.seekView)
        //seekBar1.progress = seekView
        mirror.setBackgroundColor(Color.rgb(color1[0], color1[1], color1[2]))
        mirror2.setBackgroundColor(Color.rgb(color2[0], color2[1], color2[2]))
        colorVal.text = textValue.toString()

        button1.setOnClickListener {
            val intent = Intent(this, ColorFragment :: class.java)
            var col1 = intArrayOf(0, 0, 0)
            val red = "0"
            val blue = "0"
            val green = "0"
            //intent.putExtra("red", red)
            //intent.putExtra("blue", blue)
            //intent.putExtra("green", green)
            intent.putExtra("col1", color1)

            startActivity(intent)


            /////////////////////////////////////
            //data class Attachment(val name: String, val Content: String) : Serializable
            /////////////////////////////////////
        }

        surface1.setOnClickListener {
            val coast= Toast.makeText(applicationContext, "Insert color one here", Toast.LENGTH_LONG)
            coast.show()
        }

        surface2.setOnClickListener {
            val coast= Toast.makeText(applicationContext, "Insert color two here", Toast.LENGTH_LONG)
            coast.show()
        }

        seekBar1.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBarBlue: SeekBar?) {
            }

            override fun onStartTrackingTouch(seekBarBlue: SeekBar?) {
            }


            override fun onProgressChanged(seekBarBlue: SeekBar, i: Int, b: Boolean) {
                textValue = i
                colorVal.text = "$textValue"
                mergeValues()
                mergedColor.setBackgroundColor(Color.rgb(color3[0], color3[1], color3[2]))
            }

        })
    }


    fun mergeValues(){
        //0,50,100
        //50,150,200
        val percent1 = (100 - textValue)
        val percent2 = textValue
        color3[0] = ((percent2 * color2[0]) + (percent1 * color1[0])) / 100
        color3[1] = ((percent2 * color2[1]) + (percent1 * color1[1])) / 100
        color3[2] = ((percent2 * color2[2]) + (percent1 * color1[2])) / 100
        //For proof that the percents are right for color merging
        //val coast= Toast.makeText(applicationContext, "$percent1 , $percent2", Toast.LENGTH_LONG)
       // coast.show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}
class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    init {
        view.setOnClickListener {
            val intent = Intent(view.context, ColorFragment::class.java)

            view.context.startActivity(intent)
        }
    }
}
