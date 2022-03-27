package com.myhome.android.guessnumber.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.myhome.android.guessnumber.R
import com.myhome.android.guessnumber.databinding.FragmentChoseLevelBinding
import com.myhome.android.guessnumber.domain.entity.Level


class ChoseLevelFragment : Fragment() {

    private var _binding: FragmentChoseLevelBinding? = null
    private val binding: FragmentChoseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChoseLevelBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChoseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chooseLevel()
    }

    private fun chooseLevel() {
        with(binding) {
            buttonTest.setOnClickListener {
                launchGameFragment(Level.TEST)
            }
            buttonEasy.setOnClickListener {
                launchGameFragment(Level.EASY)
            }
            buttonNormal.setOnClickListener {
                launchGameFragment(Level.NORMAL)
            }
            buttonHard.setOnClickListener {
                launchGameFragment(Level.HARD)
            }
        }
    }

    private fun launchGameFragment(level: Level) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, GameFragment.newInstance(level))
            .addToBackStack(GameFragment.NAME)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        const val NAME = "ChoseLevelFragment"

        fun newInstance(): ChoseLevelFragment {
            return ChoseLevelFragment()
        }
    }
}