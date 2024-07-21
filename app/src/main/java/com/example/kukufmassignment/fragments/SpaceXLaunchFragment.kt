package com.example.kukufmassignment.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kukufmassignment.R
import com.example.kukufmassignment.adapters.SpaceXAdapter
import com.example.kukufmassignment.base.BaseFragment
import com.example.kukufmassignment.data.network.Status
import com.example.kukufmassignment.databinding.FragmentSpacexLaunchBinding
import com.example.kukufmassignment.viewmodel.MainViewModel
import com.example.kukufmassignment.viewmodel.SpaceXLaunchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SpaceXLaunchFragment : BaseFragment<FragmentSpacexLaunchBinding, SpaceXLaunchViewModel>(R.layout.fragment_spacex_launch) {

    override val viewModel: SpaceXLaunchViewModel by viewModels()

    @Inject  lateinit var spaceXAdapter: SpaceXAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getSpaceXLaunches()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeData()
        setRecyclerView()
    }


    private fun setRecyclerView() {
        binding.rvSpacexLauches.apply {
            adapter = spaceXAdapter
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            spaceXAdapter.showFavouriteIcon = true
        }

        spaceXAdapter.setOnItemClickListener {
            val action = SpaceXLaunchFragmentDirections.launchFragmentToDetailFragment(it)
            findNavController().navigate(action)
        }

        spaceXAdapter.setOnFavouriteClickListener {
            viewModel.updateSpaceXLaunchesInDb(it)
        }
    }

    private fun observeData() {
        viewModel.spaceXLaunchesResult.observe(viewLifecycleOwner){ result->
            when(result.status){
                Status.SUCCESS -> {
                   hideLoadingDialog()
                    result.data?.let {  spaceXAdapter.spaceXList = it}
                }

                Status.ERROR -> {
                    hideLoadingDialog()
                    showErrorToast(result.message)
                }

                Status.LOADING -> showLoadingDialog()
            }

        }


        binding.searchView.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {
            private var debounceJob: Job? = null
            private val DELAY: Long = 200L
            private var isInitialized = false

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(!isInitialized){
                    isInitialized = true
                    return true
                }
                debounceJob?.cancel()

                newText?.let {
                    debounceJob = viewLifecycleOwner.lifecycleScope.launch {
                        delay(DELAY)
                        viewModel.searchSpaceXLaunches(newText)
                    }
                }
                return true
            }

        })

    }

    private fun showErrorToast(error: String?) {
        Toast.makeText(requireActivity(), error, Toast.LENGTH_SHORT).show()
    }


}