package jtodi.andev.a7minuteworkout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import jtodi.andev.a7minuteworkout.databinding.ItemExerciseStatusBinding

class ExerciseStatusAdapter(val items : ArrayList<ExerciseModel>): RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>(){

    inner class ViewHolder(val itemBinding : ItemExerciseStatusBinding) : RecyclerView.ViewHolder(itemBinding.root){
//        fun binditem(item : ExerciseModel){
//            itemBinding.tvItem.text = item.getId().toString()
//            itemBinding.tvItem.background = R.drawable.item_selected_circular_exercise_status
//        }
        val tvItem = itemBinding.tvItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemExerciseStatusBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvItem.text = items[position].getId().toString()

        when{
            items[position].getIsSelected() ->{
                holder.tvItem.background = ContextCompat.getDrawable(holder.itemView.context,R.drawable.item_circular_thin_color_accent_border)
            }

            items[position].getIsCompleted()->{
                holder.tvItem.background = ContextCompat.getDrawable(holder.itemView.context,R.drawable.item_circular_color_completed_background)
            }

            else ->{
                holder.tvItem.background = ContextCompat.getDrawable(holder.itemView.context,R.drawable.item_circular_color_gray_background)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}