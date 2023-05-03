package com.example.myprojectkotlinuniversity.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    const val BASE_URL = " https://dog-api.kinduff.com"

    val animalApi: AnimalApiInterface = createRetrofit().create(AnimalApiInterface::class.java)

    // Функція створює та повертає об'єкт Retrofit, який використовується для здійснення HTTP запитів.
    private fun createRetrofit(): Retrofit {

        // В цій функції створюється OkHttpClient з HttpLoggingInterceptor, який дозволяє перехоплювати та виводити в консоль HTTP запити та відповіді на них.
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create()) // Перетворюємо за допомогою GsonConverterFactory JSON в об'єкти Kotlin.
            .build()

        return retrofit

    }

}



