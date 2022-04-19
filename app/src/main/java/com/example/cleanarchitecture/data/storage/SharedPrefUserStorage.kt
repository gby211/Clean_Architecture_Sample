package com.example.cleanarchitecture.data.storage

import android.content.Context
import com.example.cleanarchitecture.data.storage.models.User


private const val SHA = "sha"
private const val FIRST = "first"

class SharedPrefUserStorage(context: Context) : UserStorage {

    val sharedPreferences = context.getSharedPreferences(SHA, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(FIRST, user.firstName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(FIRST, "") ?: ""
        val lastName = sharedPreferences.getString(FIRST, "DEF LAST") ?: "DEF LAST"
        return User(firstName = firstName, lastName = lastName)
    }
}