package com.anilyilmaz.ecommerceapp.ViewModels

import android.content.Context
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.anilyilmaz.ecommerceapp.services.database.ProductDatabase

class ProfileFragmentViewModel : ViewModel() {

    fun profileDataFromDatabase(context: Context, firebaseAuth: String, cardNumber: TextView){
        val productDatabase = ProductDatabase.getProductDatabase(context)

        cardNumber.text = productDatabase?.productDao()?.getAllProducts()?.filter {
            it.currentUser == firebaseAuth
        }?.size.toString()
    }
}