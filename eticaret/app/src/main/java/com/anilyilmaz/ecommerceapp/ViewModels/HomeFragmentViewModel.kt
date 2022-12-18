package com.anilyilmaz.ecommerceapp.ViewModels

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.anilyilmaz.ecommerce.utils.ApiUtils
import com.anilyilmaz.ecommerceapp.Adapters.HomeFragmentAdapter
import com.anilyilmaz.ecommerceapp.models.ProductModel
import kotlinx.coroutines.*

class HomeFragmentViewModel : ViewModel(){
    fun loadData(exceptionHandler: CoroutineExceptionHandler, homeRv : RecyclerView, context: Context,
                 smartPhoneTextView: View, filterTabletText: View, filterWatchText: View, filterEarphoneText: View, filterAllText: View){
        lateinit var productModels: ArrayList<ProductModel>
        lateinit var homeFragmentAdapter : HomeFragmentAdapter
        lateinit var filteredList: ArrayList<ProductModel>
        var job : Job? = null
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {

            val response = ApiUtils.getProductApi().getData()

            withContext(Dispatchers.Main){
                if(response.isSuccessful) {
                    response.body()?.let {

                        productModels = ArrayList(it)
                        smartPhoneTextView.setOnClickListener {
                            filteredList= productModels.filter {
                                it.category == "smartphone"
                            } as ArrayList<ProductModel>
                            filteredList?.let {
                                homeRv.setHasFixedSize(true)
                                homeRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                                homeFragmentAdapter = HomeFragmentAdapter(it,context)
                                homeRv.adapter = homeFragmentAdapter

                            }
                        }
                        filterTabletText.setOnClickListener {
                            filteredList= productModels.filter {
                                it.category == "tablet"
                            } as ArrayList<ProductModel>
                            filteredList?.let {
                                homeRv.setHasFixedSize(true)
                                homeRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                                homeFragmentAdapter = HomeFragmentAdapter(it,context)
                                homeRv.adapter = homeFragmentAdapter

                            }
                        }
                        filterWatchText.setOnClickListener {
                            filteredList= productModels.filter {
                                it.category == "watch"
                            } as ArrayList<ProductModel>
                            filteredList?.let {
                                homeRv.setHasFixedSize(true)
                                homeRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                                homeFragmentAdapter = HomeFragmentAdapter(it,context)
                                homeRv.adapter = homeFragmentAdapter

                            }
                        }
                        filterEarphoneText.setOnClickListener {
                            filteredList= productModels.filter {
                                it.category == "earphone"
                            } as ArrayList<ProductModel>
                            filteredList?.let {
                                homeRv.setHasFixedSize(true)
                                homeRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                                homeFragmentAdapter = HomeFragmentAdapter(it,context)
                                homeRv.adapter = homeFragmentAdapter

                            }
                        }
                        filterAllText.setOnClickListener {
                            productModels?.let {
                                homeRv.setHasFixedSize(true)
                                homeRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                                homeFragmentAdapter = HomeFragmentAdapter(it,context)
                                homeRv.adapter = homeFragmentAdapter

                            }
                        }

                        productModels?.let {
                            homeRv.setHasFixedSize(true)
                            homeRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                            homeFragmentAdapter = HomeFragmentAdapter(it,context)
                            homeRv.adapter = homeFragmentAdapter

                        }
                    }
                }
            }
        }
    }
}