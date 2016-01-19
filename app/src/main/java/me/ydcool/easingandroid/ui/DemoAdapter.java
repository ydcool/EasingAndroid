package me.ydcool.easingandroid.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

import java.util.ArrayList;

import me.ydcool.easingandroid.R;

/**
 * Created by ydcool on 16/1/19.
 *
 * @author ydcool
 */
public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Class> mList;
    private LayoutInflater mInflater;

    public DemoAdapter(Context context, ArrayList<Class> list) {
        mList = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DemoItemHolder(mInflater.inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DemoItemHolder) {
            final DemoItemHolder mHolder = (DemoItemHolder) holder;

            try {
                mHolder.mCurveView.setInterpolator((Interpolator) mList.get(position).newInstance());
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }

            mHolder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mHolder.mCurveView.startCursorAnimation(1200);
                }
            });

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mHolder.mCardView.setElevation(10);

                mHolder.mCurveView.setOnCursorAnimListener(new AnimatorListenerAdapter() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onAnimationStart(Animator animation) {
                        super.onAnimationStart(animation);
                        mHolder.mCardView.setElevation(20);
                    }

                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        mHolder.mCardView.setElevation(10);
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }
}
