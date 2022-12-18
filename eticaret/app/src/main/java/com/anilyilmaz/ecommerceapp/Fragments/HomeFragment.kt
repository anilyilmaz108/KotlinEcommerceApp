package com.anilyilmaz.ecommerceapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.anilyilmaz.ecommerceapp.ViewModels.HomeFragmentViewModel
import com.anilyilmaz.ecommerceapp.databinding.FragmentHomeBinding
import kotlinx.coroutines.*

class HomeFragment : Fragment(){
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewmodel: HomeFragmentViewModel by viewModels()
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Error: ${throwable.localizedMessage}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewmodel.loadData(exceptionHandler,binding.homeRv,requireContext(),binding.filterSmartphoneText,binding.filterTabletText,binding.filterWatchText,binding.filterEarphoneText,binding.filterAllText)

        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}