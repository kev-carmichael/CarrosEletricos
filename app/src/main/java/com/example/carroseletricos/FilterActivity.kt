package com.example.carroseletricos

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.slider.RangeSlider

class FilterActivity : AppCompatActivity() {

    //****************THESE NEED FINE-TUNING***************************
    var priceValues: List<Float> = listOf(0.0f, 100000.0f)
    var accelerationValues: List<Float> = listOf(0.0f, 25.0f)
    var powerValues: List<Float> = listOf(0.0f, 1000.0f)
    var rangeValues: List<Float> = listOf(0.0f, 1000.0f)
    var ratingValues: List<Float> = listOf(1.0f, 5.0f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        val txtPriceValues: TextView = findViewById(R.id.txtPriceValues);
        val txtAccelerationValues: TextView = findViewById(R.id.txtAccelerationValues);
        val txtPowerValues: TextView = findViewById(R.id.txtPowerValues);
        val txtRangeValues: TextView = findViewById(R.id.txtRangeValues);
        val txtRatingValues: TextView = findViewById(R.id.txtRatingValues);

        val btnFindCar: Button = findViewById(R.id.btnFindCar)
        btnFindCar.setOnClickListener {
            val minPrice: Float = priceValues[0]
            val maxPrice: Float = priceValues[1]
            val minAcceleration: Float = accelerationValues[0]
            val maxAccleration: Float = accelerationValues[1]
            val minPower: Float = powerValues[0]
            val maxPower: Float = powerValues[1]
            val minRange: Float = rangeValues[0]
            val maxRange: Float = rangeValues[1]
            val minRating: Float = ratingValues[0]
            val maxRating: Float = ratingValues[1]

            val intent = Intent(this, CarActivity::class.java).apply{
                putExtra("MINPRICE", minPrice.toInt())
                putExtra("MAXPRICE", maxPrice.toInt())
                putExtra("MINACCELERATION", minAcceleration)
                putExtra("MAXACCELERATION", maxAccleration)
                putExtra("MINPOWER", minPower.toInt())
                putExtra("MAXPOWER", maxPower.toInt())
                putExtra("MINRANGE", minRange.toInt())
                putExtra("MAXRANGE", maxRange.toInt())
                putExtra("MINRATING", minRating.toInt())
                putExtra("MAXRATING", maxRating.toInt())
            }
            startActivity(intent)
        }

        val sldrPrice: RangeSlider = findViewById(R.id.sldrPrice)

        sldrPrice.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener {
            @SuppressLint("RestrictedApi")
            override fun onStartTrackingTouch(slider: RangeSlider) {
            }
            @SuppressLint("RestrictedApi")
            override fun onStopTrackingTouch(slider: RangeSlider) {
            }
        })
        sldrPrice.addOnChangeListener { slider, value, fromUser ->
            priceValues = sldrPrice.values
            txtPriceValues.text = "Gama: ${priceValues[0]}€ - ${priceValues[1]}€"
        }

        val sldrAcceleration: RangeSlider = findViewById(R.id.sldrAcceleration)

        sldrAcceleration.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener {
            @SuppressLint("RestrictedApi")
            override fun onStartTrackingTouch(slider: RangeSlider) {
            }
            @SuppressLint("RestrictedApi")
            override fun onStopTrackingTouch(slider: RangeSlider) {
            }
        })
        sldrAcceleration.addOnChangeListener { slider, value, fromUser ->
            accelerationValues = sldrAcceleration.values
            txtAccelerationValues.text = "Gama: ${accelerationValues[0]}seg - ${accelerationValues[1]}seg"
        }

        val sldrPower: RangeSlider = findViewById(R.id.sldrPower)

        sldrPower.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener {
            @SuppressLint("RestrictedApi")
            override fun onStartTrackingTouch(slider: RangeSlider) {
            }
            @SuppressLint("RestrictedApi")
            override fun onStopTrackingTouch(slider: RangeSlider) {
            }
        })
        sldrPower.addOnChangeListener { slider, value, fromUser ->
            powerValues = sldrPower.values
            txtPowerValues.text = "Gama: ${powerValues[0]}cv - ${powerValues[1]}cv"
        }

        val sldrRange: RangeSlider = findViewById(R.id.sldrRange)

        sldrRange.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener {
            @SuppressLint("RestrictedApi")
            override fun onStartTrackingTouch(slider: RangeSlider) {
            }
            @SuppressLint("RestrictedApi")
            override fun onStopTrackingTouch(slider: RangeSlider) {
            }
        })
        sldrRange.addOnChangeListener { slider, value, fromUser ->
            rangeValues = sldrRange.values
            txtRangeValues.text = "Gama: ${rangeValues[0]}km - ${rangeValues[1]}km"
        }

        val sldrRating: RangeSlider = findViewById(R.id.sldrRating)

        sldrRating.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener {
            @SuppressLint("RestrictedApi")
            override fun onStartTrackingTouch(slider: RangeSlider) {
            }
            @SuppressLint("RestrictedApi")
            override fun onStopTrackingTouch(slider: RangeSlider) {
            }
        })
        sldrRating.addOnChangeListener { slider, value, fromUser ->
            ratingValues = sldrRating.values
            txtRatingValues.text = "Gama: ${ratingValues[0]}estrelas - ${ratingValues[1]}estrelas"
        }
    }
}