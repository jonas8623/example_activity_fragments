package com.example.activityfragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var buttonNewPage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("life_cycle", "onCreate")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonNewPage = findViewById(R.id.button_new_page)
        buttonNewPage.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)

            // Passando parametros para a nova tela
//            intent.putExtra("movie", "The Winter")
//            intent.putExtra("rating", 6.9)

            val movie = Movie("A Criatura", "Teste", 6.2, "Jonas")
            intent.putExtra("movie", movie)

            startActivity(intent) // Abrir nova tela
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("life_cycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("life_cycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("life_cycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("life_cycle", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("life_cycle", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("life_cycle", "onDestroy")
    }
}