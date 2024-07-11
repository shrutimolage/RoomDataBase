package com.itscient.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {


    private lateinit var database: StudentDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = StudentDataBase.getDatabase(this)

        GlobalScope.launch {
            database.studentDao().insertStudent(Student(0, "Shruti", 20, Date(), 1))
        }

        database.studentDao().getAllStudent().observe(this, {
            Log.d("ROOMDB", "onCreate: $it")
        })



    }





}

