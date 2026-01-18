package com.brnaime.onboardingapp

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.brnaime.onboardingapp.onboarding.screens.ThirdScreen

class SplashFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler.createAsync(Looper.getMainLooper()).postDelayed({
            if(onBoardingFinished()){
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            } else{
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }
        },2500)
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun onBoardingFinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences(ThirdScreen.ON_BOARDING_PREF_FILENAME, MODE_PRIVATE)
        return sharedPref.getBoolean(ThirdScreen.ON_BOARDING_PREF_KEY, false)
    }


}