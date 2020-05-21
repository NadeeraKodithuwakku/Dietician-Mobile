package io.mvpstarter.app.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.mvpstarter.app.R
import io.mvpstarter.app.features.base.BaseFragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment @Inject
    constructor(): BaseFragment(), HomeMvpView{
    @Inject
    lateinit var homePresenter: HomePresenter

    lateinit var clickListener: ClickListener;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentComponent().inject(this)
        homePresenter.attachView(this)
        swipeToRefresh?.apply {
            setProgressBackgroundColorSchemeResource(R.color.primary)
            setColorSchemeResources(R.color.white)
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        diet_plan_btn.setOnClickListener { this.showPlans() }
        health_profile_btn.setOnClickListener { this.showProfile() }
        progress_btn.setOnClickListener { this.showProgress() }
    }

    public fun setLister(listener: ClickListener){
        clickListener = listener;
    }

    override fun layoutId() = R.layout.fragment_home

    override fun onDestroy() {
        super.onDestroy()
        homePresenter.detachView()
    }

    override fun showPlans() {
        clickListener.viewPlansClicked()
    }

    override fun showProfile() {
        clickListener.viewProfileClicked()
    }

    override fun showProgress() {
        clickListener.viewProgressClicked()
    }

    interface ClickListener {
        fun viewPlansClicked()
        fun viewProfileClicked()
        fun viewProgressClicked()
    }
}