package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * 
 * @author ydcool
 * 
 */
public class EaseInSineInterpolator implements Interpolator {
	private float b;
	private float c;

	public EaseInSineInterpolator() {
		b = 0;
		c = 1;
	}

	public EaseInSineInterpolator(float beginIngValue, float changeInValue) {
		this.b = beginIngValue;
		this.c = changeInValue;
	}

	public float getInterpolation(float t) {
		return (float) (-c * Math.cos(t * (Math.PI / 2)) + c + b);
	}
}
