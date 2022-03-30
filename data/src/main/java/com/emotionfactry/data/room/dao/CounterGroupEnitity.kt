package com.emotionfactry.data.room.dao

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class CounterGroupEntity(
    @PrimaryKey
    val id: UUID,
    val title:String,
    val color: Int,
    val listCounter: List<CounterEntity>?
)