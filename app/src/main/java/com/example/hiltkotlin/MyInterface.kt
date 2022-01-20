package com.example.hiltkotlin

import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier
import javax.inject.Singleton

interface MyInterface {

    fun myPrintFunction() : String
}

/*
//InstallIn modüllere koymamız gerekiyor.Burdada scope belirtebiliyoruz.Application seviyesinde çağırılacağını söyleyebiliyoruz.
//ApplicationComponent yaparsak diğer tarafıda Singleton yapmamız lazım.

@InstallIn(ApplicationComponent::class)
@Module
abstract class MyModule(){
      @Singleton
      @Binds
      abstract fun bindingFunction(myImplementor: InterfaceImplementor ) : MyInterface


}
 */

@InstallIn(ApplicationComponent::class)
@Module
class myClass(){

    @FirstImplementor
    @Singleton
    @Provides
    fun providerFunction() : MyInterface{

        return InterfaceImplementor()
    }

    //Interface döndüreceğimizi söylüyoruz.
    //Interface uygulayan bir sınıf döndüreceğiniz söylüyoruz. InterfaceImplementor sınıfından bir nesne.


    @Singleton
    @Provides
    fun gsonProvides() : Gson{
        return Gson()
    }

    @SecondImplementor
    @Singleton
    @Provides
    fun secondProviderFunction() : MyInterface{
        return SecondInterfaceImplementor()
    }

}


//Kendi annotationumuzu oluşturuyoruz.
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FirstImplementor


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SecondImplementor
