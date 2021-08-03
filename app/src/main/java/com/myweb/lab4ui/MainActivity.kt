package com.myweb.lab4ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.myweb.lab4ui.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var subject :String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ///Set  Spinner
        val subjectSpinner : Spinner = binding.spinerSubject
        val subjectArray =resources.getStringArray(R.array.subjectName_array)

        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,subjectArray)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        subjectSpinner.adapter = arrayAdapter

        subjectSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                subject = subjectArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(applicationContext,"Please select subject.",Toast.LENGTH_LONG).show()
            }
        }
    }

    fun showTimePickerDialog(v:View){
        val newTimeFragment = TimePickerFragment()
        newTimeFragment.show(supportFragmentManager,"Time Picker")
}

    fun showDetail(v:View){

        binding.textShow.text = "ID: ${binding.editTextId.text}\n" +
                "Name: ${binding.editTextName.text}\n" +
                "Subject: $subject\nTime: ${binding.textTime.text}"
    }

    fun reset(v:View){
        binding.editTextId.text?.clear()
        binding.editTextName.text?.clear()
        binding.spinerSubject.setSelection(0)
        binding.textTime.text="_ _:_ _"
        binding.textShow.text="Show detail"
    }
}

// Create an ArrayAdapter using the string array and a default spinner layout
/* ArrayAdapter.createFromResource(
         this,
         R.array.subjectName_array,
         android.R.layout.simple_spinner_item
 ).also { adapter ->
     // Specify the layout to use when the list of choices appears
     adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
     // Apply the adapter to the spinner
     subjectSpinner.adapter = adapter
 }*/