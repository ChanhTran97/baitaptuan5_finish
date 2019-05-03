package com.example.baitaptuan5

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var movies: ArrayList<film.Results> = ArrayList()
    val Film = film()
    lateinit var filmAdapter: FilmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFilm()
        rvFilm.layoutManager = LinearLayoutManager(this)

        filmAdapter = FilmAdapter(movies, this)
        rvFilm.adapter = filmAdapter

        filmAdapter.setListener(filmItemCLickListener)

    }

    private val filmItemCLickListener = object : FilmItemClickListener {

        override fun onItemCLicked(position: Int) {

            val intent = Intent(this@MainActivity,activity_details_film::class.java)
            intent.putExtra(MOVIE_TITLE_KEY,movies[position].title)
            intent.putExtra(MOVIE_POSTER_KEY,movies[position].poster_path)
            intent.putExtra(MOVIE_DES_KEY,movies[position].overview)
            intent.putExtra(MOVIE_VIDEO_KEY,movies[position].video)
            intent.putExtra(MOVIE_BACKDROP_KEY,movies[position].backdrop_path)
            intent.putExtra(MOVIE_VOTE_KEY,movies[position].vote_average)
            intent.putExtra(MOVIE_DATE_KEY,movies[position].release_date)
            startActivity(intent)

        }
    }


    private fun  addFilm() {
        for(i in Film.getMovieModel().results){
            movies.add(i)
            Log.i("film array", movies.toString())
        }
    }
}
