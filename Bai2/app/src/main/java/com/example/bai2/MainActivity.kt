package com.example.bai2

import androidx.fragment.app.Fragment
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.bai2.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var homeFragment: HomeFragment
    private lateinit var profileFragment: ProfileFragment
    private lateinit var settingFragment: SettingFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mặc định hiển thị FragmentHome
        if (savedInstanceState == null) {
            homeFragment = HomeFragment()
            profileFragment = ProfileFragment()
            settingFragment = SettingFragment()

            // Thêm các fragment vào container lần đầu tiên
            supportFragmentManager.beginTransaction()
                .add(R.id.fl_main, homeFragment, "homeFragment")
                .add(R.id.fl_main, profileFragment, "profileFragment")
                .add(R.id.fl_main, settingFragment, "settingFragment")
                .hide(profileFragment)
                .hide(settingFragment)
                .commit()
        }

        // Thiết lập sự kiện cho BottomNavigationView
        binding.bnBar.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    showFragment(homeFragment)
                    true
                }
                R.id.profile -> {
                    showFragment(profileFragment)
                    true
                }
                R.id.setting -> {
                    showFragment(settingFragment)
                    true
                }
                else -> false
            }
        })
    }

    // Hàm để hiển thị fragment và ẩn các fragment còn lại
    private fun showFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        // Ẩn tất cả các fragment hiện tại
        transaction.hide(homeFragment)
        transaction.hide(profileFragment)
        transaction.hide(settingFragment)

        // Hiển thị fragment hiện tại
        transaction.show(fragment)
        transaction.commit()
    }
}
