package com.ukeje.myapplication

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_details.view.*
import kotlinx.android.synthetic.main.repolist_layout.view.*

/**
 * @author .: Ukeje Emeka
 * @email ..: ukejee3@gmail.com
 * @created : 5/27/19
 */

class RepoListAdapter(val repoList: List<Repo>, val context: Context, val clickListener: (Repo) -> Unit) :
    RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.repolist_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repoList[position], clickListener)

    }
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener{

        fun bind(part: Repo, clickListener: (Repo) -> Unit) {
            itemView.repoName.text = part.name
            itemView.authorName.text = part.author
            itemView.setOnClickListener { clickListener(part)}
        }

        override fun onClick(v: View) {

        }

    }
}