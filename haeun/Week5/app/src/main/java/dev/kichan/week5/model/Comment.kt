package dev.kichan.week5.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class Comment(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo(name = "comment") val comment : String,
    @ColumnInfo(name = "timestamp") val timeStamp : String = LocalDateTime.now().toString()
) {
    val date : LocalDateTime
        get() {
            return LocalDateTime.parse(this.timeStamp)
        }
}