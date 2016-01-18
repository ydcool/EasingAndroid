package me.ydcool.easing;

import android.view.animation.Interpolator;

/**
 * 
 * @author ydcool
 * 
 */
public class EaseInOutElasticInterpolator implements Interpolator {

	public EaseInOutElasticInterpolator() {
	}

	public float getInterpolation(float t) {
		if (t < 0.5f) {
			EaseInElasticInterpolator mInBack = new EaseInElasticInterpolator();
			return mInBack.getInterpolation(2f * t) * 0.5f;
		} else {
			EaseOutElasticInterpolator mOutBack = new EaseOutElasticInterpolator();
			return mOutBack.getInterpolation(2f * t - 1f) * 0.5f + 0.5f;
		}
		// float s = 1.70158f;
		// float p = 0;
		// float a = c;
		// if (t == 0)
		// return 0;
		// if (t == 1)
		// return c;
		// if (p == 0)
		// p = 0.45f;
		// if (a < Math.abs(c)) {
		// a = c;
		// s = p / 4;
		// } else
		// s = (float) (p / (2 * Math.PI) * Math.asin(c / a));
		// if (t < 1)
		// return (float) (-.5 * (a * Math.pow(2, 10 * (t -= 1)) * Math
		// .sin((t - s) * (2 * Math.PI) / p)));
		// return (float) (a * Math.pow(2, -10 * (t -= 1))
		// * Math.sin((t - s) * (2 * Math.PI) / p) * .5 + c);
	}
}
