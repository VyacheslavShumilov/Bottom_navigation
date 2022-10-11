package com.hfad.bottom_navigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfad.bottom_navigation.databinding.ItemCarBinding

class CarAdapter(): RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    val carList = ArrayList<Cars>()

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemCarBinding.bind(item)
        fun bind(cars: Cars) = with(binding) {
            carImage.setImageResource(cars.imageId)
            carName.text = cars.name
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(carList[position])
    }

    fun addCar(cars: Cars){
        carList.add(cars)
        notifyDataSetChanged()
    }
}

