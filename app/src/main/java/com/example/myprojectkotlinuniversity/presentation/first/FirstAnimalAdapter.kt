package com.example.myprojectkotlinuniversity.presentation.first

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myprojectkotlinuniversity.data.Animal
import com.example.myprojectkotlinuniversity.R


class FirstAnimalAdapter(val listener: Listener) :
    RecyclerView.Adapter<FirstAnimalAdapter.ViewHolder>() {

    private val arrayOfAnimals = ArrayList<Animal>()

    fun setListOfAnimals(arrayOfAnimals: List<Animal>) {
        this.arrayOfAnimals.clear()
        this.arrayOfAnimals.addAll(arrayOfAnimals)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.findViewById(R.id.iv_image)
        val textViewName: TextView = itemView.findViewById(R.id.tv_name)
        val textViewDescShort: TextView = itemView.findViewById(R.id.tv_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return arrayOfAnimals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val animal = arrayOfAnimals[position]
        holder.itemView.setOnClickListener {
            listener.onClick(position)
        }

        Glide.with(holder.itemView.context)
            .load(arrayOfAnimals.get(position).urlIcon).fitCenter().into(holder.imageView)

        holder.textViewName.text = animal.name
        holder.textViewDescShort.text = animal.shortDesc


    }

    interface Listener {
        fun onClick(itemView: Int)
    }

}