package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * @author ydcool
 */
public class EaseInOutBackInterpolator implements Interpolator {

    public EaseInOutBackInterpolator() {
    }

    public float getInterpolation(float t) {
        if (t < 0.5f) {
            EaseInBackInterpolator mInBack = new EaseInBackInterpolator();
            return mInBack.getInterpolation(2f * t) * 0.5f;
        } else {
            EaseOutBackInterpolator mOutBack = new EaseOutBackInterpolator();
            return mOutBack.getInterpolation(2f * t - 1f) * 0.5f + 0.5f;
        }

    }
}
