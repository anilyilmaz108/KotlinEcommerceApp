package com.anilyilmaz.makeup.services

import com.anilyilmaz.ecommerceapp.models.ProductModel
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {
    @GET("product")
    suspend fun getData(): Response<List<ProductModel>>
}