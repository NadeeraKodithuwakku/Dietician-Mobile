package io.mvpstarter.app.common.injection.component

import dagger.Component
import io.mvpstarter.app.common.injection.module.ApplicationTestModule
import io.mvpstarter.app.injection.component.AppComponent
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationTestModule::class))
interface TestComponent : AppComponent