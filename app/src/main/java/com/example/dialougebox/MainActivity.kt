package com.example.dialougebox

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialougebox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you sure")
            builder1.setMessage("Do you want to close the app.?")
            builder1.setIcon(R.drawable.logout)
            builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                    // What action should be perform when yes is click
                    finish()
                })
            builder1.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which -> })
            builder1.show()
        }
        binding.btn2.setOnClickListener {
            val options = arrayOf("Gulab jamun", "Rasmalai", "KAju barfi")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which is your favourite sweet?")
            builder2.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "You click on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be perform when yes is click
            })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialog, which -> })
            builder2.show()
        }
        binding.btn3.setOnClickListener {
            val options = arrayOf("Gulab jamun", "Rasmalai", "KAju barfi")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Which is your favourite sweet?")
            builder3.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this, "You click on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder3.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be perform when yes is click
            })
            builder3.setNegativeButton("Decline", DialogInterface.OnClickListener { dialog, which -> })
            builder3.show()
        }
    }
}