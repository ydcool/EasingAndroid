package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * 
 * @author ydcool
 * 
 */
public class EaseOutSineInterpolator implements Interpolator {
	private float b;
	private float c;

	public EaseOutSineInterpolator() {
		b = 0;
		c = 1;
	}

	public EaseOutSineInterpolator(float beginIngValue, float changeInValue) {
		this.b = beginIngValue;
		this.c = changeInValue;
	}

	public float getInterpolation(float t) {
		return (float) (c * Math.sin(t * (Math.PI / 2)) + b);
	}
}
