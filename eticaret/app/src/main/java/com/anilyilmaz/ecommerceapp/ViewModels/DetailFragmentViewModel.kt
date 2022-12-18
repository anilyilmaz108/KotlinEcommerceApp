package com.anilyilmaz.ecommerceapp.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.anilyilmaz.ecommerceapp.services.database.ProductDatabase
import com.anilyilmaz.ecommerceapp.services.database.ProductDbModel

class DetailFragmentViewModel : ViewModel() {

    fun insertData(context: Context, id_: Int, name: String, image: String, description: String, category: String, memory: Int, color: String, price: Int, piece: Int, auth: String){
        val productDatabase = ProductDatabase.getProductDatabase(context)

        val product = ProductDbModel(id_,name,image,description,category,memory,color,price,piece,
            auth)
        productDatabase?.productDao()?.insert(product)
    }

}