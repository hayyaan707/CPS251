package com.example.lifecycleaware
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import android.content.res.Configuration
import android.widget.TextView
public class MyActivity : AppCompatActivity() {
    private lateinit var viewModel: MyViewModel
    private lateinit var textViewLifecycleInfo: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        textViewLifecycleInfo = findViewById(R.id.text_view_lifecycle_info)
        viewModel.lifecycleInfo.observe(this, Observer { info ->
            textViewLifecycleInfo.text = info
        })
        displayLifecycleInfo("onCreate")
    }
    override fun onStart() {
        super.onStart()
        displayLifecycleInfo("onStart")
    }
    override fun onResume() {
        super.onResume()
        displayLifecycleInfo("onResume")
    }
    override fun onPause() {
        super.onPause()
        displayLifecycleInfo("onPause")
    }
    override fun onStop() {
        super.onStop()
        displayLifecycleInfo("onStop")
    }
    private fun displayLifecycleInfo(lifecycleEvent: String) {
        val currentTime = System.currentTimeMillis()
        val info = "$lifecycleEvent was fired on ${formatTime(currentTime)}."
        viewModel.updateLifecycleInfo(info)
    }
    private fun formatTime(timeMillis: Long): String {
        val formatter = java.text.SimpleDateFormat("HH:mm:ss.SSS")
        return formatter.format(timeMillis)
    }
}
class MyViewModel : ViewModel() {
    private val _lifecycleInfo = MutableLiveData<String>()
    val lifecycleInfo: LiveData<String> = _lifecycleInfo
    fun updateLifecycleInfo(info: String) {
        _lifecycleInfo.value = info
    }
}