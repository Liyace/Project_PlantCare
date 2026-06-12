package com.example.projectplantcare

import android.content.Intent
import android.widget.ImageView
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
        val view = inflater.inflate(R.layout.fragment_plant, container, false)

        val ivNotif = view.findViewById<ImageView>(R.id.ivNotif)
        ivNotif.setOnClickListener {
            val intent = Intent(activity, NotificationActivity::class.java)
            startActivity(intent)
        }

        val rmTanaman = view.findViewById<RecyclerView>(R.id.rvTanaman)
        rmTanaman.layoutManager = LinearLayoutManager(context)

        val dataTanaman = listOf(
            Tanaman("Monstera Adansonii", "Tanaman Hias Daun", "Tanaman populer dengan daun berlubang yang unik dan indah.", R.drawable.monstera_adansonii),
            Tanaman("Aglaonema Red", "Tanaman Hias Daun", "Memiliki warna merah yang cantik dan mudah dirawat.",R.drawable.aglaonema_red),
            Tanaman("Aggrek Bulan", "Tanaman Hias Bunga", "Tanaman berbunga elegan yang banyak digemari oleh pecinta tanaman hias.", R.drawable.aggrek_bulan),
            Tanaman("Kaktus Mini", "Tanaman Hias Sukulen", "Tahan panas dan tidak membutuhkan banyak air untuk tumbuh", R.drawable.kaktus_mini),
            Tanaman("Lidah Mertua", "Tanaman Hias Indoor", "Membantu menyaring udara dalam ruangan dan mengurangi paparan debu.",R.drawable.lidah_mertua)
        )
        val adapter = TanamanAdapter(dataTanaman)
        rmTanaman.adapter = adapter
        return view
    }

}