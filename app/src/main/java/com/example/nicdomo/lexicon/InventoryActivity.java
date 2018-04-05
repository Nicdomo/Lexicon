package com.example.nicdomo.lexicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InventoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        this.setupButtons();
    }

    private void setupButtons(){
        ImageButton backButton = this.findViewById(R.id.imageButtonBack2);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InventoryActivity.this, LevelSelect.class);
                startActivity(i);
            }
        });

    }
}
