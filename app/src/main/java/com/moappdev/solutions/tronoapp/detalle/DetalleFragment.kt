package com.moappdev.solutions.tronoapp.detalle

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.moappdev.solutions.tronoapp.R
import com.moappdev.solutions.tronoapp.databinding.FragmentDetalleBinding
import com.moappdev.solutions.tronoapp.model.House

class DetalleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding= FragmentDetalleBinding.inflate(inflater)

        val id= DetalleFragmentArgs.fromBundle(arguments!!).personaje

        val viewModelFactory= DetailViewModelFactory(id)
        val viewModel= ViewModelProvider(this,viewModelFactory).get(DetailViewModel::class.java)
        binding.viewModel=viewModel
        binding.lifecycleOwner=this

        viewModel.material.observe(viewLifecycleOwner, Observer {
            binding.view.setBackgroundResource(it[0])
            binding.button.backgroundTintList=ContextCompat.getColorStateList(this.requireContext(),it[1])
            binding.button.setImageDrawable(ContextCompat.getDrawable(this.requireContext(),it[2]))
        })

        viewModel.onBtn.observe(viewLifecycleOwner, Observer {
            it?.let {
                findNavController().navigate(DetalleFragmentDirections.actionDetalleFragmentToHouseDialog(it))
                viewModel.onWordsC()
            }
        })

        return binding.root
    }
}