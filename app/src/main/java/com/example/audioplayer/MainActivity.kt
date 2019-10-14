package com.example.audioplayer

import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.ScrollView
import com.example.audioplayer.R.color
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var index=0
    internal var mediaplayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

}

    fun playsong(view: View)
    {
        val sound=view as Button

        if (mediaplayer.isPlaying)
        {
            index=0
            mediaplayer.stop()
        }

        mediaplayer=MediaPlayer.create(this@MainActivity,resources.getIdentifier(sound.tag as String,"raw",packageName))

        if (index==0)
        {
            mediaplayer.start()
        }

        if (mediaplayer.isPlaying)
        {
            sound.setBackgroundColor(getResources().getColor(color.green))
        }

        mediaplayer.setOnCompletionListener {
            sound.setBackgroundColor(getResources().getColor(color.red))
        }

    }

}
