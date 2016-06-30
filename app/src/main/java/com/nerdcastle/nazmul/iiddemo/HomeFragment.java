package com.nerdcastle.nazmul.iiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nerdcastle.nazmul.iiddemo.activity.PostActivity;


public class HomeFragment extends Fragment{


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,
                container, false);
        CardView cardView= (CardView) view.findViewById(R.id.cv);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent postIntent=new Intent(getActivity(), PostActivity.class);
                startActivity(postIntent);
            }
        });
        return view;
    }
    public void post(View view){

    }

}