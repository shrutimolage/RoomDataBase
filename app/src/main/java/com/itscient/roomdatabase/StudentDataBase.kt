package com.itscient.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Student::class], version = 2)
@TypeConverters(Convertor::class)
abstract class StudentDataBase : RoomDatabase() {
    abstract fun studentDao(): StudentNewDAO

    companion object {


        @Volatile
        private var INSTANCE: StudentDataBase? = null


        fun getDatabase(context: Context): StudentDataBase{
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        StudentDataBase::class.java,
                        "studentDB"
                    )
                        .build()
                }
            }

            return INSTANCE!!
        }
    }

}



