package com.sample.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController


class MainActivity : AppCompatActivity() {

    private var USERNAME = ""
    private var PASSWORD = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bundle = Bundle().apply {
            putString("usernameKey", USERNAME)
            putString("passwordKey", PASSWORD)
        }

        val navController = findNavController(R.id.nav_host_fragment)
        navController.navigate(R.id.loginFragment, bundle)

    }
}