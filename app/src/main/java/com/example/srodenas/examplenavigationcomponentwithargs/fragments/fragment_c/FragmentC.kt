package com.example.srodenas.examplenavigationcomponentwithargs.fragments.fragment_c

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.srodenas.examplenavigationcomponentwithargs.R
import com.example.srodenas.examplenavigationcomponentwithargs.databinding.FragmentABinding
import com.example.srodenas.examplenavigationcomponentwithargs.databinding.FragmentCBinding
import com.example.srodenas.examplenavigationcomponentwithargs.databinding.FragmentStartBinding

class FragmentC : Fragment() {

    lateinit var navController : NavController
    lateinit var bindingFragment: FragmentCBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingFragment  =  FragmentCBinding.inflate(inflater, container, false)
        val viewFragment = bindingFragment.root
        return viewFragment
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navHost = requireActivity()
            .supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView)

        navHost.let {
            navController = navHost!!.findNavController()
            bindingFragment.button1C.setOnClickListener{
                navController.navigate(R.id.action_fragmentC_to_fragmentB)
            }

            bindingFragment.button2C.setOnClickListener{
                navController.navigate(R.id.action_fragmentC_to_fragmentStart)
            }
        }

    }



}