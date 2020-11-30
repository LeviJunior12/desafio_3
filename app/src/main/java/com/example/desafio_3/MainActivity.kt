package com.example.desafio_3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafio_3.ui.MenuActivity
import com.example.desafio_3.ui.RegisterActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login_body.*
import kotlinx.android.synthetic.main.login_top.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        include1.tv_title.text = resources.getText(R.string.txt_top_login)

        btn_login.setOnClickListener {
            var intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        tv_create_account.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}