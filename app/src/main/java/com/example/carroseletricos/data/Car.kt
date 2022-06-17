package com.example.carroseletricos.data


import com.google.gson.annotations.SerializedName

//class Car : ArrayList<Car.CarItem>(){
    data class CarItem(
        val id: Int,
        val make: String,
        val model: String,
        val edition: String,
        val bodyStyle: String,
        val price: Int,
        val acceleration: Double,
        val power: Int,
        val range: Int,
        val rating: Int
    )
//}