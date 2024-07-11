package com.itscient.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentNewDAO {

    @Insert
  fun insertStudent(student: Student)

    @Query("SELECT * FROM student")
    fun getAllStudent(): LiveData<List<Student>>
}