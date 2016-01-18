package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * 
 * @author ydcool
 * 
 */
public class EaseInBounceInterpolator implements Interpolator {

	public EaseInBounceInterpolator() {
	}

	private static float bounce(float t) {
		return t * t * 8.0f;
	}

	public float getInterpolation(float t) {
		if (t < 0.0356) {
			return 0.05f - bounce(-t + 0.0435f);
		} else if (t < 0.2592f) {
			return 0.1f - bounce(-t + 0.1474f);
		} else if (t < 0.6465f) {
			return 0.3f - bounce(-t + 0.45281f);
		} else {
			return 1 - bounce(1 - t);
		}
	}
}
