package com.example.p2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.p2.databinding.ActivityMainBinding
import com.example.p2.databinding.ActivityRegistrarBinding

class RegistrarActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRegistrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastrarRegistrar.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.btn_cadastrar_registrar) {
            btCadastrar()
        }
    }

    fun btCadastrar() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}