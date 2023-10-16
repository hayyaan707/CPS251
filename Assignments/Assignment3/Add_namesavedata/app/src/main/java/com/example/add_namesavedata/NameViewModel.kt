package com.example.add_namesavedata
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {
    private val nameList = mutableListOf<String>()
    fun addName(name: String) {
        nameList.add(name)
    }
    fun getNames(): String {
        return nameList.joinToString("\n")
    }
}