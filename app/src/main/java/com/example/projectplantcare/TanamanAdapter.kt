package com.example.projectplantcare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class TanamanAdapter (private val listTanaman: List<Tanaman>) :
    RecyclerView.Adapter<TanamanAdapter.TanamanViewHolder>() {

    class TanamanViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgTanaman: ImageView = view.findViewById(R.id.imgTanaman)
        val tvNamaTanaman: TextView = view.findViewById(R.id.tvNamaTanaman)
        val tvJenisTanaman: TextView = view.findViewById(R.id.tvJenisTanaman)
        val tvLihatDetail: TextView = view.findViewById(R.id.tvLihatDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TanamanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tanaman, parent, false)
        return TanamanViewHolder(view)
    }
    override fun onBindViewHolder(holder: TanamanViewHolder, position: Int) {
        val tanaman = listTanaman[position]
        holder.tvNamaTanaman.text = tanaman.nama
        holder.tvJenisTanaman.text = tanaman.jenis
        holder.imgTanaman.setImageResource(tanaman.gambar)

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Membuka detail ${tanaman.nama}", Toast.LENGTH_SHORT).show()
        }
    }
    override fun getItemCount(): Int = listTanaman.size
}