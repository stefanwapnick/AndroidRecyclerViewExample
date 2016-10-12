package com.example.stefanwapnick.recyclerviewdemo;

import android.os.Parcel;
import android.os.Parcelable;

public class Team implements Parcelable {

    public int upVotes;
    public int downVotes;
    public String name;

    public Team(int upVotes, int downVotes, String name) {
        this.upVotes = upVotes;
        this.downVotes = downVotes;
        this.name = name;
    }

    public Team(){
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Used to serialize object to parcelable
    @Override
    public void writeToParcel(Parcel outParcel, int flags) {
        outParcel.writeInt(upVotes);
        outParcel.writeInt(downVotes);
        outParcel.writeString(name);
    }

    // Used to deserialize object to parcelable
    public static final Parcelable.Creator<Team> CREATOR = new Parcelable.Creator<Team>() {

        public Team createFromParcel(Parcel inParcel) {
            Team team = new Team();
            team.upVotes = inParcel.readInt();
            team.downVotes = inParcel.readInt();
            team.name = inParcel.readString();
            return team;
        }

        public Team[] newArray(int size) {
            return new Team[size];
        }
    };
}
