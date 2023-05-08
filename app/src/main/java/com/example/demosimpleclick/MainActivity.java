package com.example.demosimpleclick;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    //Declare field variables
    TextView tvDisplay;
    Button btnDisplay;
    EditText etInput;
    ToggleButton toggleBtn;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay= findViewById(R.id.textViewDisplay);
        btnDisplay = findViewById(R.id.buttonDisplay);
        etInput = findViewById(R.id.editTextInput);
        toggleBtn = findViewById(R.id.toggleButtonEnabled);
        rgGender = findViewById(R.id.radioGroupGender);

        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add your code for the action
                boolean btnCheck = toggleBtn.isChecked();
                if(btnCheck == true){
                    etInput.setEnabled(true);
                } else if (btnCheck == false) {
                    etInput.setEnabled(false);
                }
            }
        });

        rgGender.check(R.id.radioButtonGenderMale);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for the action
                etInput.getText().toString();
                String stringRes = etInput.getText().toString();
                int checkedRadioId = rgGender.getCheckedRadioButtonId();
                if(checkedRadioId == R.id.radioButtonGenderMale){
                    stringRes="He says "+stringRes;
                } else if(checkedRadioId == R.id.radioButtonGenderFemale){
                    stringRes="She says "+stringRes;
                }
                tvDisplay.setText(stringRes);
            }
        });

    }
}