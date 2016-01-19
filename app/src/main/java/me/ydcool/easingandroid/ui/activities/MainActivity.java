package me.ydcool.easingandroid.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import me.ydcool.easing.EaseInBackInterpolator;
import me.ydcool.easing.EaseInBounceInterpolator;
import me.ydcool.easing.EaseInCircInterpolator;
import me.ydcool.easing.EaseInOutBackInterpolator;
import me.ydcool.easingandroid.R;
import me.ydcool.easingandroid.ui.adapters.DemoAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.Main_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<Class> easingInterpolators = new ArrayList<>();

        easingInterpolators.add(EaseInBackInterpolator.class);
        easingInterpolators.add(EaseInOutBackInterpolator.class);
        easingInterpolators.add(EaseInBounceInterpolator.class);
        easingInterpolators.add(EaseInCircInterpolator.class);

        mRecyclerView.setAdapter(new DemoAdapter(this, easingInterpolators));
    }
}
