package com.example.desafio_3.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.desafio_3.MainActivity
import com.example.desafio_3.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setSupportActionBar(ic_toolbar as Toolbar?)

        val actionBar = supportActionBar
        actionBar?.title = resources.getText(R.string.title_register)
        actionBar?.setIcon(R.drawable.ic_arrow_back)
    }
}