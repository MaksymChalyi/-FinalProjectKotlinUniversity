package com.example.myprojectkotlinuniversity.presentation.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myprojectkotlinuniversity.data.Animal
import com.example.myprojectkotlinuniversity.R
import com.example.myprojectkotlinuniversity.databinding.FragmentFirstBinding
import com.example.myprojectkotlinuniversity.presentation.second.SecondFragment

class FirstFragment : Fragment(), FirstAnimalAdapter.Listener {

    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!
    var animals = ArrayList<Animal>()

    lateinit var adapter: FirstAnimalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var dogBarsik = Animal(getString(R.string.NameDog1), getString(R.string.kindAnimal), getString(R.string.urlOfBarsik), getString(R.string.fullDescOfFact))
        var dogBobik = Animal(getString(R.string.NameDog2), getString(R.string.kindAnimal), getString(R.string.urlOfBobik),getString(R.string.fullDescOfFact))
        var dogIzabella = Animal (getString(R.string.NameDog3), getString(R.string.kindAnimal), getString(R.string.urlOfIzabella),getString(R.string.fullDescOfFact))

        animals.add(dogBarsik)
        animals.add(dogBobik)
        animals.add(dogIzabella)
        adapter = FirstAnimalAdapter(this)
        adapter.setListOfAnimals(animals)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated( view: View, savedInstanceState: Bundle? ) { // method for work with button etc.
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(itemView: Int) {

        val bundle = bundleOf(
            SecondFragment.numberInArray to itemView,
            SecondFragment.name to animals.get(itemView).name,
            SecondFragment.desc to animals.get(itemView).shortDesc,
            SecondFragment.fullDesc to animals.get(itemView).fullDesc)
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)

    }


}