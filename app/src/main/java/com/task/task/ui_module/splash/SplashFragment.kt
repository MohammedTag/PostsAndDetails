package com.task.task.ui_module.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.task.task.R
import com.task.task.databinding.FragmentPostsListingBinding
import com.task.task.databinding.FragmentSplashBinding
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * A simple Splash Fragment .
 * In another case , splash fragment should be part of a Sign-in/sign-up navigation graph,
 * in order to do any initialChecks or getting specific parts up and running
 *
 * for demo purpose only it is placed inside app content nav graph
 */
class SplashFragment : DaggerFragment() {


    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSplashBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            lifecycleScope.launch {
                delay(2000L)
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToPostsListingFragment())
            }
    }
}