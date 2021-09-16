package com.example.kotlin2dz.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {

    val list: MutableLiveData<ArrayList<String>> = MutableLiveData()
}