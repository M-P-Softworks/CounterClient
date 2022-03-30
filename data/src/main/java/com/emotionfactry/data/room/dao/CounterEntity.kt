package com.emotionfactry.data.room.dao

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class CounterEntity (
    @PrimaryKey
    val id: UUID,
    val title: String?,
    val value: Long?,
    val canDecrease: Boolean? = false,
)