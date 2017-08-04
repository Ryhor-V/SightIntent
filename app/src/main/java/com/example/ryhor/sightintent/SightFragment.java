package com.example.ryhor.sightintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;


public class SightFragment extends Fragment {
    private  Sight mSight;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSharedCheckBox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSight = new Sight();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sight,
                container, false);

        mTitleField = (EditText)v.findViewById(R.id.sight_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                mSight.setTitle(c.toString());
            }

            @Override
            public void afterTextChanged(Editable c) {

            }
        });

        mDateButton = (Button)v.findViewById(R.id.sight_date);
        mDateButton.setText(mSight.getDate().toString());
        mDateButton.setEnabled(false);

        mSharedCheckBox = (CheckBox)v.findViewById(R.id.sight_shared);
        mSharedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // назначение флага раскрытия преступления
                mSight.setShared(isChecked);
            }
        });
        return v;
    }
}
