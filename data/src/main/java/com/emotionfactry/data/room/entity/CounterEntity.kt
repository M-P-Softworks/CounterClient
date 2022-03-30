package com.emotionfactry.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "counter")
data class CounterEntity (
    @PrimaryKey
    @ColumnInfo(name = "ID")
    val id: UUID,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "value")
    val value: Long?,
    @ColumnInfo(name = "canDecrease")
    val canDecrease: Boolean? = false,
)