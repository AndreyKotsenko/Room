package com.akotsenko.roomtest.screens.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akotsenko.roomtest.REPOSITORY
import com.akotsenko.roomtest.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel : ViewModel() {

    fun insert(noteModel: NoteModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.insertNote(noteModel){
                onSuccess()
            }
        }
}