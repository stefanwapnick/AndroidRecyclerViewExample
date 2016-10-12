package com.example.stefanwapnick.recyclerviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TeamListAdapter.TeamListAdapterListener {

    public static final String INTENT_EXTRA_TEAM = "INTENT_EXTRA_TEAM";
    private List<Team> teamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create fake data
        teamList = new ArrayList<>();
        teamList.add(new Team(999, 0, "Team Griffins"));
        teamList.add(new Team(6, 2, "Team Kraken"));
        teamList.add(new Team(4, 1, "Team Panthers"));
        teamList.add(new Team(2, 0, "Team Kthulu"));

        // Setup recycler view
        RecyclerView teamRecyclerView = (RecyclerView) findViewById(R.id.activity_main_teamRecyclerView);
        teamRecyclerView.setAdapter(new TeamListAdapter(teamRecyclerView, teamList, this));
        teamRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemSelected(int position) {
        Intent toDetailsIntent = new Intent(this, DetailsActivity.class);
        toDetailsIntent.putExtra(INTENT_EXTRA_TEAM, teamList.get(position));
        startActivity(toDetailsIntent);
    }
}
