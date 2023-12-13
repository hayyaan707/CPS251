package com.example.coroutineproject
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    private var names = ArrayList<String>()
    fun addNames(name: String) {
        names += name
    }
    fun getNames(): ArrayList<String> {
        return names
    }
}