package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * @author ydcool
 */
public class EaseOutCircInterpolator implements Interpolator {
    private float b;
    private float c;

    public EaseOutCircInterpolator() {
        this.b = 0;
        this.c = 1;
    }

    public EaseOutCircInterpolator(float beginIngValue, float changeInValue) {
        this.b = beginIngValue;
        this.c = changeInValue;
    }

    public float getInterpolation(float t) {
        return (float) (c * Math.sqrt(t) + b);
    }
}
