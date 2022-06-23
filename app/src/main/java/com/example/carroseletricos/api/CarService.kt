package com.example.carroseletricos.api

import com.example.carroseletricos.data.Car
import retrofit2.Call
import retrofit2.http.GET

interface CarService {
    @GET("b/UMXH")
    fun getAllCar(): Call<List<Car>>

}