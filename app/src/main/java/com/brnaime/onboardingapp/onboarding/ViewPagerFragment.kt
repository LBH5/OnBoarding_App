package com.brnaime.onboardingapp.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brnaime.onboardingapp.R
import com.brnaime.onboardingapp.databinding.FragmentViewPagerBinding
import com.brnaime.onboardingapp.onboarding.screens.FirstScreen
import com.brnaime.onboardingapp.onboarding.screens.SecondScreen
import com.brnaime.onboardingapp.onboarding.screens.ThirdScreen


class ViewPagerFragment : Fragment() {


    private lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)

        val fragmentList = arrayListOf(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )
        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter

        return binding.root
    }

}