package com.nikitha.android.musicalstructureapp;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class MusicList {

    String songName;
    String songDesc;
    int albumcover;
    Drawable play;

    public MusicList(String songName, String songDesc, int albumcover, Drawable play) {
        this.songName = songName;
        this.songDesc = songDesc;
        this.albumcover = albumcover;
        this.play = play;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongDesc() {
        return songDesc;
    }

    public void setSongDesc(String songDesc) {
        this.songDesc = songDesc;
    }

    public int getAlbumcover() {
        return albumcover;
    }

    public void setAlbumcover(int albumcover) {
        this.albumcover = albumcover;
    }

    public Drawable getPlay() {
        return play;
    }

    public void setPlay(Drawable play) {
        this.play = play;
    }
}
