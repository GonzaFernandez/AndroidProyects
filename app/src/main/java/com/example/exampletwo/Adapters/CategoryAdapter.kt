package com.example.exampletwo.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.exampletwo.Model.Category
import com.example.exampletwo.R

class CategoryAdapter(context : Context, categories : List<Category>) : BaseAdapter() {

    val cont = context
    val cat = categories

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val holder : ViewHolder
        val categoryView : View

        if(convertView == null){
            categoryView = LayoutInflater.from(cont).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)

            categoryView.tag = holder
        } else{
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }

        val category = cat[position]

        val resourcesId = cont.resources.getIdentifier(category.image, "drawable", cont.packageName)
        holder.categoryImage?.setImageResource(resourcesId)
        holder.categoryName?.setText(category.name)
        return categoryView

    }

    override fun getItem(position: Int): Any {
        return cat[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return cat.count()
    }

    private class ViewHolder{
        var categoryImage : ImageView? = null
        var categoryName : TextView? = null
    }
}