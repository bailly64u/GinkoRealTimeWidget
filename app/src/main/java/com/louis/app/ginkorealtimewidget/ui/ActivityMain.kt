package com.louis.app.ginkorealtimewidget.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.louis.app.ginkorealtimewidget.databinding.ActivityMain2Binding
import com.louis.app.ginkorealtimewidget.model.Line
import com.louis.app.ginkorealtimewidget.util.L
import com.louis.app.ginkorealtimewidget.viewmodel.PathViewModel
import com.louis.app.ginkorealtimewidget.viewmodel.PathViewModelFactory

class ActivityMain : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    private val viewModelFactory = PathViewModelFactory()
    /*private val viewModel: PathViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(PathViewModel::class.java)
    }*/
    private lateinit var pathViewModel: PathViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)

        pathViewModel = ViewModelProvider(this).get(PathViewModel::class.java)

        setListeners()
        observe()
    }

    private fun observe() {
        pathViewModel.currentLine.observe(this, Observer {
            Toast.makeText(this, "Trajet de la ligne ${it.publicWayInfo}", Toast.LENGTH_LONG).show()
        })

        pathViewModel.isFetchingData.observe(this, Observer {
            L.v("Message affiché dans le text d'input")
            binding.inputLine.setText(it.toString())
        })
    }

    private fun setListeners() {
        binding.buttonNext.setOnClickListener {
            pathViewModel.fetchLine(binding.inputLine.text.toString())
        }
    }
}
