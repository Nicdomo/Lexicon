package com.example.nicdomo.lexicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class ContinueProfileActivity extends AppCompatActivity {

    private ArrayList<Profile> profileList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ContinueProfileAdapter cpAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_profile);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewContinueProfile);

        cpAdapter = new ContinueProfileAdapter(profileList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cpAdapter);

        this.prepareProfileData();
        this.setupButtons();
    }

    private void prepareProfileData() {
        Profile profile = new Profile("johnDoe", "Warrior", 400);
        profileList.add(profile);

        profile = new Profile("myProfile", "Warrior", 234);
        profileList.add(profile);

        profile = new Profile("pablo", "Archer", 100);
        profileList.add(profile);

        cpAdapter.notifyDataSetChanged();
    }

    private void setupButtons(){
        ImageButton backButton = this.findViewById(R.id.imageButtonBack2);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ContinueProfileActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
