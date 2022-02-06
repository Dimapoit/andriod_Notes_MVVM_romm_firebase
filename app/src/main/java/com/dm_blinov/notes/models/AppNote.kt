package com.dm_blinov.notes.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

//Сущность для базы данных
@Entity(tableName = "notes_table")
data class AppNote(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val name: String?,
    @ColumnInfo val text: String?
    ) : Serializable