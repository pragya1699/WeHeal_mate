package com.example.prigs

import android.icu.text.IDNA
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val numOfOnlineHealers: MutableLiveData<Info> =WeHealRepository.getNumOfOnlineHealersLiveData()
    val numOfOnlineHealersLiveData: LiveData<Info> get()=numOfOnlineHealers

    private val numOfOfflineHealers: MutableLiveData<Info> =WeHealRepository.getNumOfOfflineHealersLiveData()
    val numOfOfflineHealersLiveData: LiveData<Info> get()=numOfOfflineHealers

    private val numOfOnlineUsers: MutableLiveData<Info> =WeHealRepository.getNumOfOnlineUsersLiveData()
    val numOfOnlineUsersLiveData: LiveData<Info> get()=numOfOnlineUsers

    private val numOfOfflineUsers: MutableLiveData<Info> =WeHealRepository.getNumOfOfflineUsersLiveData()
    val numOfOfflineUsersLiveData: LiveData<Info> get()=numOfOfflineUsers

    fun pushToDatabase(){
        WeHealRepository.run { pushToDatabase()
        }
    }

}

