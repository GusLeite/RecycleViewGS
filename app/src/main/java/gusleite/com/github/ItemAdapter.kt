package gusleite.com.github

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import gusleite.com.github.databinding.ItemLayoutBinding

class ItemAdapter(private val itemList: List<ItemModel>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.binding.textViewTitle.text = currentItem.praia
        holder.binding.textViewDescription.text = "${currentItem.cidade}, ${currentItem.estado}"
        holder.binding.imageButtonOptions.setOnClickListener {
            currentItem.onRemove(currentItem)
        }
    }

    override fun getItemCount() = itemList.size

    class ItemViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}