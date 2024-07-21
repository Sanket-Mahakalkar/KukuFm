package com.example.kukufmassignment.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.kukufmassignment.R

abstract class BaseFragment<VB: ViewBinding, VM: BaseViewModel<*>>
    (private val layout: Int): Fragment(){

    abstract val viewModel: VM

    private lateinit var _binding: VB

    protected val binding: VB
        get() = _binding

    private var dialog: Dialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layout, container, false)
        return _binding.root
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
                val builder = AlertDialog.Builder(requireActivity())
                val view =
                    LayoutInflater.from(requireActivity()).inflate(R.layout.layout_progress_bar, null)
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