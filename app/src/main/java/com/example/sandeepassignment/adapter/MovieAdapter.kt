package com.example.sandeepassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sandeepassignment.data.model.searchmodel.Search
import com.example.sandeepassignment.R
import java.util.*

class MovieAdapter(
    var context: Context,
    var movieNavigateor: MovieNavigater,
    var MovieArrayList: ArrayList<Search>
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.movie_adapter, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (!MovieArrayList[position].Poster.isNullOrEmpty()) {
            if (!MovieArrayList[position].Poster.equals("N/A")) {
                Glide.with(context)
                    .load(MovieArrayList[position].Poster)
                    .into(holder.imageView)
            }
        }
        holder.title.text = MovieArrayList[position].Title
        holder.type.text = MovieArrayList[position].Type
        holder.year.text = MovieArrayList[position].Year
        holder.cardView.setOnClickListener {
            movieNavigateor.ClickOnMovie(MovieArrayList[position])
        }
    }

    override fun getItemCount(): Int {
        return MovieArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById<CardView>(R.id.cardView_movie)
        val imageView: ImageView = itemView.findViewById<ImageView>(R.id.imageView)
        val title: TextView = itemView.findViewById<TextView>(R.id.textView_title)
        val year: TextView = itemView.findViewById<TextView>(R.id.textView_year)
        val type: TextView = itemView.findViewById<TextView>(R.id.textView_type)
    }

    interface MovieNavigater {
        fun ClickOnMovie(search: Search)
    }
}