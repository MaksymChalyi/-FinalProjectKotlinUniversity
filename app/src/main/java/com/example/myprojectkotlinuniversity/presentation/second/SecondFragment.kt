package com.example.myprojectkotlinuniversity.presentation.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.myprojectkotlinuniversity.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    lateinit var secondViewModel: SecondViewModel

    companion object {
        const val numberInArray = "number"
        const val name = "name"
        const val desc = "desc"
        const val fullDesc = "fullDesc"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        secondViewModel = ViewModelProvider(this).get(SecondViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) { // method for work with button etc.
        super.onViewCreated(view, savedInstanceState)
        binding.tvName.text = arguments?.getString(name)
        binding.tvDescription.text = arguments?.getString(desc)
        binding.tvSecondFullDesc.text = arguments?.getString(fullDesc)


        secondViewModel.getFact() // Факт з інтернету
        secondViewModel.fact.observe(viewLifecycleOwner) {
            binding.tvRandFact.text = it
        }

        secondViewModel.getImage() // // Фото з інтернету
        secondViewModel.imageDog.observe(viewLifecycleOwner) {
            Glide.with(view).load(it).fitCenter().into(binding.ivPhoto)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}