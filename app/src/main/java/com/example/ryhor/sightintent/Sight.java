package com.example.ryhor.sightintent;


import java.util.Date;
import java.util.UUID;

public class Sight {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mShared;

    public Sight(){
        //Generating a unique identifier

        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isShared() {
        return mShared;
    }

    public void setShared(boolean shared) {
        mShared = shared;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
