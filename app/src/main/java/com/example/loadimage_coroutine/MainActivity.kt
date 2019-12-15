package com.example.loadimage_coroutine

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_load.setOnClickListener(){
            GlobalScope.launch {
            try {
                val url = "https://java.sogeti.nl/JavaBlog/wp-content/uploads/2009/04/android_icon_256.png"
                val inu = java.net.URL(url).openStream()
                val mIcon11= BitmapFactory.decodeStream(inu)
                runOnUiThread {  imageView.setImageBitmap(mIcon11) }
            } catch (e: Exception) {
                Log.e("Error1", e.message)
                e.printStackTrace()
            }
            }
        }
    }
}
