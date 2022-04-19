package com.example.cleanarchitecture.domain.repository

import com.example.cleanarchitecture.domain.models.SaveUsernameParam
import com.example.cleanarchitecture.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam : SaveUsernameParam):Boolean
    fun getName(): UserName
}