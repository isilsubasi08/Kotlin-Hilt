package com.example.hiltkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//Giriş noktası, burda enjeksiyonlar yapılacak
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //Field Injection
    @Inject
    lateinit var lars : Musician

    @Inject
    lateinit var myClass : ClassExample


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*

        val instrument = Instrument()
        val band = Band()
        var james = Musician(instrument,band)
        james.sing()
         */

        lars.sing()


        myClass.myFunction()
        myClass.secondFunction()



    }
}