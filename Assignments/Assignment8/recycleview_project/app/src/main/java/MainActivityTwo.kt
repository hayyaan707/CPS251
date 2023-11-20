package com.example.recycleview_project
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recycleview_project.databinding.ActivityMainTwoBinding
class MainActivityTwo: AppCompatActivity() {
    private lateinit var binding: ActivityMainTwoBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMainTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val moreView = intent.extras ?: return
        val titles = moreView.getInt("Title", 0)
        val details = moreView.getInt("Detail", 0)
        val images = moreView.getInt("Image", 0)
        binding.imageMessage.text = Data.titles[titles]
        binding.imageDescription.text = Data.details[details]
        binding.imageView.setImageResource(Data.images[images])
    }
}