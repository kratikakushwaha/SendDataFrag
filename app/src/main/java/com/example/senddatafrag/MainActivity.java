package com.example.senddatafrag;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements Medium {
    String s;

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.send);
        editText = findViewById(R.id.txt1);
        final SecondFragment frag = new SecondFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("data", editText.getText().toString());
                frag.setArguments(b);
                fragmentTransaction.add(R.id.my, frag);
                fragmentTransaction.commit();


            }
        });

    }

    @Override
    public void sent(String data) {
        editText.setText(data);
    }
}
