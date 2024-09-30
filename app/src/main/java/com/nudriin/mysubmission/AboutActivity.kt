package com.nudriin.mysubmission

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nudriin.mysubmission.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAboutDetail()
    }

    private fun setAboutDetail() {
        val detailArr = resources.getStringArray(R.array.about_detail)
        binding.TVAboutDetail1.text = detailArr[0]
        binding.TVAboutDetail2.text = detailArr[1]
        binding.TVAboutDetail3.text = detailArr[2]
    }
}