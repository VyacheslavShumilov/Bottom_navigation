package com.hfad.bottom_navigation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.hfad.bottom_navigation.CarAdapter
import com.hfad.bottom_navigation.Cars
import com.hfad.bottom_navigation.R
import com.hfad.bottom_navigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val adapter = CarAdapter()
    private val imageIdList = listOf(
        R.drawable.car1,
        R.drawable.car2,
        R.drawable.car3,
        R.drawable.car4,
    )

    private var index = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        with(binding){
            btnNext.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_homeDataFragment)
            }
        }
    }

    private fun init() {
        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(context, 3)
            recyclerView.adapter = adapter
            btnAddCar.setOnClickListener{
                if (index > 3) index = 0
                val car = Cars(imageIdList[index], "Car $index")
                adapter.addCar(car)
                index++
            }
        }
    }
}