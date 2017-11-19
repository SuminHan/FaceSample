package com.microsoft.projectoxford.emotionsample.helper;

import android.graphics.Bitmap;

public class ListViewItem {
    private Bitmap bitmap;
    private String name;
    public Bitmap getBitmap(){return bitmap;}
    public String getName(){return name;}
    public ListViewItem(Bitmap bitmap, String name){
        this.bitmap = bitmap;
        this.name=name;
    }
}