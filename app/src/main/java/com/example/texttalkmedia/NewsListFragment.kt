package com.example.texttalkmedia

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.texttalkmedia.data.utils.Resource
import com.example.texttalkmedia.databinding.FragmentNewsListBinding
import com.example.texttalkmedia.presentation.adapter.NewsListAdapter
import com.example.texttalkmedia.presentation.viewmodel.NewsViewModel

class NewsListFragment : Fragment() {

    private lateinit var viewModel: NewsViewModel
    private lateinit var fragmentNewsListBinding: FragmentNewsListBinding
    private lateinit var newsListAdapter: NewsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentNewsListBinding = FragmentNewsListBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel
        newsListAdapter = (activity as MainActivity).newsListAdapter
        navigateToDetailsFragment()
        initRecyclerView()
        viewNewsList()
    }

    private fun navigateToDetailsFragment() {
        newsListAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("selected_news_item", it)
            }
            findNavController().navigate(
                R.id.action_newsListFragment_to_newsDetailFragment,
                bundle
            )
        }
    }

    private fun initRecyclerView() {
        fragmentNewsListBinding.apply {
            recyclerViewNewsList.adapter = newsListAdapter
            recyclerViewNewsList.layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun viewNewsList() {
        viewModel.news.observe(viewLifecycleOwner) { result ->
            newsListAdapter.differ.submitList(result?.data)

            fragmentNewsListBinding.apply {
                progressBar.isVisible =
                    result is Resource.Loading && result.data.isNullOrEmpty()

                tvError.isVisible =
                    result is Resource.Error && result.data.isNullOrEmpty()
                tvError.text = result?.message
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
        val item: MenuItem = menu.findItem(R.id.share)
        item.isVisible = (activity as MainActivity).showMenu
    }
}