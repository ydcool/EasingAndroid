package me.ydcool.easingandroid.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import me.ydcool.easing.*;
import me.ydcool.easingandroid.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static final Class[] EASING_INTERPOLATOR = new Class[]{
            EaseInBackInterpolator.class, EaseOutBackInterpolator.class, EaseInOutBackInterpolator.class,
            EaseInBounceInterpolator.class, EaseOutBounceInterpolator.class, EaseInOutBackInterpolator.class,
            EaseInCircInterpolator.class, EaseOutCircInterpolator.class, EaseInOutCircInterpolator.class,
            EaseInCubicInterpolator.class, EaseOutCubicInterpolator.class, EaseInOutCubicInterpolator.class,
            EaseInElasticInterpolator.class, EaseOutElasticInterpolator.class, EaseInOutElasticInterpolator.class,
            EaseInExpoInterpolator.class, EaseOutExpoInterpolator.class, EaseInOutExpoInterpolator.class,
            EaseInQuadInterpolator.class, EaseOutQuadInterpolator.class, EaseInOutQuadInterpolator.class,
            EaseInQuartInterpolator.class, EaseOutQuartInterpolator.class, EaseInOutQuartInterpolator.class,
            EaseInQuintInterpolator.class, EaseOutQuintInterpolator.class, EaseInOutQuintInterpolator.class,
            EaseInSineInterpolator.class, EaseOutSineInterpolator.class, EaseInOutSineInterpolator.class
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.Main_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<Class> easingInterpolators = new ArrayList<>();

        easingInterpolators.addAll(Arrays.asList(EASING_INTERPOLATOR));

        mRecyclerView.setAdapter(new DemoAdapter(this, easingInterpolators));
    }
}
