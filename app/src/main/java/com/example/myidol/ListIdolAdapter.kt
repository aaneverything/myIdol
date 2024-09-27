package com.example.myidol

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ListIdolAdapter(private val listIdol: ArrayList<Idol>) :
    RecyclerView.Adapter<ListIdolAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback


    // Menyiapkan activity
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    // Menyiapkan view holder
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    // Menyiapkan view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_idol, parent, false)
        return ListViewHolder(view)
    }


    // Mengisi data di dalam list
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listIdol[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        // Set OnClickListener untuk item view
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("EXTRA_NAME", name)
                putExtra("EXTRA_DESCRIPTION", description)
                putExtra("EXTRA_PHOTO", photo)
                putExtra("EXTRA_FULLNAME", listIdol[position].fullname)
                putExtra("EXTRA_BIODATA", listIdol[position].biodata)
            }
            context.startActivity(intent)
        }
    }



    override fun getItemCount(): Int = listIdol.size

    interface OnItemClickCallback {
        fun onItemClicked(data: Idol)
    }
}