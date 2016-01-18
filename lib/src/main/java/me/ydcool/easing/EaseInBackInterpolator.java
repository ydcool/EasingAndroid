package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * @author ydcool
 */
public class EaseInBackInterpolator implements Interpolator {
    private float b;
    private float c;

    public EaseInBackInterpolator() {
        this.b = 0;
        this.c = 1;
    }

    public EaseInBackInterpolator(float beginIngValue, float changeInValue) {
        this.b = beginIngValue;
        this.c = changeInValue;
    }

    public float getInterpolation(float t) {
        float s = 1.70158f;
        return c * t * t * ((s + 1) * t - s) + b;
    }
}
