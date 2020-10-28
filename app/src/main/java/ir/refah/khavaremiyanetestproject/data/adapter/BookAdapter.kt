package ir.refah.khavaremiyanetestproject.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

import ir.refah.khavaremiyanetestproject.R
import ir.refah.khavaremiyanetestproject.databinding.ItemBookBinding
import ir.refah.khavaremiyanetestproject.model.Book
import ir.refah.khavaremiyanetestproject.model.TestBook

class BookAdapter(var mList: List<Book>?, private val mListener: (Book) -> Unit) :
    RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    fun setData(list: List<Book>?) {
        mList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemBookBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_book,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        if (mList != null) return mList!!.size
        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBinding.book = mList!!.get(position)
        holder.itemView.setOnClickListener {
            mList!!.get(position)?.let { it1 -> mListener.invoke(it1) }
        }
    }

    class ViewHolder(var itemBinding: ItemBookBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
    }
}