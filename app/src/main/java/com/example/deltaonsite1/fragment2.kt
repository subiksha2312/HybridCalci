package com.example.deltaonsite1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class fragment2 : Fragment() {

    private lateinit var viewModel: ResultSet

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_2,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(requireActivity()).get(ResultSet::class.java)
        val textView2 = getView()?.findViewById<TextView>(R.id.textView2)

       // button2?.setOnClickListener {
            viewModel.getResult().observe(viewLifecycleOwner,Observer {
                textView2?.text = viewModel.getResult().value.toString()
            })
        //}
    }
}