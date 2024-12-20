package com.example.bai3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bai3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mặc định hiển thị Fragment1
        placeFragment(Fragment1())

        // Thiết lập sự kiện khi người dùng chọn button
        binding.btFragment1.setOnClickListener {
            placeFragment(Fragment1())
        }

        binding.btFragment2.setOnClickListener {
            placeFragment(Fragment2())
        }

        binding.btFragment3.setOnClickListener {
            placeFragment(Fragment3())
        }
    }

    // Phương thức để thay thế fragment trong FrameLayout
    private fun placeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_main, fragment)
        transaction.commit()
    }

    // Phương thức để lấy giá trị từ EditText và truyền vào Fragment
    fun getInputData(): String {
        return binding.etNhap.text.toString()
    }

    // Phương thức để hiển thị kết quả từ Fragment lên TextView của Activity
    fun showResult(result: String) {
        binding.tvKetQua.text = result
    }
}
