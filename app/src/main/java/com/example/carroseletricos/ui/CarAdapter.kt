package com.example.carroseletricos.ui

import android.content.Intent
import android.net.Uri
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.text.bold
import androidx.recyclerview.widget.RecyclerView
import com.example.carroseletricos.CarActivity
import com.example.carroseletricos.R
import com.example.carroseletricos.data.Car
import com.example.carroseletricos.data.CarImages

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
        val starRating: RatingBar = view.findViewById(R.id.ratingBar1)
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
        holder.txtMake.text = theCar.make
        holder.txtModel.text = theCar.model
        holder.txtEdition.text = theCar.edition

        val spanBodyStyle = SpannableStringBuilder().append("Segmento"+"\t\t\t\t\t\t")
            .bold { append(theCar.bodyStyle.toString()) }
        holder.txtBodyStyle.text = spanBodyStyle
        //holder.txtBodyStyle.text = "Segmento: " + theCar.bodyStyle

        val spanPrice = SpannableStringBuilder().append("Preço"+"\t\t\t\t\t\t\t\t\t\t")
            .bold { append(theCar.price.toString()+" €") }
        holder.txtPrice.text = spanPrice
        //holder.txtPrice.text = "Preço: " + theCar.price.toString()+" €"

        val spanAcceleration = SpannableStringBuilder().append("Acceleração"+"\t\t\t")
            .bold { append(theCar.acceleration.toString()+" seg") }
        holder.txtAcceleration.text = spanAcceleration
        //holder.txtAcceleration.text = "Acceleração: " + theCar.acceleration.toString()+" seg"


        val spanPower = SpannableStringBuilder().append("Potência"+"\t\t\t\t\t\t\t")
            .bold { append(theCar.power.toString()+" cv") }
        holder.txtPower.text = spanPower
        //holder.txtPower.text = "Potência: " + theCar.power.toString()+" cv"

        val spanRange = SpannableStringBuilder().append("Autonomia"+"\t\t\t\t\t")
            .bold { append(theCar.range.toString()+" km") }
        holder.txtRange.text = spanRange
        //holder.txtRange.text = "Autonomia: " + theCar.range.toString()+" km"

        holder.starRating.rating = theCar.rating.toFloat()

        holder.btnMoreInfo.setOnClickListener {
            val url: String = CarActivity.SEARCH_PREFIX +
                    theCar.make + " " + theCar.model

            val intent: Intent = Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse(url)
            }
            startActivity(holder.btnMoreInfo.context, intent, null)
        }
    }
    }