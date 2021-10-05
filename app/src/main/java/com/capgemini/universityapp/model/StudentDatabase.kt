package com.capgemini.universityapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Student::class], version = 1)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun getStudentDa() : StudentDAO

    companion object{

        private var instance : StudentDatabase? = null

        fun getInstance(context: Context) : StudentDatabase {
            if(instance == null){
                //create instance

                instance = createDatabase(context)
            }

            return instance !!
        }

        private fun createDatabase(context : Context): StudentDatabase? {
           val builder =  Room.databaseBuilder(context, StudentDatabase::class.java, "university.db")

            return builder.build()
        }
    }
}