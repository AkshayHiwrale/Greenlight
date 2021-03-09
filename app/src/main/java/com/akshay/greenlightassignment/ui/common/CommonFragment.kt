package com.akshay.greenlightassignment.ui.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshay.greenlightassignment.R
import com.akshay.greenlightassignment.data.model.SelectedListener
import kotlinx.android.synthetic.main.fragment_common.*

class CommonFragment : Fragment(), SelectedListener {

    lateinit var mainViewModel: MainViewModel
    lateinit var selectedType: String


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_common, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        var bundle = arguments
        selectedType = bundle?.getString("SCREEN_TYPE", "Zonse").toString()
        initViews()

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun initViews() {
        val adapter = UserListAdapter(requireActivity(), this)
        rv_user_list.adapter = adapter
        rv_user_list.layoutManager = LinearLayoutManager(activity)

        mainViewModel.userList.observe(viewLifecycleOwner, Observer {
            when (selectedType) {
                "Zone" -> {
                    it.data?.let { it1 -> it1.zone?.let { it2 -> adapter.setWords(it2) } }
                }
                "Region" -> {
                    it.data?.let { it1 -> it1.region?.let { it2 -> adapter.setWords(it2) } }
                }
                "Area" -> {
                    it.data?.let { it1 -> it1.area?.let { it2 -> adapter.setWords(it2) } }
                }
            }

        })
    }

    override fun addSelectedItem(item: Any, isSelected: Boolean) {
        mainViewModel.selectedType.postValue(item)
    }

    override fun isSelectedItem(item: Any, isSelected: Boolean): Boolean {
        return false
    }

}