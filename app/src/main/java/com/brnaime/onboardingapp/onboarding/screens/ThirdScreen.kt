package com.brnaime.onboardingapp.onboarding.screens

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.navigation.fragment.findNavController
import com.brnaime.onboardingapp.R
import com.brnaime.onboardingapp.databinding.FragmentThirdScreenBinding


class ThirdScreen : Fragment() {

    private lateinit var binding: FragmentThirdScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdScreenBinding.inflate(inflater,container,false)
        binding.buttonGetStarted.setOnClickListener {
            handleGetStartedBtnClick()
        }
        return binding.root
    }

    private fun handleGetStartedBtnClick() {
        findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
        onBoardingFinished()
    }

    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences(ON_BOARDING_PREF_FILENAME, MODE_PRIVATE)
        sharedPref.edit {
            putBoolean(ON_BOARDING_PREF_KEY, true)
        }
    }

    companion object {
        const val ON_BOARDING_PREF_FILENAME = "onBoarding"
        const val ON_BOARDING_PREF_KEY = "Finished"
    }

}