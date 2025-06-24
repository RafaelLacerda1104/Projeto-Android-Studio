package com.example.p2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.p2.databinding.ActivityBoloBinding
import com.example.p2.databinding.ActivityRegistrarBinding

class BoloActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityBoloBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoloBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iconeBoloSair.setOnClickListener(this)
        binding.btnBoloVoltar.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.icone_bolo_sair) {
            btBoloSair()
        } else if (view.id == R.id.btn_bolo_voltar) {
            btBoloVoltar()
        }
    }

    fun btBoloSair() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun btBoloVoltar() {
        startActivity(Intent(this, IndexActivity::class.java))
        finish()
    }
}
