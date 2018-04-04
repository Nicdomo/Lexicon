package com.example.nicdomo.lexicon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        this.setupButtons();

    }

    private void setupButtons(){
        ImageButton backButton = this.findViewById(R.id.imageButtonBack3);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Credits.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}