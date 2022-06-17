package com.example.carroseletricos.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.carroseletricos.CarActivity
import com.example.carroseletricos.R

class MakeAdapter(val context: Context):
    RecyclerView.Adapter<MakeAdapter.ItemViewHolder>() {

    val makes = context.resources.getStringArray(R.array.makes).toList()

    class ItemViewHolder (val view: View) :
        RecyclerView.ViewHolder(view){
        val button = view.findViewById<Button>(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterlayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.button_view, parent, false)
        return ItemViewHolder(adapterlayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = makes[position]
        val context = holder.view.context //will be used by setOnClickListener
        holder.button.text = item.toString()

        holder.button.setOnClickListener {
            val intent = Intent(context, CarActivity::class.java)
            intent.putExtra(CarActivity.MAKE, holder.button.text)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = makes.size

}