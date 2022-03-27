package com.myhome.android.guessnumber.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.myhome.android.guessnumber.databinding.FragmentChoseLevelBinding

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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}