package com.mobile.ecomapp.di

import android.app.Application
import com.mobile.ecomapp.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (ActivityModule::class), (ViewModelModule::class)])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build():AppComponent
    }
    fun inject(instance: App)
}