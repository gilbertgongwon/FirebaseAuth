package com.s2d5.myawesomeproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.s2d5.myawesomeproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClick(view: View) {
        when(view) {
            binding.joinBTN -> {
                val intent:Intent = Intent(this, JoinActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}