package com.kauzganga.shoestore.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kauzganga.shoestore.models.Shoe

@Database(entities = [Shoe::class], version = 2, exportSchema = false)
abstract class ShoeDatabase : RoomDatabase() {

    abstract val shoeDatabaseDao: ShoeDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: ShoeDatabase? = null

        fun getInstance(context: Context): ShoeDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ShoeDatabase::class.java,
                        "shoe_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}