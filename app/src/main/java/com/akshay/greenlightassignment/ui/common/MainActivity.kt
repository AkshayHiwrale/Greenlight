package com.akshay.greenlightassignment.ui.common

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.akshay.greenlightassignment.R
import com.akshay.greenlightassignment.data.model.Area
import com.akshay.greenlightassignment.data.model.Region
import com.akshay.greenlightassignment.data.model.Zone
import com.akshay.greenlightassignment.ui.search.SearchActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData() {
        openNextFragment("Zone")
        initObserver()
    }


    private fun initObserver() {
        mainViewModel.selectedType.observe(this, Observer {
            when (it) {
                is Zone -> {
                    tv_title.text = it.zone + " Performance"
                    openNextFragment("Region")
                }
                is Region -> {
                    tv_title.text = it.region + " Performance"
                    openNextFragment("Area")
                }
                is Area -> {
                    openSearch()
                }

            }

        })

    }

    private fun openSearch() {
        var intent = Intent(
            MainActivity@ this,
            SearchActivity::class.java
        )
        intent.putExtra("USER_LIST", mainViewModel.userList.value?.data)
        startActivity(intent)

    }

    private fun openNextFragment(screenType: String) {
        val args = Bundle()
        args.putString("SCREEN_TYPE", screenType)
        val detailsFragment =
            CommonFragment().apply {
                enterTransition = Slide(Gravity.END)
                exitTransition = Slide(Gravity.START)
            }
        detailsFragment.arguments = args
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frag_container, detailsFragment, "CommonFragment")
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        tv_title.text = ""
        if (supportFragmentManager.backStackEntryCount > 0)
            supportFragmentManager.popBackStackImmediate()
        else super.onBackPressed()
    }


}