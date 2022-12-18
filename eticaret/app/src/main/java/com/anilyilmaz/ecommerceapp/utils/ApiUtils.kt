package com.anilyilmaz.ecommerce.utils

import com.anilyilmaz.ecommerce.services.RetrofitClient
import com.anilyilmaz.makeup.services.ProductApi

class ApiUtils {

    companion object{

        val BASE_URL = "http://10.0.2.2:8006"

        fun getProductApi(): ProductApi {
            return RetrofitClient.getClient(BASE_URL).create(ProductApi::class.java)
        }
    }
}