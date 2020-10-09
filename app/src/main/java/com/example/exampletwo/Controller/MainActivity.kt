package com.example.exampletwo.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exampletwo.Adapters.CategoryRecycleAdapter
import com.example.exampletwo.R
import com.example.exampletwo.Services.DataService
import com.example.exampletwo.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories) {category ->
            val productIntent = Intent(this,ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY,category.name)
            println("CATEGORY ${category.name}")
            startActivity(productIntent)

        }

        productListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        productListView.layoutManager = layoutManager
        productListView.setHasFixedSize(true)



    }
}