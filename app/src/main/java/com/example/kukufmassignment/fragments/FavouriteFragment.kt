package com.example.kukufmassignment.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kukufmassignment.R
import com.example.kukufmassignment.adapters.SpaceXAdapter
import com.example.kukufmassignment.base.BaseFragment
import com.example.kukufmassignment.databinding.FragmentFavouriteBinding
import com.example.kukufmassignment.viewmodel.FavouriteViewModel
import com.example.kukufmassignment.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class FavouriteFragment : BaseFragment<FragmentFavouriteBinding, FavouriteViewModel>(R.layout.fragment_favourite) {

    override val viewModel: FavouriteViewModel by viewModels()

    @Inject
    lateinit var spaceXAdapter: SpaceXAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        fetchFavouriteLaunches()
        observeFavouriteLaunches()
    }

    private fun setUpRecyclerView() {
        binding.rvFav.apply {
            layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL, false)
            adapter = spaceXAdapter
            spaceXAdapter.showFavouriteIcon = false
        }
    }

    private fun observeFavouriteLaunches() {
        viewModel.favouriteLaunches.observe(viewLifecycleOwner) { launches ->
            if (launches.isEmpty()) {
                binding.noFavLaunch.visibility = View.VISIBLE
            } else {
                binding.noFavLaunch.visibility = View.GONE
                spaceXAdapter.spaceXList = launches
            }
        }
    }

    private fun fetchFavouriteLaunches() {
        viewModel.getFavouriteLaunches()
    }
}