package io.mvpstarter.app.features.plan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import io.mvpstarter.app.R
import io.mvpstarter.app.features.base.BaseFragment
import io.mvpstarter.app.features.plan.DietPlanAdapter.ClickListener
import kotlinx.android.synthetic.main.fragment_plan.*
import javax.inject.Inject


class DietPlanFragment @Inject
    constructor(): BaseFragment(),DietPlanMvpView, ClickListener{

    @Inject lateinit var dietPlanPresenter: DietPlanPresenter

    @Inject lateinit var dietPlanAdapter: DietPlanAdapter


    private val plans = listOf(
            "Plan A",
            "Plan B",
            "Plan C",
            "Plan D",
            "Plan E",
            "Plan F"
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentComponent().inject(this)
        dietPlanPresenter.attachView(this)


//        swipeToRefresh?.apply {
//            setProgressBackgroundColorSchemeResource(R.color.primary)
//            setColorSchemeResources(R.color.white)
//        }

        dietPlanAdapter.setClickListener(this)
//        plan_list_recycler_view?.apply {
//            layoutManager = LinearLayoutManager(context)
//            adapter = dietPlanAdapter
//        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dietPlanAdapter.setPlanItem(plans)
        plan_list_recycler_view?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dietPlanAdapter
        }
    }

    override fun layoutId() = R.layout.fragment_plan

    override fun addPlan() {
        //diet plan + button click event
    }

    override fun onPlanItemClick(planItem: String) {
        //load diet menu screen of the clicked plan item
    }

}