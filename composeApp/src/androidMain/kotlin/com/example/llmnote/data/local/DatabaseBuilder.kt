package com.example.llmnote.data.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.java.KoinJavaComponent.get

fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val context: Context = get(Context::class.java)
    val dbFile = context.getDatabasePath("llm_note_db")
    return Room.databaseBuilder<AppDatabase>(
        context = context,
        name = dbFile.absolutePath
    )
}
