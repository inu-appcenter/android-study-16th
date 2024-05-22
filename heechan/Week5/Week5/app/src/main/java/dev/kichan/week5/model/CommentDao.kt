package dev.kichan.week5.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CommentDao {
    @Insert
    fun addComment(comment : Comment)

    @Query("SELECT * FROM Comment")
    fun getAll() : List<Comment>

    @Delete
    fun removeComment(comment: Comment)
}