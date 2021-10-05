package com.capgemini.universityapp.model

import androidx.room.*


@Dao
interface StudentDAO {

    //method for performing SQL operations

    @Insert
    suspend fun addStudent(std : Student)

    @Update
    suspend fun updateStudent(std: Student)

    @Delete
   suspend fun deleteStudent(std : Student)

    @Query("delete from students")
    suspend fun deleteAll()

    @Query("select * from students order by marks desc")
   suspend fun getStudents() : List<Student>
}