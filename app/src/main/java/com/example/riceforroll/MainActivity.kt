package com.example.riceforroll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.riceforroll.databinding.ActivityMainBinding

const val RICE_WEIGHT = "com.example.riceforroll.RICE_WEIGHT"
const val VINEGAR_CONC = "com.example.riceforroll.VINEGAR_CONC"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var riceWeight = 0
    private var vinegarConcentration = 0

    fun calculate (view: View) {
        riceWeight = binding.riceAmountEditText.text.toString().toIntOrNull() ?: 500
        vinegarConcentration = binding.vinegarPercentEditText.text.toString().toIntOrNull() ?: 9
        val intent = Intent(this, CookingInstructions::class.java).apply {
            putExtra(RICE_WEIGHT, riceWeight)
            putExtra(VINEGAR_CONC, vinegarConcentration)
        }
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }




}