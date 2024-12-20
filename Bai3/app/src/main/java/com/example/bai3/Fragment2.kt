package com.example.bai3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class Fragment2 : Fragment() {

    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_2, container, false)

        button = view.findViewById(R.id.bt_nhan2)

        button.setOnClickListener {
            val input = (activity as MainActivity).getInputData()

            if (input.isNotEmpty()) {
                // Tính nhân cho 2
                val result = input.toDoubleOrNull()?.times(2) ?: 0.0
                (activity as MainActivity).showResult("Kết quả nhân cho 2: $result")
            } else {
                Toast.makeText(context, "Vui lòng nhập số!", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}