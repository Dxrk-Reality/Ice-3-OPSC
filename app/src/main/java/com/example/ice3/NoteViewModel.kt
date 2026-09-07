package com.example.ice3

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = NoteDatabase.getDatabase(application).Queries()
    val allNotes: LiveData<List<Note>> = dao.getAllNotes().asLiveData()

    fun insert(note: Note) = viewModelScope.launch { dao.insert(note) }
    fun delete(note: Note) = viewModelScope.launch { dao.delete(note) }
}