package com.ciazhar.getwebpagesourcecodeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView pageSource;
    Spinner spinner;
    EditText url;
    ArrayAdapter<CharSequence> spinnerItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.main_spinner_protocol);
        url = (EditText) findViewById(R.id.main_get_url);
        pageSource = (TextView) findViewById(R.id.main_text_get_html);

        spinnerItem = ArrayAdapter.createFromResource(this, R.array.protocol, android.R.layout.simple_spinner_item);
        spinnerItem.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerItem);


    }
}
