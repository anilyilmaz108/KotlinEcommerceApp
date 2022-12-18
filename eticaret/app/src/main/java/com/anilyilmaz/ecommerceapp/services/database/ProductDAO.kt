package com.anilyilmaz.ecommerceapp.services.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDAO {

    @Insert
    fun insert(productDbModel: ProductDbModel)

    @Delete
    fun delete(productDbModel: ProductDbModel)

    @Query("SELECT*FROM products")
    fun getAllProducts(): List<ProductDbModel>
}