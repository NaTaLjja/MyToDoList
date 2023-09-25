package com.example.hw_db


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class TaskViewModel:ViewModel() {
    private val repo = MyApplication.getApp().repo
    private val _listState = MutableLiveData<ListState>(ListState.EmptyList)
    val listState:LiveData<ListState> = _listState
    private val observer = Observer<List<Task>>{
        _listState.postValue(ListState.UpdateList(list = it))
    }

    init{
        repo.getAll().observeForever(observer)
    }

    fun add(titleTask:String, descriptionTask:String){
        repo.add(Task(title = titleTask, description = descriptionTask))
    }

    fun remove(task:Task){
        repo.remove(task)
    }

    override fun onCleared() {
        super.onCleared()
        repo.getAll().removeObserver(observer)
    }

    sealed class ListState{
        object EmptyList:ListState()
        class UpdateList(val list:List<Task>):ListState()
    }
}