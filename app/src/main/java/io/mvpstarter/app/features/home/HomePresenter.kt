package io.mvpstarter.app.features.home

import io.mvpstarter.app.data.DataManager
import io.mvpstarter.app.features.base.BasePresenter
import io.mvpstarter.app.injection.ConfigPersistent
import javax.inject.Inject

@ConfigPersistent
class HomePresenter @Inject
constructor(private val dataManager: DataManager): BasePresenter<HomeMvpView>(){

}