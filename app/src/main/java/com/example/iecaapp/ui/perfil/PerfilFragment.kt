package com.example.iecaapp.ui.perfil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.iecaapp.R
import com.example.iecaapp.databinding.FragmentHomeBinding

class PerfilFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
     //   val homeViewModel =
       //     ViewModelProvider(this).get(HomeViewModel::class.java)
       // _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root=inflater.inflate(R.layout.fragment_perfil,container,false)
        return root


        }
      //  return root


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}