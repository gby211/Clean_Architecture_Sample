package com.example.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.data.storage.SharedPrefUserStorage
import com.example.cleanarchitecture.data.storage.UserStorage
import com.example.cleanarchitecture.domain.models.SaveUsernameParam
import com.example.cleanarchitecture.domain.models.UserName
import com.example.cleanarchitecture.domain.usecase.GetUC
import com.example.cleanarchitecture.domain.usecase.SaveUC

class MainActivity : AppCompatActivity() {


    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        vm = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<TextView>(R.id.dataEditView)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        vm.resultLive.observe(this) {
            dataTextView.text = it
        }

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            vm.send(text)
        }

        receiveButton.setOnClickListener {
            vm.receive()
        }
    }
}