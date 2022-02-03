package com.mas.ewallet.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mas.ewallet.data.moduel.UserCards
import com.mas.ewallet.data.moduel.UserItems

@Dao
interface DatabaseDao {
    // insert ====
    @Insert
    suspend fun insertCard(userCards: UserCards)

    @Query("Select * from UserCards")
    fun getAllUserCards(): LiveData<List<UserCards>>

    // insert item
    @Insert
    suspend fun insertItem(userItems: UserItems)

    @Query("Select * from UserItems where cardId =:card_id")
    fun getItemsByCards(card_id: Int): LiveData<List<UserItems>>


    @Query("Select sum(amount) from UserItems where cardId=:card_id")
    fun getTheCardItemsTotalAmount(card_id: Int): LiveData<Double>

}