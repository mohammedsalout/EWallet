package com.mas.ewallet.data.moduel

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity( foreignKeys = [ForeignKey(
        entity = UserCards::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("cardId"),
        onDelete = CASCADE
    )])
data class UserItems(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var cardId: Int,
    var amount: Double,
    var note: String,
    var date: Long = System.currentTimeMillis()
)