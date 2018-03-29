package com.example.nicdomo.lexicon;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timothy on 3/14/2018.
 */

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.MyViewHolder>{

    private ArrayList<Profile> profileList = new ArrayList<>();


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView profileTV, classTV, scoreTV, wordcountTV;

        public MyViewHolder(View view) {
            super(view);
            /*
            profileName = (TextView) view.findViewById(R.id.profileTV);
            className = (TextView) view.findViewById(R.id.classTV);
            score = (TextView) view.findViewById(R.id.scoreTV);
            wordCount = (TextView) view.findViewById(R.id.wordcountTV);
            */
        }
    }
    public LeaderboardAdapter(ArrayList<Profile> profileList) {
        this.profileList = profileList;
    }

    @Override
    public LeaderboardAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profile_item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LeaderboardAdapter.MyViewHolder holder, int position) {
        Profile profile = profileList.get(position);
        /*
        holder.profileName.setText(profile.getProfileName());
        holder.className.setText(profile.getClassName());
        holder.score.setText(profile.getScore());
        holder.wordCount.setText(profile.getWordCount());
        */
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }
}
