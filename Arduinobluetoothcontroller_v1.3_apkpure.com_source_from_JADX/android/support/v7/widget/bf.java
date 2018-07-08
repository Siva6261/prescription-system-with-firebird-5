package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.bv;
import android.support.v7.p018b.C0298b;
import android.util.AttributeSet;
import android.widget.RatingBar;

public class bf extends RatingBar {
    private bd f1989a;
    private aq f1990b;

    public bf(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0298b.ratingBarStyle);
    }

    public bf(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1990b = aq.m4079a();
        this.f1989a = new bd(this, this.f1990b);
        this.f1989a.mo703a(attributeSet, i);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap a = this.f1989a.m4121a();
        if (a != null) {
            setMeasuredDimension(bv.m1999a(a.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
