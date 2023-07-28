package com.example.mypractica

import android.app.Application
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TareaViewModel(aplicacion: Application) : AndroidViewModel(aplicacion) {
    private val repositorio: Repositorio

    init {
        repositorio = Repositorio(TareaBaseDato.getDatabase(aplicacion).getTaskDao())


    }

    fun obtenerTareas(): LiveData<List<Tarea>> {
        return repositorio.getTasks()

    }

    fun insertarTarea(tarea: Tarea) = viewModelScope.launch {
        repositorio.insertTask(tarea)
    }
}