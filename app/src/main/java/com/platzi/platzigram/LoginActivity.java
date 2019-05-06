package com.platzi.platzigram;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.platzi.platzigram.view.ContainerActivity;
import com.platzi.platzigram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    private Button button;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeComponents();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ContainerActivity.class));
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://alvarolpz.com/portfolio-posts/platzigram/")));
            }
        });
    }


    public  void initializeComponents(){
        button = findViewById(R.id.login);
        imageView = findViewById(R.id.logo);
    }

    public void goCreateAccount(View v){
        Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
        startActivity(intent);
    }
}
