package com.example.mypractica

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [Tarea::class], version = 1)
abstract class TareaBaseDato: RoomDatabase() {

    abstract fun getTaskDao(): TareaDao

    companion object {
        @Volatile
        private var INSTANCE: TareaBaseDato? = null

        fun getDatabase(context: Context): TareaBaseDato {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TareaBaseDato::class.java,
                    "tarea_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}