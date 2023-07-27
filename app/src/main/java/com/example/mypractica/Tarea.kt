package com.example.mypractica

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName ="tabla_tarea")

data class Tarea(val nombreTarea:String, val fecha: String){
    @PrimaryKey(autoGenerate = true) var id:Long =0
}

