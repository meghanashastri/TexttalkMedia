package com.example.texttalkmedia.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.texttalkmedia.data.model.Article
import com.example.texttalkmedia.databinding.ItemNewsBinding

class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = differ.currentList[position]
        if (news != null) {
            holder.bind(news)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class NewsViewHolder(
        val binding: ItemNewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Article) {
            binding.title.text = data.title

            binding.root.setOnClickListener {
                onItemClickListener?.let {
                    it(data)
                }
            }
        }
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }
}