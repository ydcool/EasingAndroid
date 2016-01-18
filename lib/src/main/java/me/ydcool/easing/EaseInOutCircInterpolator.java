package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * @author ydcool
 */
public class EaseInOutCircInterpolator implements Interpolator {
    private float b;
    private float c;

    public EaseInOutCircInterpolator() {
        this.b = 0;
        this.c = 1;
    }

    public EaseInOutCircInterpolator(float beginIngValue, float changeInValue) {
        this.b = beginIngValue;
        this.c = changeInValue;
    }

    public float getInterpolation(float t) {
        if (t < 0.5f)
            return (float) ((1 - c * Math.sqrt(1 - 4 * t * t)) / 2);
        return (float) ((c * Math.sqrt(2 * t - 1) + b) / 2 + 0.5f);
    }
}
