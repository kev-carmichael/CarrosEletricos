package com.example.carroseletricos

import com.example.carroseletricos.data.Car
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carroseletricos.api.CarService
import com.example.carroseletricos.api.ServiceBuilder
import com.example.carroseletricos.ui.CarAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car)

        loadData()
    }

    val filteredList: MutableList<Car> =  ArrayList<Car>()

    companion object {
        const val MAKE = "make"
        const val SEARCH_PREFIX = "https://www.google.pt/search?q="
    }


    private fun loadData() {
        val service  = ServiceBuilder.buildService(CarService::class.java)
        val requestCall = service.getAllCar()

        requestCall.enqueue(object : Callback<List<Car>> {
            override fun onResponse(call: Call<List<Car>>,
                                    response: Response<List<Car>>
            ) {
                if (response.isSuccessful){
                    //filter data
                    for (item: Car in response.body()!!) {
                        if( (item.price <= intent?.extras?.getInt("MAXPRICE")!!)&&
                            (item.price >= intent?.extras?.getInt("MINPRICE")!!)&&
                            (item.acceleration.toFloat() <= intent?.extras?.getFloat("MAXACCELERATION")!!)&&
                            (item.acceleration.toFloat() >= intent?.extras?.getFloat("MINACCELERATION")!!)&&
                            (item.power <= intent?.extras?.getInt("MAXPOWER")!!)&&
                            (item.power >= intent?.extras?.getInt("MINPOWER")!!)&&
                            (item.range <= intent?.extras?.getInt("MAXRANGE")!!)&&
                            (item.range >= intent?.extras?.getInt("MINRANGE")!!)&&
                            (item.rating <= intent?.extras?.getInt("MAXRATING")!!)&&
                            (item.rating >= intent?.extras?.getInt("MINRATING")!!)){
                            filteredList.add(item)
                        }
                        if(item.make == intent?.extras?.getString(MAKE)
                                .toString().replace("\\s".toRegex(),"")){
                            filteredList.add(item)
                        }
                    }
                    if(filteredList.isEmpty()){
                        showToast()
                    } else{
                        //process data
                        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
                        recyclerView.layoutManager = GridLayoutManager(this@CarActivity,1)
                        recyclerView.adapter = CarAdapter(filteredList)
                    }

                }else{
                    //output alert
                    AlertDialog.Builder(this@CarActivity)
                        .setTitle("API error")
                        .setMessage("Response, but something went wrong ${response.message()}")
                        .setPositiveButton(android.R.string.ok) { _, _ -> }
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show()
                }
            }
            override fun onFailure(call: Call<List<Car>>, t: Throwable) {
                //process failure
                AlertDialog.Builder(this@CarActivity)
                    .setTitle("API error")
                    .setMessage("No response, and something went wrong $t")
                    .setPositiveButton(android.R.string.ok) { _, _ -> }
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show()
            }
        })
    }

    fun showToast(){
        Toast.makeText(this, "No vehicles for values selected", Toast.LENGTH_LONG).show()
    }

}