package com.anilyilmaz.ecommerceapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.anilyilmaz.ecommerceapp.ViewModels.CardFragmentViewModel
import com.anilyilmaz.ecommerceapp.databinding.FragmentCardBinding
import com.google.firebase.auth.FirebaseAuth

class CardFragment : Fragment() {
    private var _binding: FragmentCardBinding? = null
    private lateinit var firebaseAuth : FirebaseAuth
    private val viewmodel: CardFragmentViewModel by viewModels()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardBinding.inflate(inflater, container, false)
        firebaseAuth = FirebaseAuth.getInstance()

        viewmodel.cardFunc(requireContext(),binding.cardRv,firebaseAuth.currentUser?.email.toString())
        binding.buttonBuying.text = "BUY NOW ("+viewmodel.totalPrice.observe(viewLifecycleOwner,{ s ->
            binding.buttonBuying.text = "BUY NOW("+s.toString()+" ₺)"
        })+" ₺)"

        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}