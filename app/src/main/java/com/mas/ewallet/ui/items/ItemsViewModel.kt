package com.mas.ewallet.ui.items

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mas.ewallet.data.db.DataRepository
import com.mas.ewallet.data.moduel.UserCards
import com.mas.ewallet.data.moduel.UserItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(private val repository: DataRepository) : ViewModel() {

    fun insertNewCardItem(userItems: UserItems) {
        viewModelScope.launch {
            repository.insertUserItem(userItems)
        }
    }

    fun getCardItems(cardId: Int): LiveData<List<UserItems>> = repository.getCardsItems(cardId)

    fun getTheCardItemsTotalAmounts(cardId: Int): LiveData<Double> =
        repository.getTheCardItemsTotalAmount(cardId)
}