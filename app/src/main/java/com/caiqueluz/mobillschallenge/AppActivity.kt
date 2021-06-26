package com.caiqueluz.mobillschallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.caiqueluz.mobillschallenge.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    private val navController by lazy {
        findNavController(R.id.app_navigation_container)
    }

    private val binding by lazy {
        ActivityAppBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupToolbar()
        setupButton()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun setupButton() {
        binding.button.setOnClickListener {
            // Add dialog here
        }
    }
}
