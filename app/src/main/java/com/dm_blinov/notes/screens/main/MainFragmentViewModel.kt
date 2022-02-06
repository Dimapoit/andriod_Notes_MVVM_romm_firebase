package com.dm_blinov.notes.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.dm_blinov.notes.utils.REPOSITORY

class MainFragmentViewModel(application: Application) :AndroidViewModel(application) {
    // REPOSITORY возвращает liveData
    val allNotes = REPOSITORY.allNotes
}