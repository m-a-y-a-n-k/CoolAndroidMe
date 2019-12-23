package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

public class BodyPartFragment extends Fragment {

    private String bodyPart;
    private static final String LIST_INDEX = "LIST_INDEX";
    private static final String BODY_PART = "BODY_PART";
    private int bodyPartIndex;
    private List<Integer> imageIds;

    public BodyPartFragment() {
        // Required empty public constructor
        bodyPartIndex = 0;
    }

    public static BodyPartFragment createInstance(String bodyPart) {
        BodyPartFragment fragment = new BodyPartFragment();
        Bundle args = new Bundle();
        args.putString(BODY_PART, bodyPart);
        fragment.setArguments(args);           //set
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(savedInstanceState != null){
            bodyPartIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);
        String bodyPart = getArguments().getString(BODY_PART);
        switch (bodyPart) {
            case "head":
                imageIds = AndroidImageAssets.getHeads();
                break;
            case "body":
                imageIds = AndroidImageAssets.getBodies();
                break;
            case "legs":
                imageIds = AndroidImageAssets.getLegs();
                break;
        }
        if(imageIds != null){
            imageView.setImageResource(imageIds.get(bodyPartIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(bodyPartIndex < imageIds.size()-1){
                        bodyPartIndex++;
                    } else {
                        bodyPartIndex = 0;
                    }
                    imageView.setImageResource(imageIds.get(bodyPartIndex));
                }
            });
        }
        return rootView;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(LIST_INDEX,bodyPartIndex);
    }
}
