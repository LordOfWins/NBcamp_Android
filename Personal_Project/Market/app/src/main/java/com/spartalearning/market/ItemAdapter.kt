package com.spartalearning.market

import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.spartalearning.market.databinding.ItemBinding
import com.spartalearning.market.model.SaleItem

class ItemAdapter(private val dataList: MutableList<SaleItem>) :
    RecyclerView.Adapter<ItemAdapter.Holder>() {
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
    
    interface ItemLongClick {
        fun onLongClick(view: View, position: Int)
    }
    
    lateinit var itemClick: ItemClick
    lateinit var itemLongClick: ItemLongClick
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }
    
    
    /* detailActivity에 값 넣기 */
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick.onClick(it, position)
        }
        holder.itemView.setOnLongClickListener OnLongClickListener@{
            itemLongClick.onLongClick(it, position)
            true
        }
        holder.itemImage.setImageResource(dataList[position].image)
        holder.itemTitle.text = dataList[position].title
        holder.itemAddress.text = dataList[position].address
        
        val price = dataList[position].price
        // 천의 자리에 콤마 찍고 원을 붙이기 예:1,000원
        val formattedPrice = DecimalFormat("#,###").format(price)
        holder.price.text =
            holder.itemView.context.getString(R.string.formatted_price, formattedPrice)
        holder.chat.text = dataList[position].chatCnt.toString()
        holder.favorite.text = dataList[position].favorite.toString()
        if (dataList[position].isLike) {
            holder.like.setImageResource(R.drawable.ic_favorite)
        } else {
            holder.like.setImageResource(R.drawable.ic_favorite_border)
        }
        
    }
    
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    
    override fun getItemCount(): Int {
        return dataList.size
    }
    
    inner class Holder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val itemImage = binding.iconItem
        val itemTitle = binding.itemTitle
        val itemAddress = binding.address
        val price = binding.price
        val chat = binding.commentCount
        val favorite = binding.favoriteCount
        val like = binding.favoriteButton
        
    }
}
