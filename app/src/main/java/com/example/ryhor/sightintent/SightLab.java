package com.example.ryhor.sightintent;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SightLab {
    private static SightLab sSightLab;

    private List<Sight> mSights;

    public static SightLab get (Context context) {
        if (sSightLab == null) {
            sSightLab = new SightLab(context);
        }
        return sSightLab;
    }
    private SightLab (Context context){
        mSights = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            Sight sight = new Sight();
            sight.setTitle("Sight #" + i);
            sight.setShared(i % 2 == 0); //для каждого второго объекта
            mSights.add(sight);
        }
    }

    public List<Sight> getSights() {
        return mSights;
    }

    public Sight getSight (UUID id) {
        for (Sight sight : mSights) {
            if (sight.getId().equals(id)){
                return sight;
            }
        }
        return null;
    }
}
