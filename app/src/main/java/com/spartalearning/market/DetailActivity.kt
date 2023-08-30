package com.spartalearning.market

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.snackbar.Snackbar
import com.spartalearning.market.databinding.ActivityDetailBinding
import com.spartalearning.market.model.SaleItem
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var isLike = false
    
    private val item: SaleItem? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.ITEM_OBJECT, SaleItem::class.java)
        } else {
            intent.getParcelableExtra<SaleItem>(Constants.ITEM_OBJECT)
        }
    }
    
    private val itemPostion: Int by lazy {
        intent.getIntExtra(Constants.ITEM_INDEX, 0)
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.itemImage.setImageDrawable(item?.let {
            ResourcesCompat.getDrawable(resources, it.image, null)
        })
        
        binding.sellerName.text = item?.sellerName
        binding.sellerAddress.text = item?.address
        binding.itemName.text = item?.title
        binding.itemDetail.text = item?.itemDetail
        // 천의 자리에 콤마 찍고 원을 붙이기 예:1,000원
        val formattedPrice = DecimalFormat("#,###").format(item?.price)
        binding.price.text = getString(R.string.formatted_price, formattedPrice)
        
        isLike = item?.isLike == true
        binding.favorite.setImageResource(if (isLike) R.drawable.ic_favorite else R.drawable.ic_favorite_border)
        binding.back.setOnClickListener {
            exit()
        }
        binding.favorite.setOnClickListener {
            if (isLike) {
                binding.favorite.setImageResource(R.drawable.ic_favorite_border)
                Snackbar.make(binding.root, "관심목록에서 삭제되었습니다.", Snackbar.LENGTH_SHORT).show()
                isLike = false
            } else {
                binding.favorite.setImageResource(R.drawable.ic_favorite)
                Snackbar.make(binding.root, "관심목록에 추가되었습니다.", Snackbar.LENGTH_SHORT).show()
                isLike = true
            }
        }
    }
    
    fun exit() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(Constants.ITEM_INDEX, itemPostion)
            putExtra("isLike", isLike)
        }
        setResult(RESULT_OK, intent)
        if (!isFinishing) finish()
    }
    
    override fun onBackPressed() {
        exit()
    }
}