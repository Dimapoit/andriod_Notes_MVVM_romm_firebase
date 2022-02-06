package com.dm_blinov.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.dm_blinov.notes.databinding.ActivityMainBinding
import com.dm_blinov.notes.utils.APP_ACTIVITY

lateinit var mToolbar: Toolbar
lateinit var mNavController: NavController
lateinit var activity_main_Binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Можем получать MainActivity в любом месте приложения
        APP_ACTIVITY = this
        //Инициализируем viewbinding
        activity_main_Binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activity_main_Binding.root)
        //Инициализируем ToolBar
        mToolbar = activity_main_Binding.toolbar
        // Получаем NavController из NavHostFragment
        //mNavController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        mNavController = navHostFragment.navController
        //Устанавливаем Toolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.title)
    }
}