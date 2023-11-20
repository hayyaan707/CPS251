package com.example.recycleview_project
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import androidx.core.content.ContextCompat
import android.content.Intent
class RecyclerAdapter(private val Titles: List<Int>, private val Details: List<Int>, private val Images: List<Int>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = Data.titles[Titles[i]]
        viewHolder.itemDetail.text = Data.details[Details[i]]
        viewHolder.itemImage.setImageResource(Data.images[Images[i]])
    }
    override fun getItemCount(): Int {
        return Data.titles.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                Snackbar.make(v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show() }
        }
    }
} class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var itemImage: ImageView
    private var itemTitle: TextView
    private var itemDetail: TextView
    init {
        itemImage = itemView.findViewById(R.id.itemImage)
        itemTitle = itemView.findViewById(R.id.itemTitle)
        itemDetail = itemView.findViewById(R.id.itemDetail)
        itemView.setOnClickListener { v: View ->
            val i = Intent(v.context,MainActivityTwo::class.java)
            i.putExtra("Title", Data.titles[adapterPosition])
            i.putExtra("Detail", Data.details[adapterPosition])
            i.putExtra("Image", Data.images[adapterPosition])
            ContextCompat.startActivity(v.context, i, null)
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                Snackbar.make(v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }
    }
}