package jtodi.andev.a7minuteworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import jtodi.andev.a7minuteworkout.databinding.ActivityFinishBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class activity_finish : AppCompatActivity() {

    private var binding : ActivityFinishBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarFinishActivity)

        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }//this sets the back button in our tool bar

        binding?.toolbarFinishActivity?.setNavigationOnClickListener(){        //this on clicking helps in navigation between layouts
            onBackPressed()//this shifts the control to previous activity
        }

        binding?.btnFinish?.setOnClickListener(){

//            val intent = Intent(this@activity_finish,MainActivity::class.java)
//            startActivity(intent)
            // as we don't finish our exercise activity and main activity due to back button so above method is not suggested as it will create a stack of intents which will crash app in some time so instead use finish()
            finish()
        }

        val dao = (application as WorkOutApp).db.historyDao()
        addDateToDatabase(dao)
    }

    private fun addDateToDatabase(historyDao: HistoryDao){

        val c = Calendar.getInstance()
        val dateTime = c.time
        Log.e("DateTime","" + dateTime)

        val sdf = SimpleDateFormat("dd MMM yyyy HH:mm:ss",Locale.getDefault())
        val date = sdf.format(dateTime)

        lifecycleScope.launch {
            historyDao.insert(HistoryEntity(date))
            Log.e("Date:  ","Added....")
        }
    }
}