package com.mas.ewallet.data.di

import android.content.Context
import androidx.room.Room
import com.mas.ewallet.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "e_wallet_db"
    ).build()

    @Singleton
    @Provides
    fun provideDao(db: AppDatabase) = db.databaseDao()
}