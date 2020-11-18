package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
     EditText editBox;
     TextView showData;
     Counting textAnalyzis;
    Spinner spinner;
    Toast toScreeenMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.showData = findViewById(R.id.textDisplayData);
        this.editBox = findViewById(R.id.textInputBox);
        toScreeenMessage =Toast.makeText(getApplicationContext(),R.string.empty,Toast.LENGTH_SHORT);
        toScreeenMessage.setGravity(Gravity.CENTER, 0, 0);
        this.spinner = findViewById(R.id.spnSelect);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.countActions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onBtnClick(View view){
        int position = spinner.getSelectedItemPosition();
        String textInput = this.editBox.getText().toString();
        if (!textInput.isEmpty()) {
            showData.setText(textAnalyzis.counting(textInput, position,getString(R.string.number_Words),getString(R.string.number_chars)));
        } else{
            showData.setText(R.string.information);
            toScreeenMessage.show();
        }
    }
}
