package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * 
 * @author ydcool
 * 
 */
public class EaseOutTSinInterpolator implements Interpolator {
	private int n;

	/**
	 * 
	 * @param n
	 *            repeat count
	 */
	public EaseOutTSinInterpolator(int n) {
		this.n = n;
	}

	@Override
	public float getInterpolation(float t) {
		// t *= 0.9f;
		return (float) ((1 - t) * Math.sin(Math.PI * 2 * n * t));
	}
}
