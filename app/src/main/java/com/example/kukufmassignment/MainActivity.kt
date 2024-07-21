package com.example.kukufmassignment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.example.kukufmassignment.base.BaseActivity
import com.example.kukufmassignment.databinding.ActivityMainBinding
import com.example.kukufmassignment.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateToolbarText()
        onFavouriteClick()
    }

    private fun onFavouriteClick() {
        binding.ivFavourite.setOnClickListener {
            findNavController(R.id.nav_host_fragment).navigate(R.id.global_action_to_favourite_fragment)
        }
    }

    private fun updateToolbarText() {
        findNavController(R.id.nav_host_fragment)
            .addOnDestinationChangedListener{ _, destination, _ ->
                when(destination.id){
                    R.id.spaceXLaunchFragment -> {
                        binding.toolBarHeader.text = getString(R.string.home_header)
                        binding.ivFavourite.visibility = View.VISIBLE
                    }
                    R.id.spaceXDetailFragment -> {
                        binding.toolBarHeader.text = getString(R.string.detail_header)
                        binding.ivFavourite.visibility = View.GONE
                    }

                    R.id.favoriteFragment -> {
                        binding.toolBarHeader.text = getString(R.string.favourite_header)
                        binding.ivFavourite.visibility = View.GONE
                    }
                }
            }
    }


}