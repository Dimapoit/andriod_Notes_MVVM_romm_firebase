package com.dm_blinov.notes.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dm_blinov.notes.models.AppNote

@Dao
interface AppRoomDao {
    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): LiveData<List<AppNote>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(appNote: AppNote)

    @Delete
    suspend fun delete(appNote: AppNote)
}