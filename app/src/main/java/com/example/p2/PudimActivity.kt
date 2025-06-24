package com.example.p2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.p2.databinding.ActivityBoloBinding
import com.example.p2.databinding.ActivityPudimBinding

class PudimActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPudimBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPudimBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iconePudimSair.setOnClickListener(this)
        binding.btnPudimVoltar.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.icone_pudim_sair) {
            btPudimSair()
        } else if (view.id == R.id.btn_pudim_voltar) {
            btPudimVoltar()
        }
    }

    fun btPudimSair() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun btPudimVoltar() {
        startActivity(Intent(this, IndexActivity::class.java))
        finish()
    }
}