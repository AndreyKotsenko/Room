package com.akotsenko.roomtest.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.akotsenko.roomtest.REPOSITORY
import com.akotsenko.roomtest.db.NoteDatabase
import com.akotsenko.roomtest.db.repository.NoteRealisation
import com.akotsenko.roomtest.model.NoteModel

class StartViewModel(application: Application) : AndroidViewModel(application) {

    val context = application

    fun initDatabase() {
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealisation(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }
}