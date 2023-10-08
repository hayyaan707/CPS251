package com.example.tip_calculator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tip_calculator.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonCalculate.setOnClickListener {
            calculateTip(0.10, 0.15, 0.20)
        }
    }
    private fun calculateTip(tipPercentage1: Double, tipPercentage2: Double, tipPercentage3: Double) {
        val billAmountStr = binding.editTextBillAmount.text.toString()
        if (billAmountStr.isNotEmpty()) {
            val billAmount = billAmountStr.toDouble()
            val tipAmount1 = billAmount * tipPercentage1
            val tipAmount2 = billAmount * tipPercentage2
            val tipAmount3 = billAmount * tipPercentage3
            binding.textViewTipAmount.text = "The tips are as follows:\n10% = $${String.format("%.2f", tipAmount1)}\n15% = $${String.format("%.2f", tipAmount2)}\n20% = $${String.format("%.2f", tipAmount3)}"
        } else {
            binding.textViewTipAmount.text = "YOU MUST ENTER A BILL AMOUNT"
        }
    }
}