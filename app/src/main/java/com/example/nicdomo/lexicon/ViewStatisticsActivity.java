package com.example.nicdomo.lexicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ViewStatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_statistics);

        this.setupButtons();
    }

    private void setupButtons(){
        ImageButton backButton = this.findViewById(R.id.imageButtonBack);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ViewStatisticsActivity.this, LeaderboardActivity.class);
                startActivity(i);
            }
        });
    }
}
