package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * @author ydcool
 */
public class EaseOutExpoInterpolator implements Interpolator {
    private float b;
    private float c;

    public EaseOutExpoInterpolator() {
        this.b = 0;
        this.c = 1;
    }

    public EaseOutExpoInterpolator(float beginIngValue, float changeInValue) {
        this.b = beginIngValue;
        this.c = changeInValue;
    }

    public float getInterpolation(float t) {
        return -c * (t - 1) * (t - 1) * (t - 1) * (t - 1) * (t - 1) * (t - 1)
                + 1 + b;
    }
}
