package io.mvpstarter.app.features.plan

import io.mvpstarter.app.data.DataManager
import io.mvpstarter.app.features.base.BasePresenter
import io.mvpstarter.app.injection.ConfigPersistent
import javax.inject.Inject

@ConfigPersistent
class DietPlanPresenter @Inject
constructor(private val dataManager: DataManager): BasePresenter<DietPlanMvpView>(){}