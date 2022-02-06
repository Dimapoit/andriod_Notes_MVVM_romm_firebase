package com.dm_blinov.notes.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dm_blinov.notes.models.AppNote

@Database(entities = [AppNote::class], version = 1)
abstract class AppRoomDatabase: RoomDatabase(){
    //Получаем обїект Dao
    abstract fun getAppRoomDao(): AppRoomDao

    //Создаем singleton, чтоб не получить два экземпляра бд
    companion object{
        @Volatile // данные не должны хешироваться
        private var database:AppRoomDatabase?=null

        //Функция предоставляющая экземпляр бд
        @Synchronized // Запрещаем доступ к функции нескольких одновременно
        fun getInstance(context: Context): AppRoomDatabase {
            if(database == null) {
                database = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    "database"
                ).build()
            }
            return database as AppRoomDatabase
        }
    }
}