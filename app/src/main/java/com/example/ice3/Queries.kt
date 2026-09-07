package com.example.ice3

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface Queries {
    @Insert
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAllNotes(): Flow<List<Note>>
}