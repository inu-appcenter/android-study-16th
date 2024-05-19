package dev.kichan.week5.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Comment::class], version = 1)
abstract class CommentDatabase : RoomDatabase() {
    abstract fun commentDao(): CommentDao

    companion object {
        @Volatile
        private var INSTANCE: CommentDatabase? = null
        fun getInstance(context: Context): CommentDatabase {
            return INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                CommentDatabase::class.java,
                "comment_database"
            )
                .fallbackToDestructiveMigration()
                .build()
                .also { INSTANCE = it }
        }
    }
}