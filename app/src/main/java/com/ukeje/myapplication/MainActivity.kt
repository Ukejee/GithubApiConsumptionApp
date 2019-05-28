package com.ukeje.myapplication

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        repolist.layoutManager = linearLayoutManager

        if(checkNetwork(this)){
            val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://github-trending-api.now.sh").build()

            val postsApi = retrofit.create(GithubApiService::class.java)

            var response = postsApi.getRepoList()

            response.observeOn(AndroidSchedulers.mainThread()).subscribeOn(IoScheduler()).subscribe {
                repolist.adapter = RepoListAdapter(it, this, { partItem : Repo -> partItemClicked(partItem, this) })
            }
        }
        else{
            Toast.makeText(this,"ENABLE DATA OR WIFI AND RESTART APP", Toast.LENGTH_LONG).show()
        }


    }

    private fun partItemClicked(partItem : Repo, context: Context) {

        val showDetailsIntent = Intent(context,DetailsActivity::class.java)
        showDetailsIntent.putExtra("REPO NAME", partItem.name)
        showDetailsIntent.putExtra("REPO AUTHOR", partItem.author)
        showDetailsIntent.putExtra("REPO STARS", partItem.stars.toString())
        showDetailsIntent.putExtra("REPO URL", partItem.url)
        showDetailsIntent.putExtra("REPO DESC", partItem.description)
        context.startActivity(showDetailsIntent)
    }

    fun checkNetwork(context: Context) : Boolean{

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        return isConnected
    }
}
