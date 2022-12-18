package com.anilyilmaz.ecommerceapp.services.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "products")

data class ProductDbModel(

    @ColumnInfo(name = "uid_")
    var uid_: Int = 0,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "uimage")
    var uimage: String = "",

    @ColumnInfo(name = "description")
    var description: String = "",

    @ColumnInfo(name = "category")
    var category: String = "",

    @ColumnInfo(name = "memory")
    var memory: Int = 0,

    @ColumnInfo(name = "color")
    var color: String = "",

    @ColumnInfo(name = "price")
    var price: Int = 0,

    @ColumnInfo(name = "piece")
    var piece: Int = 1,

    @ColumnInfo(name = "currentUser")
    var currentUser: String = "",

    @PrimaryKey(autoGenerate = true) var productId: Int = 0

) : Serializable{}
