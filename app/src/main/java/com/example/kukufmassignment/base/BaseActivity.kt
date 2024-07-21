package com.example.kukufmassignment.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleObserver
import androidx.viewbinding.ViewBinding
import com.example.kukufmassignment.R

abstract class BaseActivity<VB: ViewBinding, VM: BaseViewModel<*>>
    (private val layout: Int): AppCompatActivity() {

        abstract val viewModel: VM

        private lateinit var _binding: VB

        protected val binding: VB
            get() = _binding

    private var dialog: Dialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, layout)
    }


     fun hideLoadingDialog() {
        if (dialog != null) {
            dialog?.dismiss()
            dialog = null
        }
    }

     fun showLoadingDialog() {
        try {
            if (dialog == null) {
                val builder = AlertDialog.Builder(this)
                val view =
                    LayoutInflater.from(this).inflate(R.layout.layout_progress_bar, null)
                builder.setView(view)
                dialog = builder.create()
            }
            dialog?.setCancelable(false)
            dialog?.show()
        }catch (_:Exception)
        {

        }
    }

}