package io.mvpstarter.app.features.home

import android.os.Bundle
import dagger.Provides
import io.mvpstarter.app.R
import io.mvpstarter.app.features.base.BaseActivity
import io.mvpstarter.app.features.common.ErrorView
import io.mvpstarter.app.features.plan.DietPlanAdapter
import io.mvpstarter.app.features.plan.DietPlanFragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.main_toolbar
import kotlinx.android.synthetic.main.activity_home.swipeToRefresh
import javax.inject.Inject

class HomeActivity : BaseActivity(), ErrorView.ErrorListener, HomeFragment.ClickListener {
    @Inject
    lateinit var homeFragment: HomeFragment
    @Inject
    lateinit var dietPlanFragment: DietPlanFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent().inject(this)

        setSupportActionBar(main_toolbar)
        swipeToRefresh?.apply {
            setProgressBackgroundColorSchemeResource(R.color.primary)
            setColorSchemeResources(R.color.white)
        }




        viewHomeError?.setErrorListener(this)

        val fm = supportFragmentManager
        var fragment = fm.findFragmentById(R.id.container)

        // ensures fragments already created will not be created
        if (fragment == null) {
            fragment = homeFragment

            homeFragment.setLister(this)
            // create and commit a fragment transaction
            fm.beginTransaction()
                    .add(R.id.container, fragment)
                    .commit()
        }
    }

    override fun layoutId() = R.layout.activity_home

    override fun onReloadData() {
        // mainPresenter.getPokemon(POKEMON_COUNT)
    }

    override fun viewPlansClicked() {
        val fm = supportFragmentManager
        // create and commit a fragment transaction
        fm.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, dietPlanFragment)
                .commit()
    }

    override fun viewProfileClicked() {
        //load profile fragment
    }

    override fun viewProgressClicked() {
        //load progress fragment
    }


}