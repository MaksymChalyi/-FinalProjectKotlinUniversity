package com.example.myprojectkotlinuniversity.data

import com.example.myprojectkotlinuniversity.data.remote.ApiFactoryImagesOfDogs
import com.example.myprojectkotlinuniversity.data.remote.model.DogImagesApiModel

object AnimalImagesRepository {

    private val imagesApi = ApiFactoryImagesOfDogs.animalImagesApi

    suspend fun getDogsImages(): DogImagesApiModel? {

        val responseImages = imagesApi.getImages()
        if (responseImages.isSuccessful) {
            if (responseImages.body() != null) {
                val body = responseImages.body()
                return body!!
            }
        }
        return null
    }
}