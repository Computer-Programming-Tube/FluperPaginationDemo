package com.infoskillstechnology.fluperpaginationdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.infoskillstechnology.fluperpaginationdemo.model.CALLBACK
import com.infoskillstechnology.fluperpaginationdemo.model.Result
import kotlinx.android.synthetic.main.row_item.view.*

class NotificationAdapter(context: Context) :
    PagedListAdapter<Result,NotificationAdapter.NotificationViewHolder>(CALLBACK) {


    class NotificationViewHolder(view: View):RecyclerView.ViewHolder(view) {

        fun bind(notification:Result?){
            itemView.title.text = notification!!.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return NotificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
