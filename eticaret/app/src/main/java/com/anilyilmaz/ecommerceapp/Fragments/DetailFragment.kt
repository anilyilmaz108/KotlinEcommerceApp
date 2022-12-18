package com.anilyilmaz.ecommerceapp.Fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.anilyilmaz.ecommerceapp.ViewModels.DetailFragmentViewModel
import com.anilyilmaz.ecommerceapp.databinding.FragmentDetailBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private lateinit var firebaseAuth : FirebaseAuth

    private val binding get() = _binding!!
    private val viewmodel: DetailFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        firebaseAuth = FirebaseAuth.getInstance()

        val bundle: DetailFragmentArgs by navArgs()

        var tempColor = bundle.product.color[0]
        var tempImage = bundle.product.image[0]

        binding.textViewFilmBaslik.text = bundle.product.name
        binding.textViewFilmFiyat.text = "${bundle.product.price} ₺"
        Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)

        binding.textViewFilmDescription.text = bundle.product.description

        var i = 0
        while (i < bundle.product.color.size){
            if (bundle.product.color[i].contains("White")){
                binding.buttonWhite.visibility = View.VISIBLE
            }
            else if (bundle.product.color[i].contains("Black")){
                binding.buttonBlack.visibility = View.VISIBLE
            }
            else if (bundle.product.color[i].contains("Green")){
                binding.buttonGreen.visibility = View.VISIBLE
            }
            else if (bundle.product.color[i].contains("Purple")){
                binding.buttonPurple.visibility = View.VISIBLE
            }
            else if (bundle.product.color[i].contains("Pink")){
                binding.buttonPink.visibility = View.VISIBLE
            }
            else if (bundle.product.color[i].contains("Blue")){
                binding.buttonBlue.visibility = View.VISIBLE
            }
            else if (bundle.product.color[i].contains("Grey")){
                binding.buttonGrey.visibility = View.VISIBLE
            }
            else if (bundle.product.color[i].contains("Beige")){
                binding.buttonBeige.visibility = View.VISIBLE
            }
            else if (bundle.product.color[i].contains("Burgundy")){
                binding.buttonBurgundy.visibility = View.VISIBLE
            }
            i++

        }

        if(bundle.product.id_ == 1){
            binding.buttonPurple.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "Purple"
                tempImage = bundle.product.image[0]
            }
            binding.buttonGrey.setOnClickListener {
                Picasso.get().load(bundle.product.image[1]).into(binding.imageViewlogo)
                tempColor = "Grey"
                tempImage = bundle.product.image[1]
            }
            binding.buttonBlue.setOnClickListener {
                Picasso.get().load(bundle.product.image[2]).into(binding.imageViewlogo)
                tempColor = "Blue"
                tempImage = bundle.product.image[2]
            }
            binding.buttonPink.setOnClickListener {
                Picasso.get().load(bundle.product.image[3]).into(binding.imageViewlogo)
                tempColor = "Pink"
                tempImage = bundle.product.image[3]
            }
        }
        if(bundle.product.id_ == 2){
            binding.buttonGrey.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "Grey"
                tempImage = bundle.product.image[0]
            }
            binding.buttonBlack.setOnClickListener {
                Picasso.get().load(bundle.product.image[1]).into(binding.imageViewlogo)
                tempColor = "Black"
                tempImage = bundle.product.image[1]
            }
            binding.buttonBeige.setOnClickListener {
                Picasso.get().load(bundle.product.image[2]).into(binding.imageViewlogo)
                tempColor = "Beige"
                tempImage = bundle.product.image[2]
            }
        }
        if(bundle.product.id_ == 3){
            binding.buttonBurgundy.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "Burgundy"
                tempImage = bundle.product.image[0]
            }
            binding.buttonBlack.setOnClickListener {
                Picasso.get().load(bundle.product.image[1]).into(binding.imageViewlogo)
                tempColor = "Black"
                tempImage = bundle.product.image[1]
            }
            binding.buttonGreen.setOnClickListener {
                Picasso.get().load(bundle.product.image[2]).into(binding.imageViewlogo)
                tempColor = "Green"
                tempImage = bundle.product.image[2]
            }
            binding.buttonWhite.setOnClickListener {
                Picasso.get().load(bundle.product.image[3]).into(binding.imageViewlogo)
                tempColor = "White"
                tempImage = bundle.product.image[3]
            }
        }
        if(bundle.product.id_ == 4){
            binding.buttonWhite.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "White"
                tempImage = bundle.product.image[0]
            }
            binding.buttonBlack.setOnClickListener {
                Picasso.get().load(bundle.product.image[1]).into(binding.imageViewlogo)
                tempColor = "Black"
                tempImage = bundle.product.image[1]
            }
            binding.buttonGreen.setOnClickListener {
                Picasso.get().load(bundle.product.image[2]).into(binding.imageViewlogo)
                tempColor = "Green"
                tempImage = bundle.product.image[2]
            }
            binding.buttonPink.setOnClickListener {
                Picasso.get().load(bundle.product.image[3]).into(binding.imageViewlogo)
                tempColor = "Pink"
                tempImage = bundle.product.image[3]
            }
        }
        if(bundle.product.id_ == 5){
            binding.buttonWhite.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "White"
                tempImage = bundle.product.image[0]
            }
            binding.buttonBlack.setOnClickListener {
                Picasso.get().load(bundle.product.image[1]).into(binding.imageViewlogo)
                tempColor = "Black"
                tempImage = bundle.product.image[1]
            }
            binding.buttonGreen.setOnClickListener {
                Picasso.get().load(bundle.product.image[2]).into(binding.imageViewlogo)
                tempColor = "Green"
                tempImage = bundle.product.image[2]
            }
            binding.buttonPurple.setOnClickListener {
                Picasso.get().load(bundle.product.image[3]).into(binding.imageViewlogo)
                tempColor = "Purple"
                tempImage = bundle.product.image[3]
            }
            binding.buttonPink.setOnClickListener {
                Picasso.get().load(bundle.product.image[4]).into(binding.imageViewlogo)
                tempColor = "Pink"
                tempImage = bundle.product.image[4]
            }
        }
        if(bundle.product.id_ == 6){
            binding.buttonBlack.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "Black"
                tempImage = bundle.product.image[0]
            }
        }
        if(bundle.product.id_ == 7){
            binding.buttonBlack.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "Black"
                tempImage = bundle.product.image[0]
            }
            binding.buttonWhite.setOnClickListener {
                Picasso.get().load(bundle.product.image[1]).into(binding.imageViewlogo)
                tempColor = "White"
                tempImage = bundle.product.image[1]
            }
            binding.buttonPink.setOnClickListener {
                Picasso.get().load(bundle.product.image[2]).into(binding.imageViewlogo)
                tempColor = "Pink"
                tempImage = bundle.product.image[2]
            }
        }
        if(bundle.product.id_ == 8){
            binding.buttonBlack.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "Black"
                tempImage = bundle.product.image[0]
            }
            binding.buttonWhite.setOnClickListener {
                Picasso.get().load(bundle.product.image[1]).into(binding.imageViewlogo)
                tempColor = "White"
                tempImage = bundle.product.image[1]
            }
            binding.buttonPink.setOnClickListener {
                Picasso.get().load(bundle.product.image[2]).into(binding.imageViewlogo)
                tempColor = "Pink"
                tempImage = bundle.product.image[2]
            }
        }
        if(bundle.product.id_ == 9){
            binding.buttonBlack.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "Black"
                tempImage = bundle.product.image[0]
            }
            binding.buttonWhite.setOnClickListener {
                Picasso.get().load(bundle.product.image[1]).into(binding.imageViewlogo)
                tempColor = "White"
                tempImage = bundle.product.image[1]
            }
            binding.buttonPink.setOnClickListener {
                Picasso.get().load(bundle.product.image[2]).into(binding.imageViewlogo)
                tempColor = "Pink"
                tempImage = bundle.product.image[2]
            }
        }
        if(bundle.product.id_ == 10){
            binding.buttonBlack.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "Black"
                tempImage = bundle.product.image[0]
            }
            binding.buttonWhite.setOnClickListener {
                Picasso.get().load(bundle.product.image[1]).into(binding.imageViewlogo)
                tempColor = "White"
                tempImage = bundle.product.image[1]
            }
            binding.buttonPink.setOnClickListener {
                Picasso.get().load(bundle.product.image[2]).into(binding.imageViewlogo)
                tempColor = "Pink"
                tempImage = bundle.product.image[2]
            }
        }
        if(bundle.product.id_ == 11){
            binding.buttonBlack.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "Black"
                tempImage = bundle.product.image[0]
            }
            binding.buttonGrey.setOnClickListener {
                Picasso.get().load(bundle.product.image[1]).into(binding.imageViewlogo)
                tempColor = "Grey"
                tempImage = bundle.product.image[1]
            }
        }
        if(bundle.product.id_ == 12){
            binding.buttonWhite.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "White"
                tempImage = bundle.product.image[0]
            }
            binding.buttonBlack.setOnClickListener {
                Picasso.get().load(bundle.product.image[1]).into(binding.imageViewlogo)
                tempColor = "Black"
                tempImage = bundle.product.image[1]
            }
            binding.buttonPink.setOnClickListener {
                Picasso.get().load(bundle.product.image[2]).into(binding.imageViewlogo)
                tempColor = "Pink"
                tempImage = bundle.product.image[2]
            }
        }
        if(bundle.product.id_ == 13){
            binding.buttonBlack.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "Black"
                tempImage = bundle.product.image[0]
            }
            binding.buttonWhite.setOnClickListener {
                Picasso.get().load(bundle.product.image[1]).into(binding.imageViewlogo)
                tempColor = "White"
                tempImage = bundle.product.image[1]
            }
        }
        if(bundle.product.id_ == 14){
            binding.buttonBlack.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "Black"
                tempImage = bundle.product.image[0]
            }
            binding.buttonGreen.setOnClickListener {
                Picasso.get().load(bundle.product.image[1]).into(binding.imageViewlogo)
                tempColor = "Green"
                tempImage = bundle.product.image[1]
            }
            binding.buttonWhite.setOnClickListener {
                Picasso.get().load(bundle.product.image[2]).into(binding.imageViewlogo)
                tempColor = "White"
                tempImage = bundle.product.image[2]
            }
        }
        if(bundle.product.id_ == 15){
            binding.buttonBlack.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "Black"
                tempImage = bundle.product.image[0]
            }
        }
        if(bundle.product.id_ == 16){
            binding.buttonPurple.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "Purple"
                tempImage = bundle.product.image[0]
            }
            binding.buttonBlack.setOnClickListener {
                Picasso.get().load(bundle.product.image[1]).into(binding.imageViewlogo)
                tempColor = "Black"
                tempImage = bundle.product.image[1]
            }
            binding.buttonWhite.setOnClickListener {
                Picasso.get().load(bundle.product.image[2]).into(binding.imageViewlogo)
                tempColor = "White"
                tempImage = bundle.product.image[2]
            }
        }
        if(bundle.product.id_ == 17){
            binding.buttonGrey.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "Grey"
                tempImage = bundle.product.image[0]
            }
            binding.buttonBlack.setOnClickListener {
                Picasso.get().load(bundle.product.image[1]).into(binding.imageViewlogo)
                tempColor = "Black"
                tempImage = bundle.product.image[1]
            }
            binding.buttonGreen.setOnClickListener {
                Picasso.get().load(bundle.product.image[2]).into(binding.imageViewlogo)
                tempColor = "Green"
                tempImage = bundle.product.image[2]
            }
            binding.buttonPurple.setOnClickListener {
                Picasso.get().load(bundle.product.image[3]).into(binding.imageViewlogo)
                tempColor = "Purple"
                tempImage = bundle.product.image[3]
            }
            binding.buttonWhite.setOnClickListener {
                Picasso.get().load(bundle.product.image[4]).into(binding.imageViewlogo)
                tempColor = "White"
                tempImage = bundle.product.image[4]
            }
        }
        if(bundle.product.id_ == 18){
            binding.buttonBlack.setOnClickListener {
                Picasso.get().load(bundle.product.image[0]).into(binding.imageViewlogo)
                tempColor = "Black"
                tempImage = bundle.product.image[0]
            }
        }

        binding.buttonSepeteEkle.setOnClickListener {
            var piece = 1
            val id_ = bundle.product.id_
            val name = bundle.product.name
            val image = tempImage
            val description = bundle.product.description
            val category = bundle.product.category
            val memory = bundle.product.memory
            val color = tempColor
            val price = bundle.product.price


            binding.pieceLayout.visibility = View.VISIBLE
            binding.buttonAdd.setOnClickListener {
                piece = piece + 1
                binding.pieceText.text = piece.toString()
            }

            binding.buttonRemove.setOnClickListener {
                if(piece < 1){
                    binding.pieceLayout.visibility = View.GONE
                    piece = 1
                }
                piece = piece - 1
                binding.pieceText.text = piece.toString()
            }

            binding.buttonCheck.setOnClickListener {
                if(firebaseAuth.currentUser!!.isAnonymous){
                    val snackBar = Snackbar.make(
                        it, "You cannot add to cart because you are logged in anonymously",
                        Snackbar.LENGTH_SHORT
                    ).setAction("Action", null)
                    snackBar.setActionTextColor(Color.WHITE)
                    val snackBarView = snackBar.view
                    snackBarView.setBackgroundColor(Color.RED)
                    val textView = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
                    textView.setTextColor(Color.WHITE)
                    snackBar.show()
                }
                else{
                    viewmodel.insertData(requireContext(),id_,name,image,description,category,memory,color,price,piece,firebaseAuth.currentUser!!.email.toString())

                    piece = 1

                    val snackBar = Snackbar.make(
                        it, "$name is added your card",
                        Snackbar.LENGTH_SHORT
                    ).setAction("Action", null)
                    snackBar.setActionTextColor(Color.WHITE)
                    val snackBarView = snackBar.view
                    snackBarView.setBackgroundColor(Color.BLUE)
                    val textView = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
                    textView.setTextColor(Color.WHITE)
                    snackBar.show()
                }

            }

        }

        binding.backImage.setOnClickListener {
            activity?.onBackPressed()
        }

        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}