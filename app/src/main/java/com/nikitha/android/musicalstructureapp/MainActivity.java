package com.nikitha.android.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MusicList> data=new ArrayList<MusicList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data= populateData(data);
        MusicListAdaptor musicListAdaptor=new MusicListAdaptor(MainActivity.this, data);
        ListView listView=findViewById(R.id.listview);
        listView.setAdapter(musicListAdaptor);
    }

    private ArrayList<MusicList> populateData(ArrayList<MusicList> data) {

//        String songName, String songDesc, Bitmap albumcover, Bitmap play
        data.add(new MusicList("Do re me","THE SOUND OF MUSIC (1965)",R.drawable.doreme,null));
        data.add(new MusicList("Love Me Like You Do","Ellie Goulding - Love Me Like You Do",R.drawable.lovemelikeyoudo,null));
        data.add(new MusicList("Whatever Will Be Will Be","Song by Jay Livingston and Ray Evans",R.drawable.whatever,null));
        data.add(new MusicList("yesterday","The Beatles - Yesterday - YouTube",R.drawable.yesterday,null));

       return data;
    }
}
