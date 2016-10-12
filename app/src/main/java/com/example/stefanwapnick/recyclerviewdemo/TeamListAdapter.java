package com.example.stefanwapnick.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Team list adapter
 */
public class TeamListAdapter extends RecyclerView.Adapter<TeamItemViewHolder> implements View.OnClickListener {

    private List<Team> teamList;
    private TeamListAdapterListener listener;
    private RecyclerView recyclerView;

    public TeamListAdapter(RecyclerView recyclerView, List<Team> teamList, TeamListAdapterListener listener) {
        this.teamList = teamList;
        this.listener = listener;
        this.recyclerView = recyclerView;
    }

    @Override
    public TeamItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_team, parent, false);
        view.setOnClickListener(this);
        return new TeamItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TeamItemViewHolder viewHolder, int position) {
        Team team = teamList.get(position);
        viewHolder.upVotesText.setText(String.valueOf(team.upVotes));
        viewHolder.downVotesText.setText(String.valueOf(team.downVotes));
        viewHolder.teamNameText.setText(team.name);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    @Override
    public void onClick(View view) {
        int position = recyclerView.getChildLayoutPosition(view);
        listener.onItemSelected(position);
    }

    public interface TeamListAdapterListener{
        public void onItemSelected(int position);
    }
}
