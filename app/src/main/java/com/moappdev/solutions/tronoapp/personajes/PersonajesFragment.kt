package com.moappdev.solutions.tronoapp.personajes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.moappdev.solutions.tronoapp.R
import com.moappdev.solutions.tronoapp.databinding.FragmentPersonajesBinding

class PersonajesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPersonajesBinding.inflate(inflater)

        val viewModel= ViewModelProvider(this).get(PersonajeViewModel::class.java)
        binding.viewModel=viewModel
        binding.lifecycleOwner=this

        val adapter= PersonajeAdapter(PersonajeAdapter.ClickListner{
            findNavController().navigate(PersonajesFragmentDirections.actionPersonajesFragmentToDetalleFragment(it))
        })
        binding.recyclerPersonajes.adapter=adapter
        viewModel.personajes.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }
}