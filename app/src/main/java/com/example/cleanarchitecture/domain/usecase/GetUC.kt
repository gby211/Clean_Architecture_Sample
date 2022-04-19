package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.models.UserName
import com.example.cleanarchitecture.domain.repository.UserRepository

class GetUC (private val userRepository: UserRepository){

    fun execute():UserName{
        return userRepository.getName()
    }
}