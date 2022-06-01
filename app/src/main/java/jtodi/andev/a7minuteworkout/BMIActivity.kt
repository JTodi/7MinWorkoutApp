package jtodi.andev.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import jtodi.andev.a7minuteworkout.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {

    private var binding : ActivityBmiBinding? = null

    companion object{
        private const val METRICS_UNIT_VIEW = "METRICS_UNIT_VIEW"
        private const val US_UNIT_VIEW = "US_UNIT_VIEW"
    }
    private var currentVisibleView = METRICS_UNIT_VIEW

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarBmiActivity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "CALCULATE BMI"

        binding?.toolbarBmiActivity?.setNavigationOnClickListener(){
            onBackPressed()
        }

        makeVisibleMetricUnitsView()

        binding?.rgUnits?.setOnCheckedChangeListener { _, checkedId : Int ->

            if(checkedId == R.id.rbMetricUnits){
                makeVisibleMetricUnitsView()
            }
            else{
                makeVisibleUSUnitsView()
            }
        }

        binding?.btnCalculateUnits?.setOnClickListener(){
            calculateUnits()
        }

    }


    private fun makeVisibleMetricUnitsView(){
        currentVisibleView = METRICS_UNIT_VIEW
        binding?.tilMetricUnitHeight?.visibility = View.VISIBLE
        binding?.tilMetricUnitWeight?.visibility = View.VISIBLE
        binding?.tilMetricUsUnitWeight?.visibility = View.INVISIBLE
        binding?.tilUsUnitHeightFeet?.visibility = View.INVISIBLE
        binding?.tilUsUnitHeightInch?.visibility = View.INVISIBLE

        binding?.etMetricUnitHeight?.text!!.clear()
        binding?.etMetricUnitWeight?.text!!.clear()

        binding?.llDisplayBMIResult?.visibility = View.INVISIBLE
    }

    private fun makeVisibleUSUnitsView(){
        currentVisibleView = US_UNIT_VIEW
        binding?.tilMetricUnitHeight?.visibility = View.INVISIBLE
        binding?.tilMetricUnitWeight?.visibility = View.INVISIBLE
        binding?.tilMetricUsUnitWeight?.visibility = View.VISIBLE
        binding?.tilUsUnitHeightFeet?.visibility = View.VISIBLE
        binding?.tilUsUnitHeightInch?.visibility = View.VISIBLE

        binding?.etMetricUsUnitWeight?.text!!.clear()
        binding?.etUsUnitHeightFeet?.text!!.clear()
        binding?.etUsUnitHeightInch?.text!!.clear()

        binding?.llDisplayBMIResult?.visibility = View.INVISIBLE
    }

    private fun displayBMIResults(bmi : Float){
        var bmiLabel : String
        var bmiDescription : String

        if(bmi.compareTo(15f) <= 0){
            bmiLabel = " Very Severely Underweight"
            bmiDescription = "Oops! You really need to take better care of yourself! Eat more!"
        }
        else if(bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <=0 ){
            bmiLabel = "Severely Underweight"
            bmiDescription = "Oops! You really need to take better care of yourself! Eat more!"
        }
        else if(bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f) <=0 ){
            bmiLabel = " Underweight"
            bmiDescription = "Oops! You really need to take better care of yourself! Eat more!"
        }
        else if(bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0){
            bmiLabel = " Healthy"
            bmiDescription = "You are Perfect!! Keep Maintaining Your physique!!"
        }
        else if(bmi.compareTo(25f) > 0 && bmi.compareTo(30f) <= 0){
            bmiLabel = " OverWeight"
            bmiDescription = "Oops! You really need to take better care of yourself!! Let's WorkOut!"
        }
        else if(bmi.compareTo(30f) > 0 && bmi.compareTo(35f) <= 0){
            bmiLabel = "Obese Class | Moderately Obese"
            bmiDescription = "Oops! You really need to take better care of yourself!! Let's WorkOut!"
        }
        else if(bmi.compareTo(35f) > 0 && bmi.compareTo(40f) <= 0){
            bmiLabel = "Obese Class || Severely Obese"
            bmiDescription = "Oops! You are in very dangerous situation!! Act Now!!"
        }
        else{
            bmiLabel = "Obese Class ||| Very Severely Obese"
            bmiDescription = "Oops! You are in very dangerous situation!! Act Now!!"
        }

        var bmiValue = BigDecimal(bmi.toDouble()).setScale(2,RoundingMode.HALF_EVEN).toString()

        binding?.llDisplayBMIResult?.visibility = View.VISIBLE
        binding?.tvBMIValue?.text = bmiValue
        binding?.tvBMIType?.text = bmiLabel
        binding?.tvBMIDescription?.text = bmiDescription

    }

    private fun calculateUnits(){

        if(currentVisibleView == METRICS_UNIT_VIEW){
            if(validateMetricUnits()){
                val heightValue : Float = binding?.etMetricUnitHeight?.text.toString().toFloat() / 100

                val weightValue : Float = binding?.etMetricUnitWeight?.text.toString().toFloat()

                val bmi : Float = weightValue / (heightValue*heightValue)
                displayBMIResults(bmi)

            }else{
                Toast.makeText(this@BMIActivity,"Enter a valid value!!",Toast.LENGTH_SHORT).show()
            }
        }else{
            if(validateUSUnits()){
                val usUnitWeightValue : Float = binding?.etMetricUsUnitWeight?.text.toString().toFloat()

                val usUnitHeightValueInFeet : String = binding?.etUsUnitHeightFeet?.text.toString()
                val usUnitHeightValueInInch : String = binding?.etUsUnitHeightInch?.text.toString()

                val heightValue : Float = usUnitHeightValueInFeet.toFloat()*12 + usUnitHeightValueInInch.toFloat()

                val bmi = 703 * (usUnitWeightValue / (heightValue*heightValue))

                displayBMIResults(bmi)
            }else{
                Toast.makeText(this@BMIActivity,"Enter a valid value!!",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateMetricUnits() : Boolean{
        var isValid = true

        if(binding?.etMetricUnitWeight?.text.toString().isEmpty()){
            isValid = false
        }
        else if(binding?.etMetricUnitHeight?.text.toString().isEmpty()){
            isValid = false
        }
        return isValid
    }

    private fun validateUSUnits() : Boolean{
        var isValid = true

        if(binding?.etMetricUsUnitWeight?.text.toString().isEmpty()){
            isValid = false
        }
        else if(binding?.etUsUnitHeightFeet?.text.toString().isEmpty()){
            isValid = false
        }
        else if(binding?.etUsUnitHeightInch?.text.toString().isEmpty()){
            isValid = false
        }
        return isValid
    }

}