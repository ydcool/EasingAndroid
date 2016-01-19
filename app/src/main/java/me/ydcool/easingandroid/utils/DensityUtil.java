package me.ydcool.easingandroid.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * @author ydcool
 */
public class DensityUtil {

    private static DensityUtil du;
    private final String TAG = DensityUtil.class.getSimpleName();
    private float dmDensityDpi = 0.0f;
    private float scale = 0.0f;
    private DisplayMetrics dm;
    private Context mContext;

    public DensityUtil(Context context) {
        this.mContext = context;
        dm = new DisplayMetrics();

        dm = context.getApplicationContext().getResources().getDisplayMetrics();
        dmDensityDpi = dm.densityDpi;
        scale = getDmDensityDpi() / 160;
    }

    public static DensityUtil getInstance(Context context) {
        if (du == null) {
            du = new DensityUtil(context);
        }
        return du;
    }

    public int getScreenWidth() {
        return dm.widthPixels;
    }

    public int getScreenHeight() {
        return dm.heightPixels;
    }

    public float getDmDensityDpi() {
        return dmDensityDpi;
    }

    public int getNavigationHeight() {
        Resources resources = mContext.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    public int dip2px(float dipValue) {
        return (int) (dipValue * scale + 0.5f);
    }

    public int px2dip(float pxValue) {
        return (int) (pxValue / scale + 0.5f);
    }

    @Override
    public String toString() {
        return " dmDensityDpi:" + dmDensityDpi;
    }
}
