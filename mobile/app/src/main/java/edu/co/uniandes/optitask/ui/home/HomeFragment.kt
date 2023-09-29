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

    private var timeInput = ""
    private val maxInputLength = 6 // HH:MM:SS

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
                handleButtonClick(i)
            }
        }

        // Set click listener for delete button
        val deleteButton = binding.deleteButton
        deleteButton.setOnClickListener {
            handleDeleteButtonClick()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun handleButtonClick(digit: Int) {
        if (timeInput.length < maxInputLength) {
            timeInput += digit
        }
        updateTimerDisplay()
    }

    private fun handleDeleteButtonClick() {
        if (timeInput.isNotEmpty()) {
            timeInput = timeInput.substring(0, timeInput.length - 1)
        }
        updateTimerDisplay()
    }

    private fun updateTimerDisplay() {
        val formattedTime = formatTime(timeInput)
        binding.hourTextView.text = formattedTime.substring(0, 2)
        binding.minuteTextView.text = formattedTime.substring(3, 5)
        binding.secondTextView.text = formattedTime.substring(6, 8)
    }

    private fun formatTime(input: String): String {
        val paddedInput = input.padStart(maxInputLength, '0') // Pad with leading zeros if needed
        return "${paddedInput.substring(0, 2)}:${paddedInput.substring(2, 4)}:${paddedInput.substring(4, 6)}"
    }
}