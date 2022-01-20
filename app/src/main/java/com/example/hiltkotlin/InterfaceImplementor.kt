package com.example.hiltkotlin

import javax.inject.Inject

class InterfaceImplementor @Inject constructor(): MyInterface {
    override fun myPrintFunction(): String {
        return "My InterfaceImplementor"
    }


}