package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * @author ydcool
 */
public class EaseInOutQuartInterpolator implements Interpolator {
    private float b;
    private float c;

    public EaseInOutQuartInterpolator() {
        this.b = 0;
        this.c = 8;
    }

    public EaseInOutQuartInterpolator(float beginIngValue, float changeInValue) {
        this.b = beginIngValue;
        this.c = changeInValue;
    }

    public float getInterpolation(float t) {
        if (t < 0.5)
            return c * t * t * t * t + b;
        return -c * (t - 1) * (t - 1) * (t - 1) * (t - 1) + 1 + b;
    }
}
