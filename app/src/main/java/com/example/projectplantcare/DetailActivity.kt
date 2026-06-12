package com.example.projectplantcare

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.hide()

        val imgDetailTanaman: ImageView = findViewById(R.id.imgDetailTanaman)
        val tvDetailNama: TextView = findViewById(R.id.tvDetailNama)
        val tvDetailJenis: TextView = findViewById(R.id.tvDetailJenis)
        val btnBackDetail: ImageButton = findViewById(R.id.btnBackDetail)

        val namaTanaman = intent.getStringExtra("NAMA_TANAMAN")
        val jenisTanaman = intent.getStringExtra("JENIS_TANAMAN")
        val gambarTanaman = intent.getIntExtra("GAMBAR_TANAMAN", R.mipmap.ic_launcher)

        tvDetailNama.text = namaTanaman
        tvDetailJenis.text = jenisTanaman
        imgDetailTanaman.setImageResource(gambarTanaman)

        btnBackDetail.setOnClickListener {
            finish()
        }
    }
}