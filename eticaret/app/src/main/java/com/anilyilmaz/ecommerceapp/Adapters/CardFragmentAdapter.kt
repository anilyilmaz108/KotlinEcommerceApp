package com.anilyilmaz.ecommerceapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.anilyilmaz.ecommerceapp.Fragments.CardFragmentDirections
import com.anilyilmaz.ecommerceapp.R
import com.anilyilmaz.ecommerceapp.services.database.ProductDatabase
import com.anilyilmaz.ecommerceapp.services.database.ProductDbModel
import com.squareup.picasso.Picasso

class CardFragmentAdapter(private val productList: List<ProductDbModel>, context: Context)
    : RecyclerView.Adapter<CardFragmentAdapter.RowHolder>() {

    val studentDatabase = ProductDatabase.getProductDatabase(context)

    inner class RowHolder(view: View): RecyclerView.ViewHolder(view){
        var imageViewCard: ImageView
        var textName: TextView
        var textNumber: TextView
        var textPrice: TextView
        var buttonremove: ImageButton

        init {

            imageViewCard = view.findViewById(R.id.imageViewCard)
            textName = view.findViewById(R.id.text_name)
            textNumber = view.findViewById(R.id.text_number)
            textPrice = view.findViewById(R.id.text_price)
            buttonremove = view.findViewById(R.id.removeButton)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardFragmentAdapter.RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_product,parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: CardFragmentAdapter.RowHolder, position: Int) {

        val film = productList[position]

        holder.textName.text = film.name
        holder.textPrice.text = film.price.toString() + "₺"
        holder.textNumber.text = film.piece.toString()
        Picasso.get().load(film.uimage.toUri()).into(holder.imageViewCard)

        holder.buttonremove.setOnClickListener {

            studentDatabase?.productDao()?.delete(film)

            val gecis = CardFragmentDirections.actionCardFragmentSelf(film)
            Navigation.findNavController(it).navigate(gecis)

            productList.drop(position)
            
            notifyItemRemoved(position)
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
        return productList.size
    }
}