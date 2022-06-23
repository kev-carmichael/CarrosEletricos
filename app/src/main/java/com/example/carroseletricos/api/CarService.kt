package com.example.carroseletricos.api

import com.example.carroseletricos.data.Car
import retrofit2.Call
import retrofit2.http.GET

interface CarService {
    @GET("b/AF0J")
    fun getAllCar(): Call<List<Car>>

}