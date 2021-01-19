package cl.darkdragonzerox.superheroes.data

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun list2String(list: List<String>): String {
        return list.joinToString()
    }

    @TypeConverter
    fun string2List(value: String): List<String> {
        return value.split(",").map {
            it.trim()
        }
    }

    @TypeConverter
    fun list2Int(list: List<Int>): String {
        return list.joinToString()
    }

    @TypeConverter
    fun Int2List(value: String): List<Int> {
        val result = mutableListOf<Int>()
        value.split(",").forEach {
            if (it.isNotEmpty()) {
                result.add(it.trim().toInt())
            }
        }
        return result
    }

}
