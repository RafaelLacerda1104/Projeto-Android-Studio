package com.example.p2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.p2.databinding.ActivityPaginaAddBinding

class PaginaAddActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPaginaAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaginaAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        }

    override fun onClick(view: View) {
        TODO("Not yet implemented")
    }
}
}