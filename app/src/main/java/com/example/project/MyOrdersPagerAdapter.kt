package com.example.project
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyOrdersPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ToPayFragment()
            1 -> ToShipFragment()
            2 -> ToReceiveFragment()
            3 -> ToReviewFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}
