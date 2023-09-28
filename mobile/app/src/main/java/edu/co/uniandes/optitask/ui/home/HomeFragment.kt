package edu.co.uniandes.optitask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import edu.co.uniandes.optitask.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var hours = 0
    private var minutes = 0
    private var seconds = 0

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Set click listeners for numbered buttons
        for (i in 0..9) {
            val buttonId = resources.getIdentifier("button_$i", "id", requireActivity().packageName)
            val button = root.findViewById<Button>(buttonId)
            button.setOnClickListener {
                // Handle button click, update hours/minutes/seconds
                when {
                    seconds < 60 -> seconds = seconds * 10 + i
                    minutes < 60 -> {
                        seconds = i
                        minutes = minutes * 10 + i
                    }
                    else -> {
                        seconds = i
                        minutes = i
                        hours = hours * 10 + i
                    }
                }
                updateTimerDisplay()
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateTimerDisplay() {
        val time = String.format("%02d:%02d:%02d", hours, minutes, seconds)
        binding.hourTextView.text = hours.toString()
        binding.minuteTextView.text = minutes.toString()
        binding.secondTextView.text = seconds.toString()
    }
}