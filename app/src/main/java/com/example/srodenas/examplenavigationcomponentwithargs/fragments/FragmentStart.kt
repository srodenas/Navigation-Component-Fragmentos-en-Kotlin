package com.example.srodenas.examplenavigationcomponentwithargs.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.srodenas.examplenavigationcomponentwithargs.R
import com.example.srodenas.examplenavigationcomponentwithargs.databinding.FragmentStartBinding
import com.example.srodenas.examplenavigationcomponentwithargs.fragments.fragment_b.FragmentBDirections


class FragmentStart : Fragment() {
    lateinit var navController : NavController          //nuestro navController
    lateinit var bindingFragment : FragmentStartBinding //utilizamos binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflamos la vista, a partir de la clase Binding del fragmento.
        bindingFragment  =  FragmentStartBinding.inflate(inflater, container, false)
        val viewFragment = bindingFragment.root //devolvemos el raiz, que será la vista.
        return viewFragment
    }

    /*
    A partir de nuestro NavController, podemos navegar utilizando las acciones del navGraph
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navHost = requireActivity()     //referencia del activity
            .supportFragmentManager         //administrador de Fragmentos
            .findFragmentById(R.id.fragmentContainerView)   //buscamos el Contenedor de Fragmentos

        navHost.let {//Si entramos dentro, no es nulo.
            navController = navHost!!.findNavController() //buscamos su NavController

            bindingFragment.button1Inicio.setOnClickListener{
                navController.navigate(R.id.action_fragmentStart_to_fragmentA)  //navegamos
            }

            bindingFragment.button2Inicio.setOnClickListener{
                navController.navigate(FragmentStartDirections.actionFragmentStartToFragmentB(name = "Santiago"))  //navegamos
            }
        }
    }


}