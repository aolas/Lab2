package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
     EditText editBox;
     TextView showData;
     Counting textAnalyzis;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textAnalyzis = new Counting();
        this.showData = findViewById(R.id.textDisplayData);
        this.editBox = findViewById(R.id.textInputBox);
        this.spinner = findViewById(R.id.spnSelect);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.countActions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void onBtnCharClick(View view) {
        int count;
        count = textAnalyzis.countChar(this.editBox.getText());
        showData.setText(R.string.number_chars + count);
    }

    public void onBtnWordClick(View view) {
        int count = textAnalyzis.countWords(this.editBox.getText().toString());
        showData.setText(R.string.number_Words + count);
    }
    public void onBtnClick(View view){
        int position = spinner.getSelectedItemPosition();
        int count;
        String message;
        String output = String.format( getString(R.string.number_Words) ,  35);

        if (position == 0){
            count = textAnalyzis.countWords(this.editBox.getText().toString());
            //showData.setText(R.string.number_Words + count);
            message = String.format(getString(R.string.number_Words), count);
            showData.setText(message);
        }else {
            count = textAnalyzis.countChar(this.editBox.getText());
            message = String.format(getString(R.string.number_chars), count);
            showData.setText(message);
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