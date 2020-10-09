package com.example.exampletwo.Services

import com.example.exampletwo.Model.Category
import com.example.exampletwo.Model.Product

object DataService {
    val categories = listOf(
        Category("SHIRTS","shirtimage"),
        Category("HOODIES","hoodieimage"),
        Category("HATS","hatimage"),
        Category("DIGITAL","digitalgoodsimage")
    )

    val hats = listOf(
        Product("Devslopes Graphic Beanie","$10","hat1"),
        Product("Devslopes Hat Black","$20","hat2"),
        Product("Devslopes Hat White","$18","hat3"),
        Product("Devslopes Hat Snapback","$22","hat4"),
        Product("Devslopes Graphic Beanie","$10","hat1"),
        Product("Devslopes Hat Black","$20","hat2"),
        Product("Devslopes Hat White","$18","hat3"),
        Product("Devslopes Hat Snapback","$22","hat4")
    )

    val hoodies = listOf(
        Product("Devslopes Hoddie Gray", "$22","hoodie1"),
        Product("Devslopes Hoddie Red", "$30","hoodie2"),
        Product("Devslopes Gray Hoodie", "$22","hoodie3"),
        Product("Devslopes Black Hoodie", "$22","hoodie4"),
        Product("Devslopes Hoddie Gray", "$22","hoodie1"),
        Product("Devslopes Hoddie Red", "$30","hoodie2"),
        Product("Devslopes Gray Hoodie", "$22","hoodie3"),
        Product("Devslopes Black Hoodie", "$22","hoodie4")
    )

    val shirts = listOf(
        Product("Devslopes Shirt Black", "$18","shirt1"),
        Product("Devslopes Budge Ligh", "$30","shirt2"),
        Product("Devslopes Logo Shirt Red", "$22","shirt3"),
        Product("Devslopes Hustle", "$22","shirt4"),
        Product("KickFlip Studios", "$18","shirt5"),
        Product("Devslopes Shirt Black", "$18","shirt1"),
        Product("Devslopes Budge Ligh", "$30","shirt2"),
        Product("Devslopes Logo Shirt Red", "$22","shirt3"),
        Product("Devslopes Hustle", "$22","shirt4"),
        Product("KickFlip Studios", "$18","shirt5")
    )

    val digitalGoods = listOf<Product>()

    fun getProducts(category : String) : List<Product>{
        return when(category) {
            "SHIRTS" -> shirts
            "HATS" -> hats
            "HOODIES" -> hoodies
            else -> digitalGoods
        }
    }
}