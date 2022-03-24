package com.example.texttalkmedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.texttalkmedia.data.model.Article
import com.example.texttalkmedia.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : Fragment() {

    private lateinit var fragmentNewsDetailBinding: FragmentNewsDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentNewsDetailBinding = FragmentNewsDetailBinding.bind(view)
        val args: NewsDetailFragmentArgs by navArgs()
        val news = args.selectedNewsItem
        setData(news)
    }

    private fun setData(news: Article) {
        fragmentNewsDetailBinding.apply {
            tvTitle.text = news.title
            tvDescription.text = news.description
            tvPublisherSiteUrl.text = news.url
            Glide.with(ivNewsPic.context)
                .load(news.urlToImage)
                .into(ivNewsPic)
        }
    }
}