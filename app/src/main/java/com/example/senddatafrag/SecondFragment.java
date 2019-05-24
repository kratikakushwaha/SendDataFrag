package com.example.senddatafrag;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class SecondFragment extends Fragment {

    EditText e1;
    Button upbtn;
    Medium mid;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_second, container, false);


        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        upbtn = getActivity().findViewById(R.id.upbtn);
        e1 = getActivity().findViewById(R.id.etxt2);
        try {
            String name = getArguments().getString("data");
            e1.setText(name);
        }catch (Exception f){}
        upbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mid.sent(e1.getText().toString());
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mid= (Medium) context;

    }
}

