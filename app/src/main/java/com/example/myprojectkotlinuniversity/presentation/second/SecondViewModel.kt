package com.example.myprojectkotlinuniversity.presentation.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myprojectkotlinuniversity.domain.AnimalUseCase
import kotlinx.coroutines.launch

class SecondViewModel : ViewModel() {
    val animalUseCase = AnimalUseCase
    val fact = MutableLiveData<String>()
    val imageDog = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()


    fun getFact() {

        viewModelScope.launch {
            isLoading.postValue(true)
            fact.postValue(animalUseCase.getAnimal())
            isLoading.postValue(false)
        }
    }

    fun getImage() {

        viewModelScope.launch {
            isLoading.postValue(true)
            imageDog.postValue(animalUseCase.getDogImage())
            isLoading.postValue(false)
        }
    }

}