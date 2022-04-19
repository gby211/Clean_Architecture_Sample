package com.example.cleanarchitecture.data.repository

import com.example.cleanarchitecture.data.storage.models.User
import com.example.cleanarchitecture.data.storage.UserStorage
import com.example.cleanarchitecture.domain.models.SaveUsernameParam
import com.example.cleanarchitecture.domain.models.UserName
import com.example.cleanarchitecture.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {


    override fun saveName(saveParam: SaveUsernameParam): Boolean {

        val user = User(firstName = saveParam.name, lastName = "")
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return UserName(user.firstName, user.lastName)
    }

}