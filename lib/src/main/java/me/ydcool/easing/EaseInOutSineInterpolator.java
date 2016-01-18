package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * @author ydcool
 */
public class EaseInOutSineInterpolator implements Interpolator {
    private float b;
    private float c;

    public EaseInOutSineInterpolator() {
        b = 0;
        c = 1;
    }

    public EaseInOutSineInterpolator(float beginIngValue, float changeInValue) {
        this.b = beginIngValue;
        this.c = changeInValue;
    }

    public float getInterpolation(float t) {
        return (float) (-c / 2 * (Math.cos(Math.PI * t) - 1) + b);
    }
}
