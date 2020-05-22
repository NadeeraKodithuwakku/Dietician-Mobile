package io.mvpstarter.app.injection.component

import io.mvpstarter.app.injection.PerFragment
import io.mvpstarter.app.injection.module.FragmentModule
import dagger.Subcomponent
import io.mvpstarter.app.features.base.BaseFragment
import io.mvpstarter.app.features.home.HomeFragment
import io.mvpstarter.app.features.plan.DietPlanFragment

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent{
    fun inject(baseFragment: BaseFragment)
    fun inject(homeFragment: HomeFragment)
    fun inject(dietPlanFragment: DietPlanFragment)
}