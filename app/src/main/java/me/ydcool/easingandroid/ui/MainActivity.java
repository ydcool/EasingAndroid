package me.ydcool.easingandroid.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import me.ydcool.easing.EaseInBackInterpolator;
import me.ydcool.easing.EaseInBounceInterpolator;
import me.ydcool.easing.EaseInCircInterpolator;
import me.ydcool.easing.EaseInCubicInterpolator;
import me.ydcool.easing.EaseInElasticInterpolator;
import me.ydcool.easing.EaseInExpoInterpolator;
import me.ydcool.easing.EaseInOutBackInterpolator;
import me.ydcool.easing.EaseInOutCircInterpolator;
import me.ydcool.easing.EaseInOutCubicInterpolator;
import me.ydcool.easing.EaseInOutElasticInterpolator;
import me.ydcool.easing.EaseInOutExpoInterpolator;
import me.ydcool.easing.EaseInOutQuadInterpolator;
import me.ydcool.easing.EaseInOutQuartInterpolator;
import me.ydcool.easing.EaseInOutQuintInterpolator;
import me.ydcool.easing.EaseInOutSineInterpolator;
import me.ydcool.easing.EaseInQuadInterpolator;
import me.ydcool.easing.EaseInQuartInterpolator;
import me.ydcool.easing.EaseInQuintInterpolator;
import me.ydcool.easing.EaseInSineInterpolator;
import me.ydcool.easing.EaseOutBackInterpolator;
import me.ydcool.easing.EaseOutBounceInterpolator;
import me.ydcool.easing.EaseOutCircInterpolator;
import me.ydcool.easing.EaseOutCubicInterpolator;
import me.ydcool.easing.EaseOutElasticInterpolator;
import me.ydcool.easing.EaseOutExpoInterpolator;
import me.ydcool.easing.EaseOutQuadInterpolator;
import me.ydcool.easing.EaseOutQuartInterpolator;
import me.ydcool.easing.EaseOutQuintInterpolator;
import me.ydcool.easing.EaseOutSineInterpolator;
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
