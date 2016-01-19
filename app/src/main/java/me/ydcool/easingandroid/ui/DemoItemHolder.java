package me.ydcool.easingandroid.ui;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import me.ydcool.easingandroid.R;

/**
 * Created by ydcool on 16/1/19.
 *
 * @author ydcool
 */
public class DemoItemHolder extends RecyclerView.ViewHolder {
    public CardView mCardView;
    public CurveView mCurveView;

    public DemoItemHolder(View itemView) {
        super(itemView);
        mCurveView = (CurveView) itemView.findViewById(R.id.recycler_curveView);
        mCardView = (CardView) itemView.findViewById(R.id.recycler_cardView);
    }
}
