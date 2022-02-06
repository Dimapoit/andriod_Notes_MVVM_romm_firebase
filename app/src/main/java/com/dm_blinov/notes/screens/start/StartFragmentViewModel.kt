package com.dm_blinov.notes.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.dm_blinov.notes.database.room.AppRoomDatabase
import com.dm_blinov.notes.database.room.AppRoomRepository
import com.dm_blinov.notes.utils.REPOSITORY
import com.dm_blinov.notes.utils.TYPE_ROOM

class StartFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application

    fun initDatabase(type: String, onSuccess:() -> Unit) {
        when (type) {
            TYPE_ROOM -> {
                //Создаем бд
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                //Инициализируем репозиторий
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
        }
    }
}