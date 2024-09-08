package com.example.coffeeshop.Activity

import android.content.Intent
import android.os.Bundle
import com.example.coffeeshop.databinding.ActivityIntroBinding


class IntroActivity : BaseActivity() {
    private lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.startBtn.setOnClickListener {
            val intent = Intent(this@IntroActivity, MainActivity::class.java)

            startActivity(intent)

        }

    }
}