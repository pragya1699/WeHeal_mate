package com.example.prigs

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.*

object WeHealRepository {
private val firebasedatabase: FirebaseDatabase by lazy {
    FirebaseDatabase.getInstance()
}
    fun getNumOfOnlineHealersLiveData(): MutableLiveData<Info> {
        var mutableLiveData: MutableLiveData<Info>?= MutableLiveData()
        if(mutableLiveData==null){
            mutableLiveData= MutableLiveData()
        }
      // GlobalScope.launch{
        //  delay(5000)
          //mutableLiveData.postValue(10)
      //}

        firebasedatabase.reference.child("numOfOnlineHealers").addValueEventListener(object : ValueEventListener{
    override fun onCancelled(p0: DatabaseError) {
    }
            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    val key=p0.key!!
                    val value=p0.value?.toString()?:"anonymous"
                    mutableLiveData.value=Info(key,value)
                }
            }
})
        return mutableLiveData
    }
    fun getNumOfOfflineHealersLiveData(): MutableLiveData<Info> {
        var mutableLiveData: MutableLiveData<Info>?= MutableLiveData()
        if(mutableLiveData==null){
            mutableLiveData= MutableLiveData()
        }

firebasedatabase.reference.child("numOfOfflineHealers").addListenerForSingleValueEvent(object :ValueEventListener{
    override fun onCancelled(error: DatabaseError) {
    }

    override fun onDataChange(snapshot: DataSnapshot) {
        if (snapshot.exists()){
            val key=snapshot.key!!
            val value=snapshot.value?.toString()?:"anonymous"
            mutableLiveData.value=Info(key,value)
        }
    }
})
        return mutableLiveData
    }
    fun getNumOfOnlineUsersLiveData(): MutableLiveData<Info> {
        var mutableLiveData: MutableLiveData<Info>?= MutableLiveData()
        if(mutableLiveData==null){
            mutableLiveData= MutableLiveData()
        }
       // GlobalScope.launch{
           // delay(5000)

           // mutableLiveData.postValue("seventy")
       // }
        firebasedatabase.reference.child("numOfOnlineUsers").addChildEventListener(object : ChildEventListener{
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {

            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                if (snapshot.exists()){
                    val key=snapshot.key!!
                    val value=snapshot.value?.toString()?: "anonymous"
                    mutableLiveData.value= Info(key,value)
                }
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {

            }

            override fun onCancelled(error: DatabaseError) {

            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {

            }

        })
        return mutableLiveData
    }
    fun getNumOfOfflineUsersLiveData(): MutableLiveData<Info> {
        var mutableLiveData: MutableLiveData<Info>?= MutableLiveData()
        if(mutableLiveData==null){
            mutableLiveData= MutableLiveData()
        }
        //GlobalScope.launch{
          //  delay(5000)
            //mutableLiveData.postValue("ninety")
       // }
        firebasedatabase.reference.child("numOfOfflineUsers").addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val key = snapshot.key!!
                    val value = snapshot.value?.toString() ?: "anonymous"
                    mutableLiveData.value = Info(key, value)
                }
            }
        })



        return mutableLiveData
    }
    fun pushToDatabase(){
        firebasedatabase.reference.child("mangs").setValue("hello mangs!")
        firebasedatabase.reference.child("siddhi").setValue("Hey siddhi!!")
    }
}