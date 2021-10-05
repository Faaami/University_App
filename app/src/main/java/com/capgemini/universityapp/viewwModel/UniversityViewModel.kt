package com.capgemini.universityapp.viewwModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.capgemini.universityapp.model.StudentRepoVM
import com.capgemini.universityapp.model.University
import kotlinx.coroutines.launch

class UniversityViewModel(app : Application):AndroidViewModel(app) {

    val univ = University("IIT Roorkee","Roorkee","http://www.iitr.in")

    val noOfStudents = MutableLiveData<Int>()

    val repo = StudentRepoVM(app)


    fun updateCount(){
        //val num = (Math.random() * 1000).toInt()
        viewModelScope.launch {
           val num = repo.getAllStudents().size
            noOfStudents.postValue(num)
        }

    }
}