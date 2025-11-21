package com.example.llmnote.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.llmnote.data.local.dao.NoteDao
import com.example.llmnote.data.local.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}

// Helper to get database builder
expect fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>
