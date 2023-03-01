package com.androidstudio.custom_dialogues

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.androidstudio.custom_dialogues.databinding.ActivityMainBinding
import com.androidstudio.custom_dialogues.databinding.LayoutCustomdialogueBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)
        supportActionBar?.hide()


        binding.btnUpdate.setOnClickListener {
            var dialogBinding = LayoutCustomdialogueBinding.inflate(layoutInflater)

            var dialog = Dialog(this)
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
            dialogBinding.etName.setText(binding.etName.text.toString())
            dialogBinding.etAddress.setText(binding.etAddress.text.toString())
            if (binding.etGender.text.toString().equals("Male")) {
                dialogBinding.rbMale.isChecked = true
            } else if (binding.etGender.text.toString().equals("Female")) {
                dialogBinding.rbFemale.isChecked = true
            } else if (binding.etGender.text.toString().equals("Transgender")) {
                dialogBinding.rbTransgender.isChecked = true
            } else {
            }

            dialogBinding.btnUpdatein.setOnClickListener{

                if(dialogBinding.etName.text.toString().isNullOrEmpty()){
                    dialogBinding.etName.error = "Enter Name"
                }
                else if(dialogBinding.etAddress.text.toString().isNullOrEmpty()){
                    dialogBinding.etAddress.error= "Enter Email"
                }
                else{
                    binding.etName.setText(dialogBinding.etName.text.toString())
                    binding.etAddress.setText(dialogBinding.etAddress.text.toString())
                    if(dialogBinding.rbMale.isChecked){
                        binding.etGender.setText("Male")
                    }
                    else if(dialogBinding.rbFemale.isChecked){
                        binding.etGender.setText("Female")
                    }
                    else {
                        binding.etGender.setText("Others")
                    }
                    dialog.dismiss()
                }


            }
            dialog.show()
        }
    }
}