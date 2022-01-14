package com.client.myapplication.ui.view.fragments

import android.content.ClipData
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.client.myapplication.data.models.Quotes
import com.client.myapplication.databinding.FragmentMainBinding
import com.client.myapplication.ui.adapters.MyAdapter
import com.client.myapplication.ui.viewmodel.MainViewModel
import com.client.myapplication.utils.Status.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by viewModels()
    lateinit var myAdapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ui()
        observer()
    }

    private fun ui() {
        myAdapter = MyAdapter(arrayListOf())
        binding.recyclerView.adapter = myAdapter
    }

    private fun observer() {
        mainViewModel.getList().observe(requireActivity(), {

            when (it.status) {
                SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { result ->

                       binding.recyclerView.adapter = MyAdapter(result)

                    }

                }
                LOADING -> binding.progressBar.visibility = View.VISIBLE

                ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()

                }
            }

        })

    }

}