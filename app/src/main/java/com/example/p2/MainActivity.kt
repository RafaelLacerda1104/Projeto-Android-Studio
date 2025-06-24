package com.example.p2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.p2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = DatabaseHelper(this)

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

    private fun btEntrar() {
        val email = binding.editEmailLogin.text.toString().trim()
        val senha = binding.editSenhaLogin.text.toString().trim()

        if (email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }

        val usuarioValido = dbHelper.verificarUsuario(email, senha)

        if (usuarioValido) {
            Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, IndexActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "Email ou senha inválidos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun btCriarConta() {
        startActivity(Intent(this, RegistrarActivity::class.java))
        finish()
    }

}