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
    var priceValues: List<Float> = listOf(0.0f, 120000.0f)
    var accelerationValues: List<Float> = listOf(0.0f, 20.0f)
    var powerValues: List<Float> = listOf(0.0f, 700.0f)
    var rangeValues: List<Float> = listOf(0.0f, 700.0f)
    var ratingValues: List<Float> = listOf(1.0f, 5.0f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        val txtPriceValues: TextView = findViewById(R.id.txtPriceValues);
        val txtAccelerationValues: TextView = findViewById(R.id.txtAccelerationValues);
        val txtPowerValues: TextView = findViewById(R.id.txtPowerValues);
        val txtRangeValues: TextView = findViewById(R.id.txtRangeValues);
        val txtRatingValues: TextView = findViewById(R.id.txtRatingValues);

        val minPriceStart: Int = priceValues[0].toInt()
        val maxPriceStart: Int = priceValues[1].toInt()
        val minAccelerationStart: Float = accelerationValues[0]
        val maxAcclerationStart: Float = accelerationValues[1]
        val minPowerStart: Int = powerValues[0].toInt()
        val maxPowerStart: Int = powerValues[1].toInt()
        val minRangeStart: Int = rangeValues[0].toInt()
        val maxRangeStart: Int = rangeValues[1].toInt()
        val minRatingStart: Int = ratingValues[0].toInt()
        val maxRatingStart: Int = ratingValues[1].toInt()


        val btnFindCar: Button = findViewById(R.id.btnFindCar)
        btnFindCar.setOnClickListener {

            val intent = Intent(this, CarActivity::class.java).apply{

                val minPrice: Int = priceValues[0].toInt()
                val maxPrice: Int = priceValues[1].toInt()
                val minAcceleration: Float = accelerationValues[0]
                val maxAccleration: Float = accelerationValues[1]
                val minPower: Int = powerValues[0].toInt()
                val maxPower: Int = powerValues[1].toInt()
                val minRange: Int = rangeValues[0].toInt()
                val maxRange: Int = rangeValues[1].toInt()
                val minRating: Int = ratingValues[0].toInt()
                val maxRating: Int = ratingValues[1].toInt()

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
        txtPriceValues.text = "${minPriceStart} - ${maxPriceStart}"

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
            txtPriceValues.text = "${priceValues[0].toInt()} - ${priceValues[1].toInt()}"
        }

        val sldrAcceleration: RangeSlider = findViewById(R.id.sldrAcceleration)
        txtAccelerationValues.text = "${minAccelerationStart} - ${maxAcclerationStart}"

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
            txtAccelerationValues.text = "${accelerationValues[0]} - ${accelerationValues[1]}"
        }

        val sldrPower: RangeSlider = findViewById(R.id.sldrPower)
        txtPowerValues.text = "${minPowerStart} - ${maxPowerStart}"

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
            txtPowerValues.text = "${powerValues[0].toInt()} - ${powerValues[1].toInt()}"
        }

        val sldrRange: RangeSlider = findViewById(R.id.sldrRange)
        txtRangeValues.text = "${minRangeStart} - ${maxRangeStart}"

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
            txtRangeValues.text = "${rangeValues[0].toInt()} - ${rangeValues[1].toInt()}"
        }

        val sldrRating: RangeSlider = findViewById(R.id.sldrRating)
        txtRatingValues.text = "${minRatingStart} - ${maxRatingStart}"

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
            txtRatingValues.text = "${ratingValues[0].toInt()} - ${ratingValues[1].toInt()}"
        }
    }
}