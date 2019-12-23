package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class BodyPartFragment extends Fragment {

    private String bodyPart;

    public BodyPartFragment() {
        // Required empty public constructor
    }

    public static BodyPartFragment createInstance(String bodyPart) {
        BodyPartFragment fragment = new BodyPartFragment();
        Bundle args = new Bundle();
        args.putString("BODY_PART", bodyPart);
        fragment.setArguments(args);           //set
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);
        String bodyPart = getArguments().getString("BODY_PART");
        switch (bodyPart) {
            case "head":
                imageView.setImageResource(AndroidImageAssets.getHeads().get(0));
                break;
            case "body":
                imageView.setImageResource(AndroidImageAssets.getBodies().get(0));
                break;
            case "legs":
                imageView.setImageResource(AndroidImageAssets.getLegs().get(0));
                break;
        }
        return rootView;
    }

}
