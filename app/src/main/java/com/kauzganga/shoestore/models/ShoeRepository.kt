package com.kauzganga.shoestore.models

import com.kauzganga.shoestore.database.ShoeDatabaseDao

class ShoeRepository(private val dao : ShoeDatabaseDao) {

    val shoes = dao.getAllShoes()

    suspend fun insert(shoe: Shoe) {
       dao.insertShoe(shoe)
    }

    suspend fun update(shoe: Shoe){
        dao.updateShoe(shoe)
    }

    suspend fun clear(){
        dao.clear()
    }
    suspend fun get(key: Long){
        dao.get(key)
    }

}