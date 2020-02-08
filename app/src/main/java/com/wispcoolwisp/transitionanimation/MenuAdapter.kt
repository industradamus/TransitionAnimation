package com.wispcoolwisp.transitionanimation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.lsit_item.view.*


class MenuAdapter(private val listener: OnItemClickListener) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private var items = emptyList<MenuItem>()

    override fun onCreateViewHolder(container: ViewGroup, position: Int): MenuViewHolder {
        val inflater = LayoutInflater.from(container.context)
        val root: View = inflater.inflate(R.layout.lsit_item, container, false)
        return MenuViewHolder(root)
    }

    override fun onBindViewHolder(viewHolder: MenuViewHolder, position: Int) {
        viewHolder.bind(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    fun update(_items: List<MenuItem>) {
        items = _items
        notifyDataSetChanged()
    }

    class MenuViewHolder(itemView: View) : ViewHolder(itemView) {

        fun bind(item: MenuItem, listener: OnItemClickListener) {
            itemView.image.text = item.title
            itemView.image.setBackgroundColor(item.color)

            ViewCompat.setTransitionName(itemView.image, "${adapterPosition}_image")
            itemView.image.setOnClickListener {
                listener.onItemClicked(itemView.image, item)
            }
        }

    }
}