package com.mas.ewallet.data.db

import androidx.lifecycle.LiveData
import com.mas.ewallet.data.moduel.UserCards
import com.mas.ewallet.data.moduel.UserItems
import javax.inject.Inject

class DataRepository @Inject constructor(private val dao: DatabaseDao) {
    suspend fun insertCard(userCards: UserCards) {
        dao.insertCard(userCards)
    }

    fun getAllUserCards(): LiveData<List<UserCards>> = dao.getAllUserCards()

    suspend fun insertUserItem(userItems: UserItems) {
        dao.insertItem(userItems)
    }

    fun getCardsItems(cardId: Int): LiveData<List<UserItems>> = dao.getItemsByCards(cardId)


    fun getTheCardItemsTotalAmount(cardId: Int): LiveData<Double> =
        dao.getTheCardItemsTotalAmount(cardId)

}