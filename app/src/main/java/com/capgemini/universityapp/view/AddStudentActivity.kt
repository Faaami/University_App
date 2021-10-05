package com.capgemini.universityapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.capgemini.universityapp.R
import com.capgemini.universityapp.viewwModel.StudentViewModel
import com.capgemini.universityapp.model.Student

class AddStudentActivity : AppCompatActivity() {
    lateinit var vModel: StudentViewModel
    lateinit var firstNameEditText: EditText
    lateinit var lastNameEditText: EditText
    lateinit var marksEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        firstNameEditText=findViewById(R.id.firstA)
        lastNameEditText=findViewById(R.id.lastA)
        marksEditText=findViewById(R.id.marksA)

        vModel =ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(StudentViewModel::class.java)

    }

    fun buttonClick(view: android.view.View) {
        val fname= firstNameEditText.text.toString()
        val lname= lastNameEditText.text.toString()
        val mark= marksEditText.text.toString()

        if(firstNameEditText.toString().isNotEmpty() && lastNameEditText.toString().isNotEmpty() && marksEditText.toString().isNotEmpty()){
            vModel.addStudent(Student(fname,lname,mark.toInt()))
        }
        else{
            Toast.makeText(this,"Please enter all details",Toast.LENGTH_LONG).show()
        }
        finish()
    }
}