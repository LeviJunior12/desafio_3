package com.example.desafio_3.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.desafio_3.MainActivity
import com.example.desafio_3.R
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.register_body.*


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var toolbar: Toolbar = toolbar_register
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = resources.getText(R.string.title_register)

        toolbar_register.setNavigationOnClickListener   {
            Toast.makeText(this, "teste", Toast.LENGTH_SHORT).show()
        }

        btn_login.setOnClickListener {
            var intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}