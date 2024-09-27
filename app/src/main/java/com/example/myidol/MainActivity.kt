package com.example.myidol

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // Menyiapkan activity
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Idol>()
    private lateinit var allBiodata: List<Array<String>>

    // Menyiapkan activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // menginisialisasi rvheroes dan menambahkan data ke list
        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)
        list.addAll(getListHeroes())
        showRecyclerList()

    }

    // Mengisi data di dalam list
    private fun getListHeroes(): ArrayList<Idol> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val fullname = resources.getStringArray(R.array.data_fullname)
        val biodata = resources.getStringArray(R.array.biodata_all)
        val listHero = ArrayList<Idol>()
        for (i in dataName.indices) {
            val hero = Idol(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), fullname[i], biodata[i])
            listHero.add(hero)
        }
        dataPhoto.recycle()
        return listHero
    }

    // Menampilkan data di dalam list
    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listIdolAdapter = ListIdolAdapter(list)
        rvHeroes.adapter = listIdolAdapter

        listIdolAdapter.setOnItemClickCallback(object : ListIdolAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Idol) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("EXTRA_NAME", data.name)
                intent.putExtra("EXTRA_DESCRIPTION", data.description)
                intent.putExtra("EXTRA_PHOTO", data.photo)
                intent.putExtra("EXTRA_FULLNAME", data.fullname)
                intent.putExtra("EXTRA_BIODATA", data.biodata)
                startActivity(intent)
            }
        })
    }


    // Menampilkan menu dan mengatur tindakan saat menu dipilih
    private fun showSelectedIdol(idol: Idol) {
        Toast.makeText(this, "Kamu memilih ohooh" + idol.name, Toast.LENGTH_SHORT).show()
    }

    // Menampilkan menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }


    // Mengatur tindakan saat menu dipilih
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, About::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }




}