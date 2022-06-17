package com.example.carroseletricos.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.carroseletricos.CarActivity
import com.example.carroseletricos.R

class CarAdapter (private val carList: List<Car>) :
    RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val imgCar: ImageView = view.findViewById(R.id.imgCar)
        val txtMake: TextView = view.findViewById(R.id.txtMake)
        val txtModel: TextView = view.findViewById(R.id.txtModel)
        val txtEdition: TextView = view.findViewById(R.id.txtEdition)
        val txtBodyStyle: TextView = view.findViewById(R.id.txtBodyStyle)
        val txtPrice: TextView = view.findViewById(R.id.txtPrice)
        val txtAcceleration: TextView = view.findViewById(R.id.txtAcceleration)
        val txtPower: TextView = view.findViewById(R.id.txtPower)
        val txtRange: TextView = view.findViewById(R.id.txtRange)
        val txtRating: TextView = view.findViewById(R.id.txtRating)
        val btnMoreInfo: Button = view.findViewById(R.id.btnMoreInfo)
    }

    override fun getItemCount() = carList.size

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.car_recycler_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val theCar = carList.get(position)
        CarImages().carMap.get(theCar.id)?.let { holder.imgCar.setImageResource(it) }
        holder.txtMake.text = "Make: " + theCar.make
        holder.txtModel.text = "Model: " + theCar.model
        holder.txtEdition.text = "Edition: " + theCar.edition
        holder.txtBodyStyle.text = "Model: " + theCar.bodyStyle
        holder.txtPrice.text = "Price: " + theCar.price.toString()+" €"
        holder.txtAcceleration.text = "Acceleration: " + theCar.acceleration.toString()+" sec"
        holder.txtPower.text = "Power: " + theCar.power.toString()+" PS"
        holder.txtRange.text = "Range: " + theCar.range.toString()+" km"
        holder.txtRating.text = "Rating: " + theCar.rating.toString()+" stars"
        holder.btnMoreInfo.setOnClickListener {
            val url: String = CarActivity.SEARCH_PREFIX +
                    theCar.make

            val intent: Intent = Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse(url)
            }
            ContextCompat.startActivity(holder.btnMoreInfo.context, intent, null)
        }
    }
    }