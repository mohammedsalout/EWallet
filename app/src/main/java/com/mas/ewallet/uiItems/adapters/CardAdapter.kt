package com.mas.ewallet.uiItems.adapters
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mas.ewallet.data.moduel.UserCards
import com.mas.ewallet.databinding.CardItemsBinding
import com.mas.ewallet.ui.items.ItemsActivity


class CardAdapter constructor(private var context: Context) :
    RecyclerView.Adapter<CardAdapter.MyViewHolder>() {
    private val data: ArrayList<UserCards> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: CardItemsBinding =
            CardItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(data[position])

        data[position].let {
            holder.binding.cvCard.setOnClickListener {
                context.startActivity(Intent(context, ItemsActivity::class.java)
                    .putExtra("cardId" , data[position].id))
            }
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun updateAdapter(list: List<UserCards>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(var binding: CardItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(userCards: UserCards) {
            binding.tvTitle.text = userCards.title
            binding.tvLastUpdate.text = userCards.update.toString()
            binding.tvTotal.text = userCards.total.toString()
        }

    }
}