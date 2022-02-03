package com.mas.ewallet.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mas.ewallet.data.moduel.UserCards
import com.mas.ewallet.data.moduel.UserItems

@Database(entities = [UserCards::class, UserItems::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao

}