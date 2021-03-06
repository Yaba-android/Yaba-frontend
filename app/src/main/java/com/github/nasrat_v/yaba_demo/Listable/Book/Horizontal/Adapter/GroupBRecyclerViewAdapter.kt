package com.github.nasrat_v.yaba_demo.Listable.Book.Horizontal.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.github.nasrat_v.yaba_demo.ICallback.IBookClickCallback
import com.github.nasrat_v.yaba_demo.Listable.Book.Horizontal.Model.BModel
import com.github.nasrat_v.yaba_demo.Listable.Book.Vertical.ListModel.DownloadListBModel
import com.github.nasrat_v.yaba_demo.R

class GroupBRecyclerViewAdapter(
    private var downloadedBooks: ArrayList<DownloadListBModel>,
    private var list: ArrayList<BModel>
) : androidx.recyclerview.widget.RecyclerView.Adapter<GroupBRecyclerViewAdapter.ViewHolder>() {

    private lateinit var mBookClickCallback: IBookClickCallback

    override fun onCreateViewHolder(container: ViewGroup, p1: Int): ViewHolder {
        val rootView = LayoutInflater.from(container.context).inflate(
            R.layout.horizontal_recyclerview_big_library_book, container, false
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

        if (isBookAlreadyDownloaded(model))
            holder.mImageDownload.visibility = View.INVISIBLE
        holder.mImage.setImageResource(model.image)
        holder.itemView.setOnClickListener {
            mBookClickCallback.bookEventButtonClicked(list[position])
        }
    }

    fun setTabFragmentClickCallback(bookClickCallback: IBookClickCallback) {
        mBookClickCallback = bookClickCallback
    }

    private fun isBookAlreadyDownloaded(book: BModel): Boolean {
        downloadedBooks.forEach {
            if (it.bookModels.find { dlBook -> dlBook.book == book } != null)
                return true
        }
        return false
    }

    class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        var mImage = itemView.findViewById<ImageView>(R.id.horizontal_image)!!
        var mImageDownload = itemView.findViewById<ImageView>(R.id.download_book_library_image)!!
    }
}
