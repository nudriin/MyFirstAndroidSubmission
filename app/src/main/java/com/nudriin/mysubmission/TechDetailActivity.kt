package com.nudriin.mysubmission

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.nudriin.mysubmission.databinding.ActivityTechDetailBinding

class TechDetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityTechDetailBinding

    companion object {
        const val DATA_DETAIl = "data_detail"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTechDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tech = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Tech>(DATA_DETAIl, Tech::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Tech>(DATA_DETAIl)
        }

        if (tech != null) {
            Glide.with(binding.receivedIcon.context).load(tech.icon).into(binding.receivedIcon)
            binding.receivedTitle.text = tech.title
            binding.receivedDescription.text = tech.description
            binding.actionShare.setOnClickListener(this)
        }


    }

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.actionShare.id -> {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.putExtra(Intent.EXTRA_TEXT, binding.receivedDescription.text)
                shareIntent.setType("text/plain")
                startActivity(shareIntent)
            }
        }
    }

}