package com.example.projectplantcare

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PlantFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val rmTanaman = view.findViewById<RecyclerView>(R.id.rvTanaman)
        rmTanaman.layoutManager = LinearLayoutManager(context)

        val dataTanaman = listOf(
            Tanaman("Monstera Adansonii", "Tanaman Hias Daun", R.mipmap.ic_launcher),
            Tanaman("Aglaonema Red", "Tanaman Hias Daun", R.mipmap.ic_launcher),
            Tanaman("Aggrek Bulan", "Tanaman Hias Bunga", R.mipmap.ic_launcher),
            Tanaman("Kaktus Mini", "Tanaman Hias Sukulen", R.mipmap.ic_launcher),
            Tanaman("Lidah Mertua", "Tanaman Hias Indoor", R.mipmap.ic_launcher)
        )
        val adapter = TanamanAdapter(dataTanaman)
        rmTanaman.adapter = adapter
        return view
    }

}