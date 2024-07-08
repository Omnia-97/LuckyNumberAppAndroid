package com.example.luckynumberappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView titleText;
    Button navBtn;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleText = findViewById(R.id.textView);
        navBtn = findViewById(R.id.wishBtn);
        editText = findViewById(R.id.editText);
        navBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editText.getText().toString();
                Intent goIntent = new Intent(MainActivity.this , SecondActivity.class);
                goIntent.putExtra("name" , userName);
                startActivity(goIntent);
            }
        });
    }

}