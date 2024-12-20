package com.example.bai1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai1.databinding.ActivityMainBinding

const val EXTRA_CAN_NANG = "extra_can_nang"
const val EXTRA_CHIEU_CAO = "extra_chieu_cao"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent1 = intent
        var chiSoBMI = intent1.getDoubleExtra(EXTRA_BMI, 0.0)

        // kiểm tra xem có dữ liệu nào được truyền sang bên Activity này hay không
        if (chiSoBMI != 0.0) {
            binding.etKetqua.append(String.format("%.2f", chiSoBMI))
        }


        binding.btDanhgia.setOnClickListener(View.OnClickListener {
            if (binding.etCangnang.text.isEmpty() || binding.etChieucao.text.isEmpty()) {
                Toast.makeText(this, "Hãy nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
            } else {
                val i = Intent(this, ResultActivity::class.java)
                // truyền dữ liệu trực tiếp bằng Intent
                i.putExtra(EXTRA_CAN_NANG, binding.etCangnang.text.toString().toDouble())
                i.putExtra(EXTRA_CHIEU_CAO, binding.etChieucao.text.toString().toDouble())
                startActivity(i)
            }
        })
    }
}

