package com.example.myidol

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        supportActionBar?.title = ""

        // Mendapatkan data dari Intent
        val name = intent.getStringExtra("EXTRA_NAME")
        val description = intent.getStringExtra("EXTRA_DESCRIPTION")
        val photo = intent.getIntExtra("EXTRA_PHOTO", 0)
        val fullname = intent.getStringExtra("EXTRA_FULLNAME") ?: "No fullname available"
        val biodata = intent.getStringExtra("EXTRA_BIODATA") ?: "No biodata available"

        // Memisahkan string biodata
        val biodataArray = biodata.split(",")

        // Mengatur data biodata ke TextView jika elemen cukup
        if (biodataArray.size >= 5) {
            val tvBiodataTTL: TextView = findViewById(R.id.tv_biodata_ttl)
            val tvBiodataPosisi: TextView = findViewById(R.id.tv_biodata_posisi)
            val tvBiodataTinggi: TextView = findViewById(R.id.tv_biodata_tinggi)
            val tvBiodataGolonganDarah: TextView = findViewById(R.id.tv_biodata_golongan_darah)
            val tvBiodataInstagram: TextView = findViewById(R.id.tv_biodata_instagram)

            // Set text hanya jika array memiliki elemen yang cukup
            tvBiodataTTL.text = biodataArray[1].trim()
            tvBiodataPosisi.text = biodataArray[2].trim()
            tvBiodataTinggi.text = biodataArray[3].trim()
            tvBiodataGolonganDarah.text = biodataArray[4].trim()
            tvBiodataInstagram.text = biodataArray[5].trim()
        } else {
            // Tambahkan logika untuk menampilkan error atau pengisian default
        }

        // Mengatur data lain ke tampilan
        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvFullname: TextView = findViewById(R.id.tv_item_fullname)
        val tvDescription: TextView = findViewById(R.id.tv_item_description)

        // Set data ke tampilan
        imgPhoto.setImageResource(photo)
        tvName.text = name
        tvFullname.text = fullname
        tvDescription.text = description
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
