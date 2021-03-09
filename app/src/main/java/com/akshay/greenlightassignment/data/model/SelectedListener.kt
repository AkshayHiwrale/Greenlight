package com.akshay.greenlightassignment.data.model

interface SelectedListener {

    fun addSelectedItem(item:Any,isSelected:Boolean)
    fun isSelectedItem(item:Any,isSelected:Boolean):Boolean
}