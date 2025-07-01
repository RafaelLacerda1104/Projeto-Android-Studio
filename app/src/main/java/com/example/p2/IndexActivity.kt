package com.example.p2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.p2.databinding.ActivityIndexBinding
import com.example.p2.databinding.ActivityRegistrarBinding

class IndexActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityIndexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIndexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iconeSair.setOnClickListener(this)
        binding.btnAdd.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if(view.id == R.id.icone_sair) {
            btSair()
        }
        else if(view.id == R.id.btn_add) {
            btAdd()
        }
    }

    fun btSair() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun btAdd() {
        startActivity(Intent(this, PaginaAddActivity::class.java))
    }

}