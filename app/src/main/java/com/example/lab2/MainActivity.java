package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
     EditText editBox;
     TextView showData;
     Counting textAnalyzis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textAnalyzis = new Counting();
        this.showData = findViewById(R.id.textDisplayData);
        this.editBox = findViewById(R.id.textInputBox);
    }

    public void onBtnCharClick(View view) {
        int count;
        count = textAnalyzis.countChar(this.editBox.getText());
        showData.setText("Number of chars: " + count);
    }

    public void onBtnWordClick(View view) {
        int count = textAnalyzis.countWords(this.editBox.getText().toString());
        showData.setText("Number of Words: " + count);
    }
}
class Counting{
    int countChar(Editable words){

        return words.length();
    }
    int countWords(String words){

        //return Arrays.toString(words.split("\\s|(?<!\\d)[,.](?!\\d)")).length();
        return words.split("\\s+|,\\s*|\\.\\s*").length;
    }
}