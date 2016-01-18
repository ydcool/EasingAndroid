package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * 
 * @author ydcool
 * 
 */
public class EaseInElasticInterpolator implements Interpolator {
	private int c;

	public EaseInElasticInterpolator() {
		this.c = 1;
	}

	@Override
	public float getInterpolation(float t) {
		// t *= 0.9f;
		// return (float) (1 - t * Math.sin(Math.PI * 2 * n * t));
		float s = 1.70158f;
		float p = 0;
		float a = c;
		if (t == 0)
			return 0;
		if (t == 1)
			return c;
		if (p == 0)
			p = 0.3f;
		if (a < Math.abs(c)) {
			a = c;
			s = p / 4;
		} else
			s = (float) (p / (2 * Math.PI) * Math.asin(c / a));
		return (float) -(a * Math.pow(2, 10 * (t -= 1)) * Math.sin((t - s)
				* (2 * Math.PI) / p));
	}
}
