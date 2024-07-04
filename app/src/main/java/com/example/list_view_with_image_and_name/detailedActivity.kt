package com.example.list_view_with_image_and_name

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed)
        val Pizza=intent.getParcelableExtra<ItemsViewModel>("ItemsViewModel")
        if(Pizza!=null){
     val image_view=findViewById<ImageView>(R.id.specific_image)
     val text_view=findViewById<TextView>(R.id.specific_text)
            image_view.setImageResource(Pizza.image)
            text_view.text=Pizza.text
        }
    }
}