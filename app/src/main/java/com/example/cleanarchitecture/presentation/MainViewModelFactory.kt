package com.example.cleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.data.storage.SharedPrefUserStorage
import com.example.cleanarchitecture.domain.usecase.GetUC
import com.example.cleanarchitecture.domain.usecase.SaveUC

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {


    private val userRepository by lazy { UserRepositoryImpl(SharedPrefUserStorage(context)) }
    private val getUserUC by lazy { GetUC(userRepository) }
    private val saveUserUC by lazy { SaveUC(userRepository) }


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserUC, saveUserUC) as T
    }
}