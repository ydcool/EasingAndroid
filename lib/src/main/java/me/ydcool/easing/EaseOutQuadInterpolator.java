package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * @author ydcool
 */
public class EaseOutQuadInterpolator implements Interpolator {
    private float b;
    private float c;

    public EaseOutQuadInterpolator() {
        this.b = 1;
        this.c = 1;
    }

    public EaseOutQuadInterpolator(float beginIngValue, float changeInValue) {
        this.b = beginIngValue;
        this.c = changeInValue;
    }

    public float getInterpolation(float t) {
        return (float) (-c * (t - 1) * (t - 1) + b);
    }
}
