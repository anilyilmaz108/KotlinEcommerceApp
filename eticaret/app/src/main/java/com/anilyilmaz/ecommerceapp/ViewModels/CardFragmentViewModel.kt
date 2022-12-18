package com.anilyilmaz.ecommerceapp.ViewModels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anilyilmaz.ecommerceapp.Adapters.CardFragmentAdapter
import com.anilyilmaz.ecommerceapp.services.database.ProductDatabase

class CardFragmentViewModel : ViewModel() {
    var totalPrice = MutableLiveData<Int>()
    //var totalPrice = 0
    init {
        totalPrice = MutableLiveData<Int>(0)
    }

    fun cardFunc(context: Context, cardRv: RecyclerView, firebaseAuth: String){

        lateinit var cardFragmentAdapter: CardFragmentAdapter
        val productDatabase = ProductDatabase.getProductDatabase(context)

        cardRv.apply {
            val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(context)
            cardRv.layoutManager = layoutManager

        }

        cardFragmentAdapter = CardFragmentAdapter(productDatabase?.productDao()?.getAllProducts()!!.filter {
            it.currentUser == firebaseAuth
        },context)
        cardRv.adapter = cardFragmentAdapter



        var i = 0
        totalPrice.value = 0
        while (i < productDatabase.productDao().getAllProducts().filter {
                it.currentUser == firebaseAuth
            }.size){
            totalPrice.value = totalPrice.value!! + (productDatabase.productDao().getAllProducts().filter {
                it.currentUser == firebaseAuth
            }[i].price * productDatabase.productDao().getAllProducts().filter {
                it.currentUser == firebaseAuth
            }[i].piece)
            i++
        }

        cardFragmentAdapter.notifyDataSetChanged()
    }


}