package com.mpsoftworks.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Entity of counter entity.
 * @property id UUID identified each counter
 * @property header counter title
 * @property value counter value
 * @property canDecrease can value be decreased
 * @property groupId UUID identified each group
 */
@OptIn(ExperimentalUuidApi::class)
@Entity(tableName = "counters")
data class CounterEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Uuid,

    @ColumnInfo(name = "title")
    val header: String?,

    @ColumnInfo(name = "text")
    val text: String?,

    @ColumnInfo(name = "value")
    val value: Double?,

    @ColumnInfo(name = "can_decrease")
    val canDecrease: Boolean? = false,

    @ColumnInfo(name = "group_id")
    val groupId: Uuid
)
