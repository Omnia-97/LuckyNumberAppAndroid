package com.example.luckynumberappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView luckyNum , welcomeTxt;
    Button shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        luckyNum= findViewById(R.id.textView3);
        welcomeTxt = findViewById(R.id.textView2);
        shareBtn = findViewById(R.id.shareBtn);
        //Receiving data from another activity
        Intent i = getIntent();
        String userName = i.getStringExtra("name");
        int random = generateRandomNum();
        luckyNum.setText(""+random);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
   shareData(userName , random);
            }
        });

    }
    //generating random number
    public int generateRandomNum(){
        Random random = new Random();
        int upper_num = 1000;
        return random.nextInt(upper_num);
    }
    public void shareData(String userName , int randomNumber){
        //Implicit intent
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        //add info
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, userName + " got lucky today!");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "His lucky number is " + randomNumber);
        startActivity(Intent.createChooser(shareIntent , "Choose a platForm "));

    }
}