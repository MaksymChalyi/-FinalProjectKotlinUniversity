package com.example.myprojectkotlinuniversity.data

import com.example.myprojectkotlinuniversity.data.remote.ApiFactory
import com.example.myprojectkotlinuniversity.data.remote.model.AnimalApiModel

object AnimalRepository {

    private val api = ApiFactory.animalApi

    suspend fun getAnimal(): AnimalApiModel? {

        val response = api.getAnimal()
        if (response.isSuccessful) {
            if (response.body() != null) {
                val body = response.body()
                return body!!
            }
        }

        return null
    }
}
