package com.example.bai1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai1.databinding.ActivityMainBinding
import com.example.bai1.databinding.ActivityResultActivityBinding
import java.math.RoundingMode

const val EXTRA_BMI = "extra_bmi"
class ResultActivity : AppCompatActivity() {
    private lateinit var binding:ActivityResultActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResultActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Nhận giá trị truyền từ bên MainActivity
        val itent1 = intent
        val chieuCao = itent1.getDoubleExtra(EXTRA_CHIEU_CAO,0.1)
        val cangNang = itent1.getDoubleExtra(EXTRA_CAN_NANG,0.0)

        val ketQua = cangNang / ((chieuCao/100) * (chieuCao/100)) // đổi ra m

        if (ketQua < 18.5){
            binding.tvKetqua.text = ""
            binding.tvKetqua.text = "Chỉ số BMI của bạn là:" + String.format("%.2f",ketQua) + " và\n thuộc loại: thiếu cân"
        } else if (ketQua >= 18.5 && ketQua < 25){
            binding.tvKetqua.text = ""
            binding.tvKetqua.text = "Chỉ số BMI của bạn là:" +  String.format("%.2f",ketQua) + " và\n thuộc loại: cân nặng bình thường"
        } else if (ketQua >= 25 && ketQua < 30){
            binding.tvKetqua.text = ""
            binding.tvKetqua.text = "Chỉ số BMI của bạn là:" +  String.format("%.2f",ketQua) + " và\n thuộc loại: thừa cân"
        } else if (ketQua >= 30 && ketQua < 40){
            binding.tvKetqua.text = ""
            binding.tvKetqua.text = "Chỉ số BMI của bạn là:" +  String.format("%.2f",ketQua) + " và\n thuộc loại: béo phì"
        } else {
            binding.tvKetqua.text = ""
            binding.tvKetqua.text = "Chỉ số BMI của bạn là:" +  String.format("%.2f",ketQua) + " và\n thuộc loại: béo phì nghiêm trọng"
        }


        binding.btQuaylai.setOnClickListener(object : View.OnClickListener {
            override fun onClick(it: View) {
                val intent2 = Intent(this@ResultActivity,MainActivity::class.java)
                intent2.putExtra(EXTRA_BMI, ketQua)
                startActivity(intent2)
            }
        })
    }
}


