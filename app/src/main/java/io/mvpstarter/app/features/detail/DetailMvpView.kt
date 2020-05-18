package io.mvpstarter.app.features.detail

import io.mvpstarter.app.data.model.Pokemon
import io.mvpstarter.app.data.model.Statistic
import io.mvpstarter.app.features.base.MvpView

interface DetailMvpView : MvpView {

    fun showPokemon(pokemon: Pokemon)

    fun showStat(statistic: Statistic)

    fun showProgress(show: Boolean)

    fun showError(error: Throwable)

}