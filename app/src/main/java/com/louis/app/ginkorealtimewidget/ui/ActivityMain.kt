package com.louis.app.ginkorealtimewidget.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.louis.app.ginkorealtimewidget.R
import com.louis.app.ginkorealtimewidget.databinding.ActivityMain2Binding
import com.louis.app.ginkorealtimewidget.viewmodel.PathViewModel

const val EXTRA_LINE = "com.louis.app.ginkorealtimewidget.EXTRA_LINE"

class ActivityMain : FragmentActivity() {

    /*private val viewModelFactory = PathViewModelFactory()
    private val viewModel: PathViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(PathViewModel::class.java)
    }*/
    private lateinit var pathViewModel: PathViewModel
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)

        pathViewModel = ViewModelProvider(this).get(PathViewModel::class.java)

        setViewPager()
        observe()
    }

    private fun setViewPager() {
        val tabTitles = arrayOf("Mes trajets", "Nouveau trajet")
        val viewPager = binding.viewPager
        viewPager.adapter = BusPagerAdapter(this)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    private fun observe() {
        pathViewModel.currentLine.observe(this, Observer { line ->
            if (line != null) {
//                supportFragmentManager
//                        .beginTransaction()
//                        .replace(R.id.viewPager, FragmentAddPath())
//                        .addToBackStack(null)
//                        .commit()
            } else
                showError(resources.getString(R.string.CONFIG_lineError))
        })
    }

    private fun showError(message: String) {
        Snackbar.make(binding.coordinator, message, Snackbar.LENGTH_LONG).show()
    }
}
