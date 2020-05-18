package io.mvpstarter.app.injection.component

import android.app.Application
import android.content.Context
import dagger.Component
import io.mvpstarter.app.data.DataManager
import io.mvpstarter.app.data.remote.PokemonApi
import io.mvpstarter.app.injection.ApplicationContext
import io.mvpstarter.app.injection.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun dataManager(): DataManager

    fun pokemonApi(): PokemonApi
}
