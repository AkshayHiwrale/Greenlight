package com.akshay.greenlightassignment.ui.search

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshay.greenlightassignment.R
import com.akshay.greenlightassignment.data.model.EmpDataResponse
import com.akshay.greenlightassignment.data.model.Employee
import kotlinx.android.synthetic.main.search_activity.*
class SearchActivity : AppCompatActivity() {
    lateinit var userList: ArrayList<Employee>
    lateinit var user: EmpDataResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_activity)
        val intent: Intent = getIntent()
        if (intent != null && intent.hasExtra("USER_LIST")) {
            user = intent.getParcelableExtra<EmpDataResponse>("USER_LIST") as EmpDataResponse
            userList = user.employee?.toCollection(ArrayList<Employee>())!!
        }

        initViews()

    }

    private fun initViews() {
        val adapter = SearchUserAdapter(this)
        rv_user_search.adapter = adapter
        rv_user_search.layoutManager = LinearLayoutManager(this)
        adapter.setWords(userList)
        et_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })
    }

}