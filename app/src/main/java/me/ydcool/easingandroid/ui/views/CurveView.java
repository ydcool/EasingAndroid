package me.ydcool.easingandroid.ui.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import me.ydcool.easingandroid.utils.DensityUtil;

import static android.graphics.Canvas.ALL_SAVE_FLAG;

/**
 * Created by ydcool on 16/1/19.
 *
 * @author ydcool
 */
public class CurveView extends View {

    private static final String TAG = "CurveView";

    // The time interpolator to be used if none is set on the animation
    private static final TimeInterpolator sDefaultInterpolator =
            new AccelerateDecelerateInterpolator();

    private TimeInterpolator mInterpolator = sDefaultInterpolator;

    private Paint mPaint;

    private long mLongAnimTime;
    private int mScreenHeight;
    private int mScreenWidth;

    private int mWidth;
    private int mHeight;

    //padding in vertical
    private int mPaddingV;

    //padding in horizontal
    private int mPaddingH;

    private int xRange;
    private int yRange;

    private String mTitle;

    private float mCursorAnimtedValue;

    private boolean mCursorAnimRunning;

    private ValueAnimator mCursorAnimator;

    private Animator.AnimatorListener mCursorAnimatorListener;

    public CurveView(Context context) {
        super(context);
        init();
    }

    public CurveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CurveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mLongAnimTime = getContext().getResources().getInteger(android.R.integer.config_longAnimTime);
        mScreenHeight = DensityUtil.getInstance(getContext()).getScreenHeight();
        mScreenWidth = DensityUtil.getInstance(getContext()).getScreenWidth();
    }

    private void initParams() {
        if (mWidth == 0)
            mWidth = getWidth();

        if (mHeight == 0)
            mHeight = getHeight();

        if (mPaddingV == 0 && mHeight != 0) {
            mPaddingV = mHeight >> 3;
            yRange = mHeight - mPaddingV * 2;
        }

        if (mPaddingH == 0 && mWidth != 0) {
            mPaddingH = mWidth >> 3;
            xRange = mWidth - mPaddingH * 2;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int sc = canvas.saveLayer(0, 0, mScreenWidth, mScreenHeight, null, ALL_SAVE_FLAG);

        //get size if haven't set.
        initParams();

        //draw title text
        drawTitle(canvas);

        //draw border line.
        drawBorderLine(canvas);

        //draw curve
        drawCurve(canvas);

        if (mCursorAnimRunning) {
            //draw cursor
            drawCursor(canvas, mWidth - mPaddingH, (int) (mHeight - mPaddingV - yRange * mCursorAnimtedValue));

            //draw pointer
            drawPointer(canvas, mCursorAnimtedValue);
        }

        canvas.restoreToCount(sc);
    }

    private void drawTitle(Canvas canvas) {
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.DKGRAY);
        textPaint.setTextSize(15);
        textPaint.setAntiAlias(true);

        StaticLayout mText = new StaticLayout(
                mTitle,
                textPaint,
                mWidth,
                Layout.Alignment.ALIGN_CENTER,
                0.f, 1.f,
                false);

        int offsetY = (mPaddingV - mText.getHeight()) >> 1;
        canvas.translate(0, offsetY);
        mText.draw(canvas);
        canvas.translate(0, -offsetY);
    }

    private void drawBorderLine(Canvas canvas) {
        mPaint.setColor(Color.GRAY);

        //top line
        canvas.drawLine(mPaddingH, mPaddingV, mWidth - mPaddingH, mPaddingV, mPaint);

        //bottom line
        canvas.drawLine(mPaddingH, mHeight - mPaddingV, mWidth - mPaddingH, mHeight - mPaddingV, mPaint);
    }

    private void drawCurve(Canvas canvas) {
        mPaint.setColor(Color.BLACK);

        for (int i = 0; i < xRange; i++) {
            int x = mPaddingH + i;
            int y = (int) (mHeight - mPaddingV - mInterpolator.getInterpolation((float) i / (float) xRange) * yRange);

            canvas.drawPoint(x, y, mPaint);
        }
    }

    private void drawPointer(Canvas canvas, float percentage) {
        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(
                mPaddingH + (float) xRange * percentage,
                mHeight - mPaddingV - mInterpolator.getInterpolation(percentage) * yRange,
                2,
                mPaint);
    }

    private void drawCursor(Canvas canvas, int vertexX, int vertexY) {
        int cursorRadius = mPaddingH >> 2;

        Path cursor = new Path();

        cursor.moveTo(vertexX, vertexY);
        cursor.lineTo(vertexX + (float) (cursorRadius / 2 * Math.sqrt(3)), vertexY - cursorRadius / 2);
        cursor.lineTo(vertexX + cursorRadius * 2, vertexY - cursorRadius / 2);
        cursor.lineTo(vertexX + cursorRadius * 2, vertexY + cursorRadius / 2);
        cursor.lineTo(vertexX + (float) (cursorRadius / 2 * Math.sqrt(3)), vertexY + cursorRadius / 2);
        cursor.lineTo(vertexX, vertexY);
        cursor.close();

        mPaint.setColor(Color.RED);
        canvas.drawPath(cursor, mPaint);
    }

    public void setInterpolator(Interpolator interpolator) {
        if (interpolator != null)
            this.mInterpolator = interpolator;
        else
            this.mInterpolator = new LinearInterpolator();

        mTitle = mInterpolator.getClass().getSimpleName();
    }

    public void startCursorAnimation() {
        this.startCursorAnimation(mLongAnimTime);
    }

    public void startCursorAnimation(long duration) {
        if (mCursorAnimator != null)
            mCursorAnimator.cancel();

        mCursorAnimator = ValueAnimator.ofFloat(0.f, 1.f);
        mCursorAnimator.setInterpolator(mInterpolator);
        mCursorAnimator.setDuration(duration);
        mCursorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCursorAnimtedValue = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });

        mCursorAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                mCursorAnimRunning = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mCursorAnimRunning = false;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                mCursorAnimRunning = false;
            }
        });

        if (mCursorAnimatorListener != null)
            mCursorAnimator.addListener(mCursorAnimatorListener);

        mCursorAnimator.start();
    }

    public void setOnCursorAnimListener(Animator.AnimatorListener listener) {
        this.mCursorAnimatorListener = listener;
    }
}
