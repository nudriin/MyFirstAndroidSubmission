package com.nudriin.mysubmission

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nudriin.mysubmission.databinding.CardTechBinding

class ListTechAdapter(private val techList: ArrayList<Tech>) : RecyclerView.Adapter<ListTechAdapter.ListViewHolder>() {

    interface OnItemClickCallback {
        fun onItemClicked(data: Tech)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(var binding: CardTechBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = CardTechBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = techList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, description, icon) = techList[position]
        Glide.with(holder.itemView.context).load(icon).into(holder.binding.IVIcon)
        holder.binding.TVTitle.text = title
        holder.binding.TVDescription.text = description
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(techList[holder.adapterPosition])
        }
    }


}