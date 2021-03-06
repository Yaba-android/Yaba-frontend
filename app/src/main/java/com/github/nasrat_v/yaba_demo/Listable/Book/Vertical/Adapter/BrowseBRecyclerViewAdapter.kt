package com.github.nasrat_v.yaba_demo.Listable.Book.Vertical.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.github.nasrat_v.yaba_demo.ICallback.IBookClickCallback
import com.github.nasrat_v.yaba_demo.ICallback.IDeleteBrowseBookClickCallback
import com.github.nasrat_v.yaba_demo.Listable.Book.Horizontal.Model.BModel
import com.github.nasrat_v.yaba_demo.R

class BrowseBRecyclerViewAdapter(
    private var context: Context, private var list: ArrayList<BModel>,
    private var mBookClickCallback: IBookClickCallback,
    private var mDeleteBrowseBookClickCallback: IDeleteBrowseBookClickCallback
) : androidx.recyclerview.widget.RecyclerView.Adapter<BrowseBRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(container: ViewGroup, p1: Int): ViewHolder {
        val rootView = LayoutInflater.from(container.context).inflate(
            R.layout.vertical_recyclerview_browse_book, container, false
        )
        return ViewHolder(
            rootView
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]

        holder.mTitle.text = model.title
        holder.mAuthor.text = model.author.name
        holder.mImage.setImageResource(model.image)
        holder.mRating.rating = model.rating
        holder.mNumberRating.text = ("(" + model.numberRating + ")")
        holder.mPrice.text = ("$" + model.price)
        holder.mImage.setOnClickListener {
            // envoyer le bon livre grace à position
            mBookClickCallback.bookEventButtonClicked(model)
        }
        holder.mButtonDelete.setOnClickListener {
            mDeleteBrowseBookClickCallback.bookEraseEventButtonClicked(model, holder.adapterPosition)
        }

    }

    class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        var mTitle = itemView.findViewById<TextView>(R.id.title_vertical_browse_book)!!
        var mAuthor = itemView.findViewById<TextView>(R.id.author_vertical_browse_book)!!
        var mImage = itemView.findViewById<ImageView>(R.id.vertical_image)!!
        var mRating = itemView.findViewById<RatingBar>(R.id.rating_bar_vertical_browse_book)!!
        var mNumberRating = itemView.findViewById<TextView>(R.id.number_rating_vertical_browse_book)!!
        var mPrice = itemView.findViewById<TextView>(R.id.price_vertical_browse_book)!!
        var mButtonDelete = itemView.findViewById<Button>(R.id.button_erase_browse_book)!!
    }
}
