package com.example.myprojectkotlinuniversity.domain

import com.example.myprojectkotlinuniversity.data.AnimalImagesRepository
import com.example.myprojectkotlinuniversity.data.AnimalRepository

object AnimalUseCase {

    private val remoteRepo = AnimalRepository
    private val remoteRepoImage = AnimalImagesRepository

    suspend fun getAnimal(): String {

        val fact = remoteRepo.getAnimal()?.facts?.get(0).toString()
        return fact
    }

    suspend fun getDogImage(): String {

        val dogImage = remoteRepoImage.getDogsImages()?.message ?: String()
        return dogImage

    }

}