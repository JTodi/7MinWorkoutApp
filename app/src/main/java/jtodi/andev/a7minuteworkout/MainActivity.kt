package jtodi.andev.a7minuteworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import jtodi.andev.a7minuteworkout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

//        val flStartButton : FrameLayout = findViewById(R.id.flStart)



        binding?.flStart?.setOnClickListener(){
            //Toast.makeText(this,"Start Clicked",Toast.LENGTH_SHORT).show()

            val intent = Intent(this,ExerciseActivity::class.java)
            startActivity(intent)

        }

        binding?.btnBmi?.setOnClickListener(){
            val intent = Intent(this,BMIActivity::class.java)
            startActivity(intent)
        }

        binding?.btnHistory?.setOnClickListener(){
            val intent = Intent(this,HistoryActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null
    }//clean way to assign null to binding to avoid memory leak
}