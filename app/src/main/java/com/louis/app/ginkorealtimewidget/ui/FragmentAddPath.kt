package com.louis.app.ginkorealtimewidget.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider

import com.louis.app.ginkorealtimewidget.R
import com.louis.app.ginkorealtimewidget.viewmodel.PathViewModel

class FragmentAddPath : Fragment(R.layout.fragment_add_path) {
    private val pathViewModel: PathViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(activity,
                "Ma ligne: " + pathViewModel.currentLine.value.toString(),
                Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()

        Toast.makeText(activity,
                "Ma ligne: " + pathViewModel.currentLine.value.toString(),
                Toast.LENGTH_LONG).show()
    }
}