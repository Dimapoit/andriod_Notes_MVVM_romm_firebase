package com.dm_blinov.notes.database

import androidx.lifecycle.LiveData
import com.dm_blinov.notes.models.AppNote



// Общий репозиторий для двух баз данных
interface DataBaseRepository {
    //Repository должен уметь 1 - получать список всех заметок
    val allNotes: LiveData<List<AppNote>>
    //2 - Вставлять новую заметку в базу данных,
    // принимать заметку и возвращать колбек по завершении задачи
    suspend fun insert(appNote:AppNote, onSuccess: () -> Unit)
    //3 - Удалять заметку из базы данных
    suspend fun delete(appNote:AppNote, onSuccess: () -> Unit)
    //suspend - Все операции с бд должны виполняться о отдельном coroutine (асинхронно)
}