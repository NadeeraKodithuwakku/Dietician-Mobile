package io.mvpstarter.app.features.home

import io.mvpstarter.app.features.base.MvpView

interface HomeMvpView : MvpView {

    fun showPlans()

    fun showProfile()

    fun showProgress()
}