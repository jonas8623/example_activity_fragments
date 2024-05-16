package com.example.activityfragments

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {

    private lateinit var buttonBack: Button
    private lateinit var textViewMovie: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonBack = findViewById(R.id.button_back)
        textViewMovie = findViewById(R.id.text_movie)

        val bundle = intent.extras // todos os parametros passados
//        val movie = bundle?.getString("movie")
//        val rating = bundle?.getDouble("rating")
//        val result = "Filme: $movie\nClassificação: $rating"
        val movie: Movie? = if(Build.VERSION.SDK_INT >= 33) {
            bundle?.getSerializable("movie", Movie::class.java)
        } else {
            bundle?.getSerializable("movie") as Movie
        }

        textViewMovie.text = "Filme: ${movie!!.name}\nAvaliação: ${movie.rate}"

        buttonBack.setOnClickListener { finish() } // Finalizar
    }
}