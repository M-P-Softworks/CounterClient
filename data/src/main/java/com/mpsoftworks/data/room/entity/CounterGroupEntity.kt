package com.mpsoftworks.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

/**
 * Entity representing groups of counters.
 * @property id UUID identified each group
 * @property title group title
 * @property color group color
 * @property bitmapArray group icon
*/
@Entity(tableName = "counter_group")
data class CounterGroupEntity (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: UUID,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "color")
    val color: Int,

    @ColumnInfo(name = "bitmap")
    val bitmapArray: ByteArray
)