package com.dm_blinov.notes.screens.addNewNote

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.dm_blinov.notes.models.AppNote
import com.dm_blinov.notes.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewNoteViewModel(application: Application): AndroidViewModel(application) {
    fun insert(appNote: AppNote, onSuccess: () ->Unit){
        //Insert в бд выполняем в coroutine
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insert(appNote){
                viewModelScope.launch(Dispatchers.Main){
                    onSuccess()
                }
            }
        }
    }
}