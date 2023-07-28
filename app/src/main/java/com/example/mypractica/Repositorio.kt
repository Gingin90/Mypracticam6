package com.example.mypractica

import androidx.lifecycle.LiveData

class Repositorio(private val tareaDao:TareaDao) {
    suspend fun insertTask(tarea: Tarea) {
        tareaDao.insertarTarea(tarea)// insertar tarea
    }
    fun getTasks() : LiveData<List<Tarea>> {
        // obtener Tareas
        return tareaDao.getTasks()
    }


       }




