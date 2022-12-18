package com.anilyilmaz.ecommerceapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ProductModel(
    @SerializedName("id")
    val id_: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("image")
    val image: ArrayList<String>,
    @SerializedName("description")
    val description: String = "",
    @SerializedName("category")
    val category: String = "",
    @SerializedName("memory")
    val memory: Int = 0,
    @SerializedName("color")
    val color: ArrayList<String>,
    @SerializedName("price")
    val price: Int = 0,


) : Serializable{}

