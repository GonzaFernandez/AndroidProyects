package com.example.exampletwo.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exampletwo.Adapters.ProductRecycleAdapter
import com.example.exampletwo.Model.Product
import com.example.exampletwo.R
import com.example.exampletwo.Services.DataService
import com.example.exampletwo.Utilities.EXTRA_CATEGORY
import com.example.exampletwo.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {

    lateinit var adapter : ProductRecycleAdapter
    var product = Product("","","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)


        adapter = ProductRecycleAdapter(this,DataService.getProducts(categoryType)){product ->
            val productDetailIntent = Intent(this, ProductDetailActivity::class.java)
            productDetailIntent.putExtra(EXTRA_PRODUCT,product)
            productDetailIntent.putExtra(EXTRA_CATEGORY, categoryType)
            startActivity(productDetailIntent)

        }

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        horizontalView.adapter = adapter
        horizontalView.layoutManager = layoutManager

        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        val image = resources.getIdentifier(product.image, "drawable", packageName)
        productDetailImage.setImageResource(image)
        productDetailName.text = product.title
        productDetailPrice.text = product.price





    }
}