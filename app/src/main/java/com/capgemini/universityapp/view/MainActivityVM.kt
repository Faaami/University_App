package com.capgemini.universityapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capgemini.universityapp.R
import com.capgemini.universityapp.viewwModel.StudentViewModel

class MainActivityVM : AppCompatActivity() {


    lateinit var rView : RecyclerView
    var studentAdapter: StudentAdapter?=null
    lateinit var vModel :   StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rView = findViewById(R.id.studentL)
        rView.layoutManager = LinearLayoutManager(this)

        //DO NOT DO THIS
       // vModel = StudentViewModel(application)

        vModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(StudentViewModel::class.java)
       // loadlist()

        //setup observer on the mutablelive data

        vModel.studentList.observe(this, Observer {

            Log.d("MainActivity","list updated $it")
            studentAdapter = StudentAdapter(it)
            rView.adapter = studentAdapter
        })

    registerForContextMenu(rView)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {super.onCreateContextMenu(menu, v, menuInfo)

        val i = menuInfo as AdapterView.AdapterContextMenuInfo

        //menu?.setHeaderTitle(name)
        menu?.add("Update")
        menu?.add("delete")

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menu?.add("Add Student")
        menu?.add("Delete All")
        menu?.add("About Us")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.title){
            "Add Student" ->{

                val i = Intent(this,AddStudentActivity::class.java)
                startActivity(i)



            }
            "Delete All" ->{

                vModel.deleteAll()
               // loadlist()

            }
            "About Us" ->{

                val i = Intent(this,AboutUsActivity::class.java)
                startActivity(i)

            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        vModel.updateList()
        //loadlist()
    }

//    fun loadlist(){
//
//       // vModel.updateList()
//        studentAdapter = StudentAdapter(vModel.studentList)
//        rView.adapter = studentAdapter
//    }
}