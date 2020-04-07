package com.nikitha.android.musicalstructureapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MusicListAdaptor extends ArrayAdapter<MusicList> {
    Button button;
    Activity contextActivity;
    MusicList currentItem;
    TextView songName;


    public MusicListAdaptor(Activity contextActivity, ArrayList<MusicList> itemsAtPositon) {
        super(contextActivity, 0, itemsAtPositon);
        this.contextActivity=contextActivity;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        currentItem = getItem(position);

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.musiclist, parent, false);
        }

        songName=(TextView) listItemView.findViewById(R.id.songName);
        TextView songDesc=(TextView) listItemView.findViewById(R.id.songDesc);
        ImageView albumcover=(ImageView) listItemView.findViewById(R.id.albumcover);
        button=(Button) listItemView.findViewById(R.id.playButton);

        songName.setText(currentItem.songName);
        songDesc.setText(currentItem.songDesc);
        albumcover.setImageResource(currentItem.albumcover);

        button.setOnClickListener(new View.OnClickListener() {
            boolean isPlaying = false;
            @Override
            public void onClick(View view) {
                //button.setImageDrawable(null);
                if(!isPlaying) {
                    Drawable drawable = contextActivity.getResources().getDrawable(R.drawable.pause);
                    button.setBackground(drawable);
                    //button.setImageDrawable((Drawable)R.drawable.pause);
                    isPlaying=true;
                }
                else{
                    Drawable drawable1 = contextActivity.getResources().getDrawable(R.drawable.play);
                    button.setBackground(drawable1);
                    //button.setBackgroundResource(R.drawable.play);
                    isPlaying=false;
                }
                Intent intent = new Intent(contextActivity, NowPlayingActivity.class);
                intent.putExtra("songName", currentItem.songName);
                contextActivity.startActivity(intent);
            }
        });


        return listItemView;
    }
}
