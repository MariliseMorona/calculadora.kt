package com.example.calculadorakt.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.calculadorakt.R
import com.example.calculadorakt.view.AdRegistrationFragment
import com.example.calculadorakt.view.CalculatorFragment

private val TAB_TITLES = arrayOf(
    R.string.tab1_title,
    R.string.tab2_title
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> CalculatorFragment()
            1 -> AdRegistrationFragment()
            else -> CalculatorFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
       return 2
    }
}