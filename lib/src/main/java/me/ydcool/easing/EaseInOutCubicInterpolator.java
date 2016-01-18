package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * @author ydcool
 */
public class EaseInOutCubicInterpolator implements Interpolator {
    private float b;
    private float c;

    public EaseInOutCubicInterpolator() {
        this.b = 0;
        this.c = 4;
    }

    public EaseInOutCubicInterpolator(float beginIngValue, float changeInValue) {
        this.b = beginIngValue;
        this.c = changeInValue;
    }

    public float getInterpolation(float t) {
        if (t < 0.5f)
            return c * t * t * t + b;
        return c * (t - 1) * (t - 1) * (t - 1) + 1 + b;
    }
}
