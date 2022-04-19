package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.models.SaveUsernameParam
import com.example.cleanarchitecture.domain.repository.UserRepository

class SaveUC(private val userRepository : UserRepository) {

    fun execute(param : SaveUsernameParam):Boolean{
        return userRepository.saveName(param)
    }
}