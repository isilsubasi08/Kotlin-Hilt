package com.example.hiltkotlin

import com.google.gson.Gson
import javax.inject.Inject

class ClassExample
@Inject constructor(@FirstImplementor private val myInterfaceImplementor : MyInterface,
                    @SecondImplementor private val mySecondInterfaceImplementor: MyInterface,
                    private val gson: Gson)
{


    fun myFunction() : String{

        return "Working: ${myInterfaceImplementor.myPrintFunction()}"
    }

    fun secondFunction() : String{

        return "Working : ${mySecondInterfaceImplementor.myPrintFunction()}"
    }
}