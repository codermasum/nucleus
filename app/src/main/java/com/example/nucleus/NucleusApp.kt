package com.example.nucleus

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class NucleusApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        // Initialize Dependency Injection
        DaggerAppComponent.builder()
            .create(this)
            .build()
            .inject(this)

//        // Get UI mode and set
//        val mode = if (isNight()) {
//            AppCompatDelegate.MODE_NIGHT_YES
//        } else {
//            AppCompatDelegate.MODE_NIGHT_NO
//        }

       // AppCompatDelegate.setDefaultNightMode(mode)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}