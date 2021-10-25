package com.kauzganga.shoestore.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kauzganga.shoestore.models.Shoe


@Dao
interface ShoeDatabaseDao {
    @Insert
    suspend fun insertShoe(shoe:Shoe)

    @Update
    suspend fun updateShoe(shoe:Shoe)

    @Query("SELECT * FROM shoestable WHERE shoeId = :key")
    suspend fun get(key: Long) : Shoe?

    @Query("DELETE FROM shoestable")
    suspend fun clear()

    @Query("SELECT * from shoestable ORDER BY shoeId DESC")
    fun getAllShoes(): LiveData<List<Shoe>>
}