package com.example.add_namesavedata
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.add_namesavedata.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: NameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addNameButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            if (name.isNotEmpty()) {
                viewModel.addName(name)
                updateNameTextView()
            } else {
                binding.nameTextView.text = "No names to display"
            }
        }
        if (savedInstanceState != null) {
            val savedNames = savedInstanceState.getStringArrayList("names")
            savedNames?.let {
                updateNameTextView()
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("names", ArrayList<String>(viewModel.getNames().map { it.toString() }))
    }
    private fun updateNameTextView() {
        val names = viewModel.getNames()
        binding.nameTextView.text = "Names:\n$names"
    }
}