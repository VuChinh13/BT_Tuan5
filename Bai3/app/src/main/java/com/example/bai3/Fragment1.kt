package com.example.bai3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class Fragment1 : Fragment() {

    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_1, container, false)

        button = view.findViewById(R.id.bt_chia2) // Giả sử Button trong fragment có ID này

        button.setOnClickListener {
            // Lấy dữ liệu từ EditText trong MainActivity
            val input = (activity as MainActivity).getInputData()

            if (input.isNotEmpty()) {
                // Tính chia cho 2
                val result = input.toDoubleOrNull()?.div(2) ?: 0.0
                // Hiển thị kết quả trong MainActivity
                (activity as MainActivity).showResult("Kết quả chia cho 2: $result")
            } else {
                Toast.makeText(context, "Vui lòng nhập số!", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
