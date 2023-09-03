package com.spartalearning.market.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class SaleItem(
    val image: Int,
    val title: String,
    val itemDetail: String,
    val sellerName: String,
    val price: Int,
    val address: String,
    var favorite: Int, val chatCnt: Int,
    var isLike: Boolean
) : Parcelable
