package jtodi.andev.a7minuteworkout

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import jtodi.andev.a7minuteworkout.databinding.ItemHistoryRowBinding

class HistoryAdapter(val datesList : ArrayList<String>) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    class ViewHolder(itemBinding : ItemHistoryRowBinding) : RecyclerView.ViewHolder(itemBinding.root){
        val tv_item = itemBinding.tvItem
        val tvPosition = itemBinding.tvPosition
        val llHistoryMain = itemBinding.llHistoryItemMain
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHistoryRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_item.text = datesList[position]
        holder.tvPosition.text = (position+1).toString()
        if(position % 2 == 0){
            holder.llHistoryMain.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,R.color.gray))
        }else{
            holder.llHistoryMain.setBackgroundColor(Color.parseColor("#FF6CB5EF"))
        }
    }

    override fun getItemCount(): Int {
        return datesList.size
    }
}