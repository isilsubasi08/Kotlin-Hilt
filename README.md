# Kotlin-Hilt

![hilt](https://github.com/isilay-subasi/Kotlin-Hilt/blob/main/images/hilt.png)

## Hilt ile Dependency Injection 

<b>Dependency Injection(DI)</b>, programlamada yaygın olarak kullanılan ve bir sınıfın bağlı olduğu nesnelerin bağımlılıklarının sağlandığı bir design patterndir ve Android uygulama geliştirmede sıklıkla kullanılır. 

DI ilkelerini takip ederek ;
+ test edilebilir
+  okunabilir
+   kolaylıkla yeni özellikler eklenebilir ve iyi bir mimari altyapıya sahip uygulamalar çıkarılabilir.

  > Android uygulama geliştirirken oluşturulan classlar birçok bağımlılığa sahip olabilir. Bu bağımlılıkları azaltmak için bir DI frameworküne ihtiyaç vardır. Genellikle ilk akla gelen Google’ın geliştirmiş olduğu <b>Dagger frameworküdür. </b> Son zamanlarda geliştiricilerin  Dagger alternatiflerine yöneldikleri görülmektedir. Tam bu esnada Google Android ekibi, Jetpack içerisine daha kolay kullanıma sahip ve Dagger üstüne inşa edilen <b>Hilt kütüphanesini</b> bizlere sundu.

  ## Hilt

  <p>Hilt, Jetpack içerisine dahil edilen ve Android uygulamalarda DI için kullanılması önerilen ve Dagger üzerine inşa edilen bir kütüphanedir</p>

  ## Hilt Kullanımı

  Önce proje düzeyindeki `build.gradle` dosyanızı açın ve dependecies bloğunun içine ekleyin.

```
 def hilt_version = "2.28-alpha"
 classpath "com.android.tools.build:gradle:7.0.4"
 classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20"
 classpath "com.google.dagger:hilt-android-gradle-plugin:$hilt_version"
```

 Plugin kısmına da aşağıdaki id ekleyelim.
```
  id 'dagger.hilt.android.plugin'
 ``` 
 app gradle 
```
    // DAGGER HILT
    implementation "com.google.dagger:hilt-android:2.35.1"
    kapt "com.google.dagger:hilt-compiler:2.35.1"

    // RETROFIT
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"
    implementation "com.squareup.retrofit2:adapter-rxjava3:2.9.0"
    implementation "com.squareup.okhttp3:logging-interceptor:4.9.0"

    // RX JAVA
    implementation "io.reactivex.rxjava3:rxandroid:3.0.0"
 ```

 ## Hilt Örnek Kullanımı

 1.Öncelikle Hilt'in kod oluşturmasını tetiklemek için `@HiltAndroidApp` annotation'unu ekleyelim.
```
 @HiltAndroidApp
class MyApplication : Application() {
}
```

2.Manifeste gidip Applicationı eklemem gerekiyor.
```
    <application
        android:name=".MyApplication"
```

3.`@AndroidEntryPoint` , nerde kullanacaksam onun başında bunu eklemem gerekiyor.
```
//Giriş noktası, burda enjeksiyonlar yapılacak
@AndroidEntryPoint
class MainActivity : AppCompatActivity() 
```

