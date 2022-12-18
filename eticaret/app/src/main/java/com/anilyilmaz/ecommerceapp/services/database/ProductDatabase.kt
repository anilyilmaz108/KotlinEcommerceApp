package com.anilyilmaz.ecommerceapp.services.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ProductDbModel::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDAO

    companion object {
        private var instance: ProductDatabase? = null

        fun getProductDatabase(context: Context): ProductDatabase? {

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    ProductDatabase::class.java,
                    "products.db"
                ).allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}