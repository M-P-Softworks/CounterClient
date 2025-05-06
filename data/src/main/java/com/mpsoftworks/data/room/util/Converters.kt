package com.mpsoftworks.data.room.util

import androidx.room.TypeConverter
import java.util.UUID
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
class Converters {
    @TypeConverter
    fun fromUUID(uuid: Uuid): String = uuid.toString()

    @TypeConverter
    fun toUUID(uuid: String): Uuid = if(uuid.isNotEmpty()) Uuid.parse(uuid) else  Uuid.NIL
}