package com.example.contacts_project

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ContactRepository = ContactRepository(application)
    private val searchResults: MutableLiveData<List<Contact>> = repository.searchResults
    private val allContacts: LiveData<List<Contact>>? = repository.allContacts
    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }
    fun findContact(name: String) {
        return repository.findContact(name)
    }
    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }
    fun getAllContacts(): LiveData<List<Contact>>? {
        return allContacts
    }
    fun sortByAsc() {
        repository.sortContactsAsc()
    }
    fun sortByDesc() {
        repository.sortContactsDesc()
    }
}