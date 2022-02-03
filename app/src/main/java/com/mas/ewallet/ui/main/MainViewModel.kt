package com.mas.ewallet.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mas.ewallet.data.db.DataRepository
import com.mas.ewallet.data.moduel.UserCards
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: DataRepository ) : ViewModel() {
    fun insertNewCard(userCards: UserCards) {
        viewModelScope.launch {
            repository.insertCard(userCards)
        }
    }

    fun getUserCards(): LiveData<List<UserCards>> = repository.getAllUserCards()

}

