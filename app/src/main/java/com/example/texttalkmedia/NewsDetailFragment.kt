package com.example.texttalkmedia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.texttalkmedia.data.model.Article
import com.example.texttalkmedia.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : Fragment() {

    private lateinit var fragmentNewsDetailBinding: FragmentNewsDetailBinding
    private lateinit var news: Article

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_news_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentNewsDetailBinding = FragmentNewsDetailBinding.bind(view)
        val args: NewsDetailFragmentArgs by navArgs()
        news = args.selectedNewsItem
        setData(news)
    }

    private fun setData(news: Article) {
        fragmentNewsDetailBinding.apply {
            tvTitle.text = news.title
            tvDescription.text = news.description
            tvPublisherSiteUrl.setOnClickListener {
                news.url?.let { it1 -> openUrl(it1) }
            }
            Glide.with(ivNewsPic.context)
                .load(news.urlToImage)
                .into(ivNewsPic)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
        val item: MenuItem = menu.findItem(R.id.share)
        item.isVisible = (activity as MainActivity).showMenu
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.share -> {
            share()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun share() {
        try {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(Intent.EXTRA_TEXT, news.url)
            shareIntent.type = "text/plain"
            startActivity(Intent.createChooser(shareIntent, getString(R.string.share)))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun openUrl(url: String) {
        try {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse(url)
            startActivity(openURL)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}