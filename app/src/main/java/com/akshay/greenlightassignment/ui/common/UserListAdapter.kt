package com.akshay.greenlightassignment.ui.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akshay.greenlightassignment.R
import com.akshay.greenlightassignment.data.model.*
import com.google.android.material.card.MaterialCardView

class UserListAdapter internal constructor(
    var context: Context, var selectedListener: SelectedListener
) : RecyclerView.Adapter<UserListAdapter.WordViewHolder>() {
    private val inflater:
            LayoutInflater = LayoutInflater.from(context)
    private var words = emptyList<Any>() // Cached copy of words

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.tv_user_name)
        val header: TextView = itemView.findViewById(R.id.header_title)
        var cardView: MaterialCardView = itemView!!.findViewById(R.id.cv_selection)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.item_user_list, parent, false)
        return WordViewHolder(itemView)
    }


    override fun getItemCount(): Int {
        return words.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = words[position]
        when (current) {
            is Zone -> {
                if (position.equals(0)) {
                    holder.header.text = "Zone"
                    holder.header.visibility = View.VISIBLE
                } else {
                    holder.header.visibility = View.GONE
                }
                holder.wordItemView.text = "${current.zone}"
            }
            is Region -> {
                if (position.equals(0)) {
                    holder.header.text = "Region"
                    holder.header.visibility = View.VISIBLE
                } else {
                    holder.header.visibility = View.GONE
                }
                holder.wordItemView.text = "${current.region}"
            }
            is Area -> {
                if (position.equals(0)) {
                    holder.header.text = "Area"
                    holder.header.visibility = View.VISIBLE
                } else {
                    holder.header.visibility = View.GONE
                }
                holder.wordItemView.text = "${current.area}"
            }
        }

        holder.cardView?.setOnClickListener {
            holder.cardView.toggle()
            selectedListener?.addSelectedItem(current, holder.cardView.isChecked)
        }
    }

    internal fun setWords(words: List<Any>) {
        this.words = words
        notifyDataSetChanged()
    }

}