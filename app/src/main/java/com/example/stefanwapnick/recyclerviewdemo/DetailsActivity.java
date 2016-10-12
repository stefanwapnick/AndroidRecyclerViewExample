package com.example.stefanwapnick.recyclerviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView teamNameText = (TextView) findViewById(R.id.activity_details_teamNameText);
        TextView upVotesText = (TextView) findViewById(R.id.activity_details_upVotesText);
        TextView downVotesText = (TextView) findViewById(R.id.activity_details_downVotesText);

        Intent receivedIntent = getIntent();

        if(receivedIntent != null){
            Team team = (Team)receivedIntent.getParcelableExtra(MainActivity.INTENT_EXTRA_TEAM);
            teamNameText.setText(team.name);
            upVotesText.setText(String.format("%s up-votes", team.upVotes));
            downVotesText.setText(String.format("%s down-votes", team.downVotes));
        }
    }
}
