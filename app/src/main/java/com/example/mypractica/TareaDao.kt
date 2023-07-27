package com.example.mypractica

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TareaDao {
    @Insert
    suspend fun insertarTarea(tarea:Tarea)
}