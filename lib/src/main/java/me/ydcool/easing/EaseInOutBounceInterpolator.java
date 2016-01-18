package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * @author ydcool
 */
public class EaseInOutBounceInterpolator implements Interpolator {

    public EaseInOutBounceInterpolator() {
    }

    public float getInterpolation(float t) {
        if (t < 0.5f) {
            EaseInBounceInterpolator mInBounce = new EaseInBounceInterpolator();
            return mInBounce.getInterpolation(2f * t) * 0.5f;
        } else {
            EaseOutBounceInterpolator mOutBounce = new EaseOutBounceInterpolator();
            return mOutBounce.getInterpolation(2f * t - 1f) * 0.5f + 0.5f;
        }
    }
}
