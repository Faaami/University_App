package com.capgemini.universityapp.model

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class StudentRepoVM(val ctx: Context) {

    private val db = StudentDatabase.getInstance(ctx)
    private val dao = db.getStudentDa()

    suspend fun addStudent(std : Student) = dao.addStudent(std)

    suspend fun deleteStd(std : Student) = dao.deleteStudent(std)

    suspend fun deleteAllStudents() = dao.deleteAll()

    suspend fun updateStudents(std: Student) = dao.updateStudent(std)

    suspend fun getAllStudents() : List<Student> {

        //launch --first and forget
        //async --wait for result

        val defferedResult  = CoroutineScope(Dispatchers.Default).async {
            dao.getStudents()
        }
        return defferedResult.await()
    }
}