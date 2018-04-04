package com.example.nicdomo.lexicon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ContinueProfileActivity extends AppCompatActivity {

    private ArrayList<Profile> profileList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProfileAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_profile);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewContinueProfile);

        mAdapter = new ProfileAdapter(profileList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        this.prepareProfileData();
    }

    private void prepareProfileData() {
        Profile profile = new Profile("johnDoe", "Warrior", 400);
        profileList.add(profile);

        profile = new Profile("myProfile", "Warrior", 234);
        profileList.add(profile);

        profile = new Profile("pablo", "Archer", 100);
        profileList.add(profile);

        mAdapter.notifyDataSetChanged();
    }
}
