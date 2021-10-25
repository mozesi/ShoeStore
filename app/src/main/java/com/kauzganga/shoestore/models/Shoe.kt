package com.kauzganga.shoestore.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "shoestable")
data class Shoe(
    @PrimaryKey(autoGenerate = true)
    var shoeId: Long = 0L,

    @ColumnInfo(name = "size")
    var size: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "company_name")
    var company: String,

    @ColumnInfo(name = "description")
    var description: String
)