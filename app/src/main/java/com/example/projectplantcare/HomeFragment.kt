package com.example.projectplantcare

import android.os.Bundle
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val tvSapaan = view.findViewById<TextView>(R.id.tvSapaan)
        val ivNotif = view.findViewById<ImageView>(R.id.ivNotif)
        ivNotif.setOnClickListener {
            val intent = Intent(activity, NotificationActivity::class.java)
            startActivity(intent)
        }

        val sharedPref = activity?.getSharedPreferences("UserSession", AppCompatActivity.MODE_PRIVATE)
        val username = sharedPref?.getString("USERNAME", "Pengguna")
        tvSapaan.text = "Selamat datang, $username!👋"


        val rvPopulerHome = view.findViewById<RecyclerView>(R.id.rvPopulerHome)
        rvPopulerHome.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val dataPopuler = listOf(
            Tanaman("Monstera Adansonii", "Tanaman Hias Daun", "Tanaman populer dengan daun berlubang yang unik dan indah.", R.drawable.monstera_adansonii),
            Tanaman("Aglaonema Red", "Tanaman Hias Daun", "Memiliki warna merah yang cantik dan mudah dirawat.",R.drawable.aglaonema_red),
            Tanaman("Aggrek Bulan", "Tanaman Hias Bunga", "Tanaman berbunga elegan yang banyak digemari oleh pecinta tanaman hias.", R.drawable.aggrek_bulan),
            Tanaman("Kaktus Mini", "Tanaman Hias Sukulen", "Tahan panas dan tidak membutuhkan banyak air untuk tumbuh", R.drawable.kaktus_mini),
            Tanaman("Lidah Mertua", "Tanaman Hias Indoor", "Membantu menyaring udara dalam ruangan dan mengurangi paparan debu.",R.drawable.lidah_mertua)
        )
        rvPopulerHome.adapter = TanamanAdapter(dataPopuler)

        val tvLihatSemua = view.findViewById<TextView>(R.id.tvLihatSemua)
        tvLihatSemua.setOnClickListener {
            val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.bottomNav)
            bottomNav?.selectedItemId = R.id.menu_plant
        }
        return view
        }
}
