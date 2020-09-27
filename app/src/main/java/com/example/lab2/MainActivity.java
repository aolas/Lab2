package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
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
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textAnalyzis = new Counting();
        this.showData = findViewById(R.id.textDisplayData);
        this.editBox = findViewById(R.id.textInputBox);
        toast =Toast.makeText(getApplicationContext(),R.string.empty,Toast.LENGTH_SHORT);
        toast.setMargin(50,50);
        this.spinner = findViewById(R.id.spnSelect);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.countActions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onBtnClick(View view){
        int position = spinner.getSelectedItemPosition();
        int count;
        String message;
        String output = String.format( getString(R.string.number_Words) ,  35);

        if (this.editBox.getText().toString().length() > 0) {
            if (position == 0) {
                count = textAnalyzis.countWords(this.editBox.getText().toString());
                message = String.format(getString(R.string.number_Words), count);
                showData.setText(message);
            } else {
                count = textAnalyzis.countChar(this.editBox.getText());
                message = String.format(getString(R.string.number_chars), count);
                showData.setText(message);
            }
        } else{
            showData.setText(R.string.information);
            toast.show();
        }
    }
}
class Counting{
    int countChar(Editable words){

        return words.length();
    }
    int countWords(String words){
        return words.split("\\s+|,\\s*|\\.\\s*").length;
    }
}