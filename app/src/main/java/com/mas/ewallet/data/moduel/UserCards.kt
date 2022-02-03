package com.mas.ewallet.data.moduel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserCards(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var title: String = "",
    var update: Long = System.currentTimeMillis(),
    var total: Double = 0.0
) {
    override fun toString(): String {
        return "{id: $id , title: $title }"
    }
}
