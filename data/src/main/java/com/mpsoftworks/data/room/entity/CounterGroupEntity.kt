package com.mpsoftworks.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Entity representing groups of counters.
 * @property id UUID identified each group
 * @property title group title
 * @property color group color
 * @property bitmapArray group icon
*/
@OptIn(ExperimentalUuidApi::class)
@Entity(tableName = "counter_group")
data class CounterGroupEntity (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Uuid,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "color")
    val color: Int,

    @ColumnInfo(name = "bitmap")
    val bitmapArray: ByteArray
)