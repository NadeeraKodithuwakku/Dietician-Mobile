package io.mvpstarter.app.features.plan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import io.mvpstarter.app.R
import javax.inject.Inject

class DietPlanAdapter @Inject
constructor(): RecyclerView.Adapter<DietPlanAdapter.DietPlanViewHolder>(){

    private var planItemList: List<String> = emptyList()
    private  var clickListener: ClickListener? = null


    fun setPlanItem(planItems:List<String>){
        planItemList = planItems
    }

    fun setClickListener(clickListener: ClickListener){
        this.clickListener = clickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DietPlanViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.plan_item, parent, false)
        return DietPlanViewHolder(view)
    }

    override fun onBindViewHolder(holder: DietPlanViewHolder, position: Int) {
        val planItem = planItemList[position]
        holder.bind(planItem)
    }

    override fun getItemCount(): Int {
        return planItemList.size
    }


    interface ClickListener {
        fun onPlanItemClick(planItem: String)
    }


    inner class DietPlanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var selectedItem: String

        @BindView(R.id.item_name)
        @JvmField var itemName: TextView? = null

        init {
            ButterKnife.bind(this, itemView)
            itemView.setOnClickListener {
                clickListener?.onPlanItemClick(selectedItem)
            }
        }

        fun bind(planItem: String) {
            selectedItem = planItem
            itemName?.text = planItem
        }
    }
}