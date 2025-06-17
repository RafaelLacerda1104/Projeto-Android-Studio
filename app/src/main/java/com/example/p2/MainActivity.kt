package com.example.p2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.p2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener(this)
        binding.btnCadastrarLogin.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.btn_entrar) {
            btEntrar()
        }
        else if(view.id == R.id.btn_cadastrar_login) {
            btCriarConta()
        }
    }

    fun btEntrar() {
        val email = binding.editEmailLogin.text.toString()
        val senha = binding.editSenhaLogin.text.toString()

        if(senha == "senha123") {
            startActivity(Intent(this, IndexActivity::class.java))
            finish()
        }
        else {
            Toast.makeText(this, "Senha Inválida", Toast.LENGTH_SHORT).show()
        }
    }

    fun btCriarConta() {
        startActivity(Intent(this, RegistrarActivity::class.java))
        finish()
    }

}