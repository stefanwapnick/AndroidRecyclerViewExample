package com.example.stefanwapnick.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Team item view holder
 */
public class TeamItemViewHolder extends RecyclerView.ViewHolder {

    public TextView upVotesText;
    public TextView downVotesText;
    public TextView teamNameText;

    public TeamItemViewHolder(View itemView) {
        super(itemView);

        upVotesText = (TextView)itemView.findViewById(R.id.list_item_team_upVotesText);
        downVotesText = (TextView)itemView.findViewById(R.id.list_item_team_downVotesText);
        teamNameText = (TextView)itemView.findViewById(R.id.list_item_team_nameText);
    }
}
