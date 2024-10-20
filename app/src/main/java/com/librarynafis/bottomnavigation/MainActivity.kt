package com.librarynafis.bottomnavigation

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nafis.bottomnavigation.NafisBottomNavigation

class MainActivity : AppCompatActivity() {


    companion object {
        private const val ID_HOME = 1
        private const val ID_EXPLORE = 2
        private const val ID_MESSAGE = 3
        private const val ID_NOTIFICATION = 4
        private const val ID_ACCOUNT = 5
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)

        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Find views by ID
        val tvSelected = findViewById<TextView>(R.id.tv_selected)
        val bottomNavigation = findViewById<NafisBottomNavigation>(R.id.bottomNavigation)
        val btShow = findViewById<Button>(R.id.btShow)
        val etPageId = findViewById<EditText>(R.id.etPageId)

        // Set custom typeface for tvSelected
        tvSelected.typeface = Typeface.createFromAsset(assets, "fonts/SourceSansPro-Regular.ttf")

        // Set up bottom navigation
        bottomNavigation.apply {
            add(NafisBottomNavigation.Model(ID_HOME, R.drawable.ic_home))
            add(NafisBottomNavigation.Model(ID_EXPLORE, R.drawable.ic_explore))
            add(NafisBottomNavigation.Model(ID_MESSAGE, R.drawable.ic_message))
            add(NafisBottomNavigation.Model(ID_NOTIFICATION, R.drawable.ic_notification))
            add(NafisBottomNavigation.Model(ID_ACCOUNT, R.drawable.ic_account))

            setCount(ID_NOTIFICATION, "115")

            setOnShowListener {
                val name = when (it.id) {
                    ID_HOME -> "HOME"
                    ID_EXPLORE -> "EXPLORE"
                    ID_MESSAGE -> "MESSAGE"
                    ID_NOTIFICATION -> "NOTIFICATION"
                    ID_ACCOUNT -> "ACCOUNT"
                    else -> ""
                }

                tvSelected.text = getString(R.string.main_page_selected, name)
            }

            setOnClickMenuListener {
                val name = when (it.id) {
                    ID_HOME -> "HOME"
                    ID_EXPLORE -> "EXPLORE"
                    ID_MESSAGE -> "MESSAGE"
                    ID_NOTIFICATION -> "NOTIFICATION"
                    ID_ACCOUNT -> "ACCOUNT"
                    else -> ""
                }
            }

            setOnReselectListener {
                Toast.makeText(this@MainActivity, "Item ${it.id} is reselected.", Toast.LENGTH_LONG).show()
            }

            show(ID_HOME)
        }

        // Button click to show page by ID
        btShow.setOnClickListener {
            val id = try {
                etPageId.text.toString().toInt()
            } catch (e: Exception) {
                ID_HOME
            }
            if (id in ID_HOME..ID_ACCOUNT) bottomNavigation.show(id)
        }

    }
}