package com.example.bai2

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

class HomeFragment : Fragment() {

    private lateinit var editText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        editText = view.findViewById(R.id.et_home)

        // Phục hồi dữ liệu từ savedInstanceState nếu có
        if (savedInstanceState != null) {
            val text = savedInstanceState.getString("editTextData", "")
            editText.setText(text)
        }

        return view
    }

    // Lưu trạng thái dữ liệu khi Fragment bị hủy
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Lưu dữ liệu trong EditText vào Bundle
        outState.putString("editTextData", editText.text.toString())
    }
}
