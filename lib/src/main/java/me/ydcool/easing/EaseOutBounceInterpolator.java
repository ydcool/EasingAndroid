package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * @author ydcool
 */
public class EaseOutBounceInterpolator implements Interpolator {

    public EaseOutBounceInterpolator() {
    }

    private static float bounce(float t) {
        return t * t * 8.0f;
    }

    public float getInterpolation(float t) {
        // t *= 1.1226f;
        if (t < 0.3535f)
            return bounce(t);
        else if (t < 0.7408f)
            return bounce(t - 0.54719f) + 0.7f;
        else if (t < 0.9644f)
            return bounce(t - 0.8526f) + 0.9f;
        else
            return bounce(t - 1.0435f) + 0.95f;
    }
}
