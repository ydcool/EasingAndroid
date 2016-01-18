package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * @author ydcool
 */
public class EaseOutBackInterpolator implements Interpolator {
    private float b;
    private float c;

    public EaseOutBackInterpolator() {
        this.b = 0;
        this.c = 1;
    }

    public EaseOutBackInterpolator(float beginIngValue, float changeInValue) {
        this.b = beginIngValue;
        this.c = changeInValue;
    }

    public float getInterpolation(float t) {
        float s = 1.70158f;
        return c * ((t - 1) * (t - 1) * ((s + 1) * (t - 1) + s) + 1) + b;
    }
}
