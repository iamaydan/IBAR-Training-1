package com.anushka.navdemo5


import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.anushka.navdemo5.databinding.FragmentNameBinding

class NameFragment : Fragment() {
    private lateinit var binding: FragmentNameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)
        binding.nextButton.setOnClickListener {
            if (!TextUtils.isEmpty(binding.inputText.text.toString())) {
                val bundle = bundleOf(
                    "input_name" to binding.inputText.text.toString()
                )
                it.findNavController().navigate(R.id.action_nameFragment_to_emailFragment, bundle)
            } else {
                Toast.makeText(activity, "Please enter your name", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }
}
