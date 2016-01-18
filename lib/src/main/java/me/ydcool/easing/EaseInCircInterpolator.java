package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * 
 * @author ydcool
 * 
 */
public class EaseInCircInterpolator implements Interpolator {
	private float b;
	private float c;

	public EaseInCircInterpolator() {
		this.b = 0;
		this.c = 1;
	}

	public EaseInCircInterpolator(float beginIngValue, float changeInValue) {
		this.b = beginIngValue;
		this.c = changeInValue;
	}

	public float getInterpolation(float t) {
		return (float) (-c * (Math.sqrt(1 - t * t) - 1) + b);
	}
}
