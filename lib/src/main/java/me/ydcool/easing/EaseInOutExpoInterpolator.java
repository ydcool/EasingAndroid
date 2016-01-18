package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * 
 * @author ydcool
 * 
 */
public class EaseInOutExpoInterpolator implements Interpolator {
	private float b;
	private float c;

	public EaseInOutExpoInterpolator() {
		this.b = 0;
		this.c = 32;
	}

	public EaseInOutExpoInterpolator(float beginIngValue, float changeInValue) {
		this.b = beginIngValue;
		this.c = changeInValue;
	}

	public float getInterpolation(float t) {
		if (t < 0.5f)
			return c * t * t * t * t * t * t + b;
		return -c * (t - 1) * (t - 1) * (t - 1) * (t - 1) * (t - 1) * (t - 1)
				+ 1 + b;
	}
}
