package com.example.nucleus.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


/**
 * Abstract Foodium database.
 * It provides DAO [PostsDao] by using method [getPostsDao].
 */
@Database(
    entities = [Post::class],
    version = 1
)
abstract class FoodiumPostsDatabase : RoomDatabase() {

    /**
     * @return [PostsDao] Foodium Posts Data Access Object.
     */
    abstract fun getPostsDao(): PostsDao

    companion object {
        const val DB_NAME = "foodium_database"

        @Volatile
        private var INSTANCE: FoodiumPostsDatabase? = null

        fun getInstance(context: Context): FoodiumPostsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FoodiumPostsDatabase::class.java,
                    DB_NAME
                )
                    .addMigrations(*DatabaseMigrations.MIGRATIONS)
                    .build()

                INSTANCE = instance
                return instance
            }
        }

    }
}