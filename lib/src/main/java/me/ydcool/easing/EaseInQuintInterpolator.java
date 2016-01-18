package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * 
 * @author ydcool
 * 
 */
public class EaseInQuintInterpolator implements Interpolator {
	private float b;
	private float c;

	public EaseInQuintInterpolator() {
		this.b = 0;
		this.c = 1;
	}

	public EaseInQuintInterpolator(float beginIngValue, float changeInValue) {
		this.b = beginIngValue;
		this.c = changeInValue;
	}

	public float getInterpolation(float t) {
		return c * t * t * t * t * t + b;
	}
}
