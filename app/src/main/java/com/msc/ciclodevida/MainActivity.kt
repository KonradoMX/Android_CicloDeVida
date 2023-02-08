package com.msc.ciclodevida

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var posicion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("Ciclo de vida:", "OnCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Ciclo de vida:", "OnStart")
        mediaPlayer = MediaPlayer.create(this, R.raw.ace_combat)
    }

    override fun onResume() {
        super.onResume()
        Log.i("Ciclo de vida:", "OnResume")
        mediaPlayer?.seekTo(posicion)
        mediaPlayer?.start() //Equivale a: if (mediaPlayer != null)
    }

    override fun onPause() {
        super.onPause()
        Log.i("Ciclo de vida:", "OnPause")
        mediaPlayer?.pause()
        if (mediaPlayer != null)
            posicion = mediaPlayer!!.currentPosition
    }

    override fun onStop() {
        super.onStop()
        Log.i("Ciclo de vida:", "OnStop")

        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Ciclo de vida:", "OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Ciclo de vida:", "onDestroy")
    }
}