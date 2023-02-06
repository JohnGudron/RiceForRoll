package com.example.riceforroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.riceforroll.databinding.ActivityCookingInstructionsBinding
import kotlin.math.roundToInt

class CookingInstructions : AppCompatActivity() {

    private lateinit var binding: ActivityCookingInstructionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCookingInstructionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val riceWeight = intent.getIntExtra(RICE_WEIGHT, 500)
        val vinegarConc = intent.getIntExtra(VINEGAR_CONC, 9)
        val waterForRice = (1.1 *  riceWeight).toInt()
        val vinegarForDressing = (waterForRice / 10.0 / (vinegarConc / 4.0)).roundToInt()
        val saltForDressing = (riceWeight.toDouble() / 100).toInt()
        val sugarForDressing = (riceWeight.toDouble() / 100).toInt() * 9
        val waterForDressing = (waterForRice / 10.0 - vinegarForDressing).toInt()
        binding.waterForRice.text = waterForRice.toString() + " мл"
        binding.saltForDressing.text = saltForDressing.toString() + " гр"
        binding.sugarForDressing.text = sugarForDressing.toString() + " гр"
        binding.vinegarForDressing.text = vinegarForDressing.toString() + " мл"
        binding.waterForDressing.text = waterForDressing.toString() + " мл"
    }
}