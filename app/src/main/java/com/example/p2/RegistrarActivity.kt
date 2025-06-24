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
import com.example.p2.databinding.ActivityRegistrarBinding

class RegistrarActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRegistrarBinding
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = DatabaseHelper(this)

        binding.btnCadastrarRegistrar.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.btn_cadastrar_registrar) {
            btCadastrar()
        }
    }

    private fun btCadastrar() {
        val email = binding.editEmailRegistrar.text.toString().trim()
        val senha = binding.editSenhaRegistrar.text.toString().trim()
        val confirmarSenha = binding.editConfirmarSenhaRegistrar.text.toString().trim()

        if (email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }
        else if (confirmarSenha != senha) {
            Toast.makeText(this, "As senhas digitadas são diferentes.", Toast.LENGTH_SHORT).show()
            return
        }

        val resultado = dbHelper.inserirUsuario(email, senha)
        if (resultado != -1L) {
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        else {
            Toast.makeText(this, "Erro: Email já cadastrado", Toast.LENGTH_SHORT).show()
        }
    }
}