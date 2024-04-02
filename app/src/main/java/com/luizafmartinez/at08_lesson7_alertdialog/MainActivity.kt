package com.luizafmartinez.at08_lesson7_alertdialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.luizafmartinez.at08_lesson7_alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun save(view: View) {

        val saveAlert = AlertDialog.Builder(this)

        saveAlert.setTitle("Save")
        saveAlert.setMessage("Are you sure you want to save your changes ?")

        saveAlert.setPositiveButton("Yes")
        { dialogInterface: DialogInterface, _: Int -> Snackbar.make(
           findViewById(R.id.button),
           "Saved",Snackbar.LENGTH_LONG).show()}

        saveAlert.setNegativeButton("No")
        { dialogInterface: DialogInterface, _: Int -> Snackbar.make(
          findViewById(R.id.button),
          "Not Saved",Snackbar.LENGTH_LONG).show()}

        saveAlert.setNeutralButton("Remind me later", null)

        saveAlert.show()
        }

    }
