package com.capgemini.universityapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.capgemini.universityapp.R
import com.capgemini.universityapp.model.Student

class StudentAdapter(val stdList : List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentHolder>() {

    class StudentHolder(v: View) : RecyclerView.ViewHolder(v){

        val nameTextView =v.findViewById<TextView>(R.id.nameT)
        val marksTextView = v.findViewById<TextView>(R.id.markT)
        val rollTextView = v.findViewById<TextView>(R.id.idT)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentAdapter.StudentHolder {
        val v =LayoutInflater.from(parent.context).inflate(R.layout.student_item,parent,false)
        return StudentHolder(v)
    }

    override fun onBindViewHolder(holder: StudentAdapter.StudentHolder, position: Int) {

        val std =stdList[position]

        holder.nameTextView.text ="${std.firstName} ${std.lastName}"
        holder.marksTextView.text="${std.marks}"
        holder.rollTextView.text ="${std.id}"
    }

    override fun getItemCount(): Int {
        return stdList.size
    }
}