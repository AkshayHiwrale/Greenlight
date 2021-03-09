package com.akshay.greenlightassignment.ui.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akshay.greenlightassignment.R
import com.akshay.greenlightassignment.data.model.Employee
import com.google.android.material.card.MaterialCardView
import java.util.*
import kotlin.collections.ArrayList

class SearchUserAdapter internal constructor(
    var context: Context
) : RecyclerView.Adapter<SearchUserAdapter.WordViewHolder>(), Filterable {

    var userFilterList = ArrayList<Employee>()

    private val inflater:
            LayoutInflater = LayoutInflater.from(context)
    private var words = emptyList<Employee>() // Cached copy of words

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.tv_user_name)
        var cardView: MaterialCardView = itemView!!.findViewById(R.id.cv_selection)
        val header: TextView = itemView.findViewById(R.id.header_title)

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
        if (position.equals(0)){
            holder.header.text = "Name"
            holder.header.visibility = View.VISIBLE
        }else{
            holder.header.visibility = View.GONE
        }
        holder.wordItemView.text = "${current.name}"
    }


    internal fun setWords(words: List<Employee>) {
        this.words = words
        userFilterList = words as ArrayList<Employee>
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    userFilterList = words as ArrayList<Employee>
                } else {
                    val resultList = ArrayList<Employee>()
                    for (row in words) {
                        if (row.name?.toLowerCase(Locale.ROOT)?.contains(charSearch.toLowerCase(Locale.ROOT))!!) {
                            resultList.add(row)
                        }
                    }
                    userFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = userFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                words = results?.values as ArrayList<Employee>
                notifyDataSetChanged()
            }

        }
    }


}