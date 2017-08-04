package com.example.ryhor.sightintent;


import android.support.v4.app.Fragment;

public class SightListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new SightListFragment();
    }
}
