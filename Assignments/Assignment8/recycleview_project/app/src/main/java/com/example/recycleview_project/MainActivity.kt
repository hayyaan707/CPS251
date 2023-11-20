package com.example.recycleview_project
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleview_project.databinding.ActivityMainBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        layoutManager = LinearLayoutManager(this)
        adapter =
            RecyclerAdapter(viewModel.getTitles(), viewModel.getDetails(), viewModel.getImages())
        binding.contentMain.recyclerView.layoutManager = layoutManager
        binding.contentMain.recyclerView.adapter = adapter
    }
}