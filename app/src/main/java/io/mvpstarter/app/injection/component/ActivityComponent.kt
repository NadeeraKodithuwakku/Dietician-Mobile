package io.mvpstarter.app.injection.component

import io.mvpstarter.app.injection.PerActivity
import io.mvpstarter.app.injection.module.ActivityModule
import io.mvpstarter.app.features.base.BaseActivity
import io.mvpstarter.app.features.detail.DetailActivity
import io.mvpstarter.app.features.main.MainActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(baseActivity: BaseActivity)

    fun inject(mainActivity: MainActivity)

    fun inject(detailActivity: DetailActivity)
}
