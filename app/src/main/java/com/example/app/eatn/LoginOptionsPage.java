package com.example.app.eatn;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class LoginOptionsPage extends AppCompatActivity {
    DatabaseHelper myDB;
    ImageView imageView;
    Button button1;
    Button button2;
    Animation uptodown,downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_options_page);


        imageView = findViewById(R.id.imageView);
        button1= findViewById(R.id.signup);
        button2= findViewById(R.id.signin);

        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);

        imageView.setAnimation(uptodown);
        button1.setAnimation(downtoup);
        button2.setAnimation(downtoup);





        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signinpage = new Intent(getApplicationContext(),SignInPage.class);
                startActivity(signinpage);


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signuppage = new Intent(getApplicationContext(),SignUpPage.class);
                startActivity(signuppage);


            }
        });


    }



}

