package com.anilyilmaz.ecommerceapp.Adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.anilyilmaz.ecommerceapp.Fragments.HomeFragmentDirections
import com.anilyilmaz.ecommerceapp.R
import com.anilyilmaz.ecommerceapp.models.ProductModel
import com.anilyilmaz.ecommerceapp.services.database.ProductDatabase
import com.anilyilmaz.ecommerceapp.services.database.ProductDbModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso


class HomeFragmentAdapter(private val productList : ArrayList<ProductModel>, context: Context)
    : RecyclerView.Adapter<HomeFragmentAdapter.RowHolder>() {

    private lateinit var firebaseAuth : FirebaseAuth
    val studentDatabase = ProductDatabase.getProductDatabase(context)

    inner class RowHolder(view:View):RecyclerView.ViewHolder(view){
        var imageViewFilmResim: ImageView
        var textViewFilmBaslik: TextView
        var textViewFilmFiyat: TextView
        var buttonSepeteEkle: Button
        var cardViewProduct: CardView

        var pieceLayout: LinearLayout
        var buttonAdd: Button
        var pieceText: TextView
        var buttonRemove: Button
        var buttonCheck: Button

        var buttonWhite: Button
        var buttonBlack: Button
        var buttonGreen: Button
        var buttonPurple: Button
        var buttonPink: Button
        var buttonBlue: Button
        var buttonGrey: Button
        var buttonBeige: Button
        var buttonBurgundy: Button


        init {
            firebaseAuth = FirebaseAuth.getInstance()

            imageViewFilmResim = view.findViewById(R.id.imageViewlogo)
            textViewFilmBaslik = view.findViewById(R.id.textViewFilmBaslik)
            textViewFilmFiyat = view.findViewById(R.id.textViewFilmFiyat)
            buttonSepeteEkle = view.findViewById(R.id.buttonSepeteEkle)
            cardViewProduct = view.findViewById(R.id.cardViewProduct)

            buttonWhite = view.findViewById(R.id.buttonWhite)
            buttonBlack = view.findViewById(R.id.buttonBlack)
            buttonGreen = view.findViewById(R.id.buttonGreen)
            buttonPurple = view.findViewById(R.id.buttonPurple)
            buttonPink = view.findViewById(R.id.buttonPink)
            buttonBlue = view.findViewById(R.id.buttonBlue)
            buttonGrey = view.findViewById(R.id.buttonGrey)
            buttonBeige = view.findViewById(R.id.buttonBeige)
            buttonBurgundy = view.findViewById(R.id.buttonBurgundy)

            pieceLayout = view.findViewById(R.id.pieceLayout)
            buttonAdd = view.findViewById(R.id.buttonAdd)
            pieceText = view.findViewById(R.id.pieceText)
            buttonRemove = view.findViewById(R.id.buttonRemove)
            buttonCheck = view.findViewById(R.id.buttonCheck)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_product,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {

        val product = productList[position]
        var tempColor = product.color[0]
        var tempImage = product.image[0]

        holder.textViewFilmBaslik.text = product.name
        holder.textViewFilmFiyat.text = "${product.price} ₺"
        Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)

      var i = 0
        while (i < product.color.size){
            if (product.color[i].contains("White")){
                holder.buttonWhite.visibility = View.VISIBLE
            }
            else if (product.color[i].contains("Black")){
                holder.buttonBlack.visibility = View.VISIBLE
            }
            else if (product.color[i].contains("Green")){
                holder.buttonGreen.visibility = View.VISIBLE
            }
            else if (product.color[i].contains("Purple")){
                holder.buttonPurple.visibility = View.VISIBLE
            }
            else if (product.color[i].contains("Pink")){
                holder.buttonPink.visibility = View.VISIBLE
            }
            else if (product.color[i].contains("Blue")){
                holder.buttonBlue.visibility = View.VISIBLE
            }
            else if (product.color[i].contains("Grey")){
                holder.buttonGrey.visibility = View.VISIBLE
            }
            else if (product.color[i].contains("Beige")){
                holder.buttonBeige.visibility = View.VISIBLE
            }
            else if (product.color[i].contains("Burgundy")){
                holder.buttonBurgundy.visibility = View.VISIBLE
            }
            i++

        }

        if(product.id_ == 1){
            holder.buttonPurple.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "Purple"
                tempImage = product.image[0]
            }
            holder.buttonGrey.setOnClickListener {
                Picasso.get().load(product.image[1]).into(holder.imageViewFilmResim)
                tempColor = "Grey"
                tempImage = product.image[1]
            }
            holder.buttonBlue.setOnClickListener {
                Picasso.get().load(product.image[2]).into(holder.imageViewFilmResim)
                tempColor = "Blue"
                tempImage = product.image[2]
            }
            holder.buttonPink.setOnClickListener {
                Picasso.get().load(product.image[3]).into(holder.imageViewFilmResim)
                tempColor = "Pink"
                tempImage = product.image[3]
            }
        }
        if(product.id_ == 2){
            holder.buttonGrey.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "Grey"
                tempImage = product.image[0]
            }
            holder.buttonBlack.setOnClickListener {
                Picasso.get().load(product.image[1]).into(holder.imageViewFilmResim)
                tempColor = "Black"
                tempImage = product.image[1]
            }
            holder.buttonBeige.setOnClickListener {
                Picasso.get().load(product.image[2]).into(holder.imageViewFilmResim)
                tempColor = "Beige"
                tempImage = product.image[2]
            }
        }
        if(product.id_ == 3){
            holder.buttonBurgundy.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "Burgundy"
                tempImage = product.image[0]
            }
            holder.buttonBlack.setOnClickListener {
                Picasso.get().load(product.image[1]).into(holder.imageViewFilmResim)
                tempColor = "Black"
                tempImage = product.image[1]
            }
            holder.buttonGreen.setOnClickListener {
                Picasso.get().load(product.image[2]).into(holder.imageViewFilmResim)
                tempColor = "Green"
                tempImage = product.image[2]
            }
            holder.buttonWhite.setOnClickListener {
                Picasso.get().load(product.image[3]).into(holder.imageViewFilmResim)
                tempColor = "White"
                tempImage = product.image[3]
            }
        }
        if(product.id_ == 4){
            holder.buttonWhite.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "White"
                tempImage = product.image[0]
            }
            holder.buttonBlack.setOnClickListener {
                Picasso.get().load(product.image[1]).into(holder.imageViewFilmResim)
                tempColor = "Black"
                tempImage = product.image[1]
            }
            holder.buttonGreen.setOnClickListener {
                Picasso.get().load(product.image[2]).into(holder.imageViewFilmResim)
                tempColor = "Green"
                tempImage = product.image[2]
            }
            holder.buttonPink.setOnClickListener {
                Picasso.get().load(product.image[3]).into(holder.imageViewFilmResim)
                tempColor = "Pink"
                tempImage = product.image[3]
            }
        }
        if(product.id_ == 5){
            holder.buttonWhite.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "White"
                tempImage = product.image[0]
            }
            holder.buttonBlack.setOnClickListener {
                Picasso.get().load(product.image[1]).into(holder.imageViewFilmResim)
                tempColor = "Black"
                tempImage = product.image[1]
            }
            holder.buttonGreen.setOnClickListener {
                Picasso.get().load(product.image[2]).into(holder.imageViewFilmResim)
                tempColor = "Green"
                tempImage = product.image[2]
            }
            holder.buttonPurple.setOnClickListener {
                Picasso.get().load(product.image[3]).into(holder.imageViewFilmResim)
                tempColor = "Purple"
                tempImage = product.image[3]
            }
            holder.buttonPink.setOnClickListener {
                Picasso.get().load(product.image[4]).into(holder.imageViewFilmResim)
                tempColor = "Pink"
                tempImage = product.image[4]
            }
        }
        if(product.id_ == 6){
            holder.buttonBlack.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "Black"
                tempImage = product.image[0]
            }
        }
        if(product.id_ == 7){
            holder.buttonBlack.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "Black"
                tempImage = product.image[0]
            }
            holder.buttonWhite.setOnClickListener {
                Picasso.get().load(product.image[1]).into(holder.imageViewFilmResim)
                tempColor = "White"
                tempImage = product.image[1]
            }
            holder.buttonPink.setOnClickListener {
                Picasso.get().load(product.image[2]).into(holder.imageViewFilmResim)
                tempColor = "Pink"
                tempImage = product.image[2]
            }
        }
        if(product.id_ == 8){
            holder.buttonBlack.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "Black"
                tempImage = product.image[0]
            }
            holder.buttonWhite.setOnClickListener {
                Picasso.get().load(product.image[1]).into(holder.imageViewFilmResim)
                tempColor = "White"
                tempImage = product.image[1]
            }
            holder.buttonPink.setOnClickListener {
                Picasso.get().load(product.image[2]).into(holder.imageViewFilmResim)
                tempColor = "Pink"
                tempImage = product.image[2]
            }
        }
        if(product.id_ == 9){
            holder.buttonBlack.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "Black"
                tempImage = product.image[0]
            }
            holder.buttonWhite.setOnClickListener {
                Picasso.get().load(product.image[1]).into(holder.imageViewFilmResim)
                tempColor = "White"
                tempImage = product.image[1]
            }
            holder.buttonPink.setOnClickListener {
                Picasso.get().load(product.image[2]).into(holder.imageViewFilmResim)
                tempColor = "Pink"
                tempImage = product.image[2]
            }
        }
        if(product.id_ == 10){
            holder.buttonBlack.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "Black"
                tempImage = product.image[0]
            }
            holder.buttonWhite.setOnClickListener {
                Picasso.get().load(product.image[1]).into(holder.imageViewFilmResim)
                tempColor = "White"
                tempImage = product.image[1]
            }
            holder.buttonPink.setOnClickListener {
                Picasso.get().load(product.image[2]).into(holder.imageViewFilmResim)
                tempColor = "Pink"
                tempImage = product.image[2]
            }
        }
        if(product.id_ == 11){
            holder.buttonBlack.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "Black"
                tempImage = product.image[0]
            }
            holder.buttonGrey.setOnClickListener {
                Picasso.get().load(product.image[1]).into(holder.imageViewFilmResim)
                tempColor = "Grey"
                tempImage = product.image[1]
            }
        }
        if(product.id_ == 12){
            holder.buttonWhite.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "White"
                tempImage = product.image[0]
            }
            holder.buttonBlack.setOnClickListener {
                Picasso.get().load(product.image[1]).into(holder.imageViewFilmResim)
                tempColor = "Black"
                tempImage = product.image[1]
            }
            holder.buttonPink.setOnClickListener {
                Picasso.get().load(product.image[2]).into(holder.imageViewFilmResim)
                tempColor = "Pink"
                tempImage = product.image[2]
            }
        }
        if(product.id_ == 13){
            holder.buttonBlack.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "Black"
                tempImage = product.image[0]
            }
            holder.buttonWhite.setOnClickListener {
                Picasso.get().load(product.image[1]).into(holder.imageViewFilmResim)
                tempColor = "White"
                tempImage = product.image[1]
            }
        }
        if(product.id_ == 14){
            holder.buttonBlack.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "Black"
                tempImage = product.image[0]
            }
            holder.buttonGreen.setOnClickListener {
                Picasso.get().load(product.image[1]).into(holder.imageViewFilmResim)
                tempColor = "Green"
                tempImage = product.image[1]
            }
            holder.buttonWhite.setOnClickListener {
                Picasso.get().load(product.image[2]).into(holder.imageViewFilmResim)
                tempColor = "White"
                tempImage = product.image[2]
            }
        }
        if(product.id_ == 15){
            holder.buttonBlack.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "Black"
                tempImage = product.image[0]
            }
        }
        if(product.id_ == 16){
            holder.buttonPurple.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "Purple"
                tempImage = product.image[0]
            }
            holder.buttonBlack.setOnClickListener {
                Picasso.get().load(product.image[1]).into(holder.imageViewFilmResim)
                tempColor = "Black"
                tempImage = product.image[1]
            }
            holder.buttonWhite.setOnClickListener {
                Picasso.get().load(product.image[2]).into(holder.imageViewFilmResim)
                tempColor = "White"
                tempImage = product.image[2]
            }
        }
        if(product.id_ == 17){
            holder.buttonGrey.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "Grey"
                tempImage = product.image[0]
            }
            holder.buttonBlack.setOnClickListener {
                Picasso.get().load(product.image[1]).into(holder.imageViewFilmResim)
                tempColor = "Black"
                tempImage = product.image[1]
            }
            holder.buttonGreen.setOnClickListener {
                Picasso.get().load(product.image[2]).into(holder.imageViewFilmResim)
                tempColor = "Green"
                tempImage = product.image[2]
            }
            holder.buttonPurple.setOnClickListener {
                Picasso.get().load(product.image[3]).into(holder.imageViewFilmResim)
                tempColor = "Purple"
                tempImage = product.image[3]
            }
            holder.buttonWhite.setOnClickListener {
                Picasso.get().load(product.image[4]).into(holder.imageViewFilmResim)
                tempColor = "White"
                tempImage = product.image[4]
            }
        }
        if(product.id_ == 18){
            holder.buttonBlack.setOnClickListener {
                Picasso.get().load(product.image[0]).into(holder.imageViewFilmResim)
                tempColor = "Black"
                tempImage = product.image[0]
            }
        }

        holder.buttonSepeteEkle.setOnClickListener {
            var piece = 1

            val id_ = product.id_
            val name = product.name
            val image = tempImage
            val description = product.description
            val category = product.category
            val memory = product.memory
            val color = tempColor
            val price = product.price

            holder.pieceLayout.visibility = View.VISIBLE
            holder.buttonAdd.setOnClickListener {
                piece = piece + 1
                holder.pieceText.text = piece.toString()
            }

            holder.buttonRemove.setOnClickListener {
                if(piece < 1){
                    holder.pieceLayout.visibility = View.GONE
                    piece = 1
                }
                piece = piece - 1
                holder.pieceText.text = piece.toString()
            }

            holder.buttonCheck.setOnClickListener {
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
                    val student = ProductDbModel(id_,name,image,description,category,memory,color,price,piece,
                        firebaseAuth.currentUser!!.email.toString())
                    studentDatabase?.productDao()?.insert(student)
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

        holder.cardViewProduct.setOnClickListener {
            val gecis = HomeFragmentDirections.actionHomeFragmentToDetailFragment(product = product)
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }


}
