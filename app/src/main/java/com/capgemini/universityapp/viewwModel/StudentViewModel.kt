package com.capgemini.universityapp.viewwModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.capgemini.universityapp.model.Student
import com.capgemini.universityapp.model.StudentRepoVM
import kotlinx.coroutines.launch

class StudentViewModel (app : Application): AndroidViewModel(app){

    private val repo = StudentRepoVM(app)
    var studentList = MutableLiveData<MutableList<Student>>()
        //mutableListOf<Student>()

    init{
        updateList()
    }

    fun addStudent(std: Student){
        viewModelScope.launch {
        repo.addStudent(std)
            updateList()
    }}

    fun deleteStudent(std: Student){
        viewModelScope.launch {
        repo.deleteStd(std)
            updateList()
    }}

    fun updateStudent(std : Student) {
        viewModelScope.launch {
            repo.updateStudents(std)
            updateList()
        }
    }
    fun deleteAll(){
        viewModelScope.launch {
        repo.deleteAllStudents()
            updateList()
    }}

    fun updateList(){

        viewModelScope.launch {
            val list = repo.getAllStudents().toMutableList()
            Log.d("StudentViewModel","List : $list")
            /*
            To change value of mutableliveData

            setVlue() -> doing in main thread
            postValue() -> background thread
             */

            studentList.postValue(list)

        }
    }


}