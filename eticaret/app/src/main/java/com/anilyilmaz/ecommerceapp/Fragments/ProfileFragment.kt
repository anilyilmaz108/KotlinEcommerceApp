package com.anilyilmaz.ecommerceapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.anilyilmaz.ecommerceapp.ViewModels.ProfileFragmentViewModel
import com.anilyilmaz.ecommerceapp.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private lateinit var firebaseAuth : FirebaseAuth
    private val binding get() = _binding!!
    private val viewmodel: ProfileFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        firebaseAuth = FirebaseAuth.getInstance()

        if(firebaseAuth.currentUser!!.isAnonymous){
            binding.textTitle.text = "Anonymous"
            binding.email.text = "Sign in with anonymously"
            binding.isAnonymous.text = "Anonymous : " + firebaseAuth.currentUser!!.isAnonymous.toString()
            binding.cardNumber.text = "-"
        }
        else{
            binding.textTitle.text = (firebaseAuth.currentUser?.email.toString().split("@")[0]).toString()
            binding.email.text = firebaseAuth.currentUser?.email.toString()
            binding.isAnonymous.text = "Anonymous : " + firebaseAuth.currentUser!!.isAnonymous.toString()
            viewmodel.profileDataFromDatabase(requireContext(),firebaseAuth.currentUser?.email.toString(),binding.cardNumber).toString()
        }

        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}