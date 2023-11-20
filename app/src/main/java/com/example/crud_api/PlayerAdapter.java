package com.example.crud_api;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {
    List<PlayerItem> result;
    Activity activity;

    public PlayerAdapter(List<PlayerItem> result, Activity activity) {
        this.result = result;
        this.activity = activity;
    }

    public PlayerAdapter(MyPlayer myPlayer) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.
                list_item_player, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int
            position) {
        holder.bind(result.get(position));
    }

    @Override
    public int getItemCount() {
        return result != null ? result.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id, tv_album_name, tv_title, tv_release_date,
                tv_artist_name, tv_genre;
        ImageView posterView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_album_name = itemView.findViewById(R.id.tv_album_name);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_release_date = itemView.findViewById(R.id.tv_release_date);
            tv_artist_name = itemView.findViewById(R.id.tv_artist_name);
            tv_genre = itemView.findViewById(R.id.tv_genre);
            posterView = itemView.findViewById(R.id.posterView);
        }

        public void bind(PlayerItem playerItem) {
            tv_id.setText(playerItem.id);
            tv_album_name.setText(playerItem.albumName);
            tv_title.setText(playerItem.title);
            tv_release_date.setText(playerItem.releaseDate);
            tv_artist_name.setText(playerItem.artistName);
            tv_genre.setText(playerItem.genre);

            Glide.with(activity).load(playerItem.getPictureUrl()).into(posterView);
        }
    }
}

