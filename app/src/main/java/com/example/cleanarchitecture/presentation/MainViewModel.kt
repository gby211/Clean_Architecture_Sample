package com.example.cleanarchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.domain.models.SaveUsernameParam
import com.example.cleanarchitecture.domain.models.UserName
import com.example.cleanarchitecture.domain.usecase.GetUC
import com.example.cleanarchitecture.domain.usecase.SaveUC

class MainViewModel(private val getUserUC: GetUC, private val saveUserUC: SaveUC) : ViewModel() {


    private val _resultLive = MutableLiveData<String>()
    val resultLive: LiveData<String> = _resultLive

    fun send(text: String) {
        val param = SaveUsernameParam(text)
        val result = saveUserUC.execute(param)
        _resultLive.value = result.toString()
    }

    fun receive() {
        val userName: UserName = getUserUC.execute()
        _resultLive.value = userName.firstName.toString()
    }
}