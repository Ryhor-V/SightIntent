package com.example.ryhor.sightintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class SightListFragment extends Fragment {
    private RecyclerView mSightRecyclerView;
    private SightAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sight_list, container, false);

        mSightRecyclerView = (RecyclerView) view
                .findViewById(R.id.sight_recycler_view);
        mSightRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }
    private void updateUI(){
        SightLab sightLab = SightLab.get(getActivity());
        List<Sight> sights = sightLab.getSights();
        mAdapter = new SightAdapter(sights);
        mSightRecyclerView.setAdapter(mAdapter);
    }

    private class SightHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        private Sight mSight;

        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mSharedCheckBox;

        public SightHolder (View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView)
                    itemView.findViewById(R.id.list_item_sight_title_text_view);
            mDateTextView = (TextView)
                    itemView.findViewById(R.id.list_item_sight_date_text_view);
            mSharedCheckBox = (CheckBox)
                    itemView.findViewById(R.id.list_item_sight_shared_check_box);
        }
        public void bindSight (Sight sight){
            mSight = sight;
            mTitleTextView.setText(mSight.getTitle());
            mDateTextView.setText(mSight.getDate().toString());
            mSharedCheckBox.setChecked(mSight.isShared());
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),
                    mSight.getTitle() + " clicked!", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    private class SightAdapter extends RecyclerView.Adapter<SightHolder>{
        private List<Sight> mSights;

        public SightAdapter (List<Sight> sights){
            mSights = sights;
        }

        @Override
        public SightHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_sight, parent, false);
            return new SightHolder(view);
        }

        @Override
        public void onBindViewHolder(SightHolder holder, int position) {
            Sight sight = mSights.get(position);
            holder.bindSight(sight);
        }

        @Override
        public int getItemCount() {
            return mSights.size();
        }
    }

}
