package com.example.nicdomo.lexicon;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ContinueProfileAdapter extends RecyclerView.Adapter<ContinueProfileAdapter.MyViewHolder> {
    private ArrayList<Profile> profileList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView profileName, score;


        public MyViewHolder(View view) {
            super(view);
            profileName = (TextView) view.findViewById(R.id.profileTV);
            score = (TextView) view.findViewById(R.id.scoreTV);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, LevelSelect.class);
                    context.startActivity(intent);
                }
            });
        }
    }
    public ContinueProfileAdapter(ArrayList<Profile> profileList) {
        this.profileList = profileList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.continue_profile_item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Profile profile = profileList.get(position);
        holder.profileName.setText(profile.getProfileName());
        holder.score.setText(Integer.toString(profile.getScore()));
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }
}
