package com.example.myprojectkotlinuniversity.data.remote

import com.example.myprojectkotlinuniversity.data.remote.model.AnimalApiModel
import com.example.myprojectkotlinuniversity.data.remote.model.DogImagesApiModel
import retrofit2.Response
import retrofit2.http.GET

interface AnimalApiInterface {

    @GET("/api/facts?number=1")
    suspend fun getAnimal(): Response<AnimalApiModel>


    @GET("/api/breeds/image/random")
    suspend fun getImages(): Response<DogImagesApiModel>


}