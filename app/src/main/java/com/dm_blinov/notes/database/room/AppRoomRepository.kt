package com.dm_blinov.notes.database.room

import androidx.lifecycle.LiveData
import com.dm_blinov.notes.database.DataBaseRepository
import com.dm_blinov.notes.models.AppNote

class AppRoomRepository(private val roomDao: AppRoomDao): DataBaseRepository {
    override val allNotes: LiveData<List<AppNote>>
        get() = roomDao.getAllNotes()

    override suspend fun insert(appNote: AppNote, onSuccess: () -> Unit) {
        roomDao.insert(appNote)
        onSuccess()
    }

    override suspend fun delete(appNote: AppNote, onSuccess: () -> Unit) {
        roomDao.delete(appNote)
        onSuccess()
    }
}