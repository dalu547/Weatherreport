
#Android Task - Weather Report App

## Requirements
A simple mobile application that:

* Utilize a weather API (http://openweathermap.org/API) and get the forecast based on City
  [Note: Now city is hardcode in AppConstants.kt file]
* The WeatherInfo activity will have the below forecast information
     City name
     Temperature
     Minimum Temperature
     Maximum Temperature
     Weather type      

## API Key
API keys is very secure data we can not publish it
- `Open Weathermap`, you can change Open Weathermap key from \gradle.properties

 ###### **Technologies uses in it.**
 * Kotlin
 * MVVM Design Pattern with Clean architecture
 * Dagger
 * LiveData
 * Retrofit
 * RxJava

 ## **Third party libs uses in it.**
 *Glide

I would like to have completed
 * Base components (Like BaseActivity,BaseViewModel,BaseRepository...)
   [We have only one Activity so i didn't add that]
 
Note: Added one testcase in unit-testing part to verify whether API is working or not. 


