package com.example.nicdomo.lexicon;

/**
 * Created by Timothy on 3/14/2018.
 */

public class Profile {
    private String profileName, className;
    private int score, wordCount;

    public Profile(String profileName, String className, int score) {
        this.profileName = profileName;
        this.className = className;
        this.score = score;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
