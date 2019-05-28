package com.ukeje.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val rName = intent.getStringExtra("REPO NAME")
        val rAuthor = intent.getStringExtra("REPO AUTHOR")
        val rUrl = intent.getStringExtra("REPO URL")
        val rDes = intent.getStringExtra("REPO DESC")
        val rStar = intent.getStringExtra("REPO STARS")

        name.text = rName
        authorsName.text = rAuthor
        repoUrl.text = rUrl
        repoDescription.text = rDes
        repoStar.text = rStar

    }
}
