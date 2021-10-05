package com.capgemini.universityapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.capgemini.universityapp.R
import com.capgemini.universityapp.viewwModel.UniversityViewModel
import com.capgemini.universityapp.databinding.ActivityAboutUsBinding

class AboutUsActivity : AppCompatActivity() {

//    lateinit var nameTextView : TextView
//    lateinit var cityTextView: TextView
//    lateinit var webTextView: TextView
    lateinit var countTextView: TextView

    var univModel : UniversityViewModel? =null

    lateinit var binding :ActivityAboutUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_about_us)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_about_us)



//        nameTextView =findViewById(R.id.nameUT)
//        cityTextView = findViewById(R.id.cityT)
//        webTextView = findViewById(R.id.webT)
        countTextView = findViewById(R.id.count)

        univModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(UniversityViewModel::class.java)

       // binding.myUniv = univModel.univ

        binding.uModel=univModel
        binding.lifecycleOwner = this
       // binding.myUniv = University("KTU","Trivandrum","www.ktu.edu.in")

//        nameTextView.text =univModel.univ.name
//        cityTextView.text =univModel.univ.city
//        webTextView.text=univModel.univ.website

//        univModel.noOfStudents.observe(this, Observer {
//            Log.d("AboutUs","Changed Count : $it")
//            countTextView.text = "$it"
//        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menu?.add("Show")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        univModel?.updateCount()
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        univModel?.updateCount()
    }
}