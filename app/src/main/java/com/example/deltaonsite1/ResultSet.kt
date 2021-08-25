package com.example.deltaonsite1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultSet : ViewModel() {
    private val result = MutableLiveData<Long>()

    fun setResult(num: Long) {
        result.value = num
    }

    fun getResult(): LiveData<Long> {
        return result
    }
}