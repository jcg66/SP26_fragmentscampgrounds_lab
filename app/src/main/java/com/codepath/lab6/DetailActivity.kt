package com.codepath.lab6

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailImageView: ImageView = findViewById(R.id.detailImage)
        val detailTitleTextView: TextView = findViewById(R.id.detailTitle)
        val detailDescriptionTextView: TextView = findViewById(R.id.detailDescription)

        // Retrieve data passed via Intent
        val park = intent.getSerializableExtra(PARK_EXTRA) as? Park
        val campground = intent.getSerializableExtra(CAMPGROUND_EXTRA) as? Campground

        // Populate UI based on type
        when {
            park != null -> {
                detailTitleTextView.text = park.fullName
                detailDescriptionTextView.text = park.description
                Glide.with(this)
                    .load(park.imageUrl)
                    .placeholder(R.drawable.campgrounds_image_placeholder)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(detailImageView)
            }
            campground != null -> {
                detailTitleTextView.text = campground.name
                detailDescriptionTextView.text = campground.description
                Glide.with(this)
                    .load(campground.imageUrl)
                    .placeholder(R.drawable.campgrounds_image_placeholder)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(detailImageView)
            }
        }
    }
}
