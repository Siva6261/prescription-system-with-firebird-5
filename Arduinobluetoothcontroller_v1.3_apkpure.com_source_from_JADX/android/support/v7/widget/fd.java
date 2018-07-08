package android.support.v7.widget;

import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.v7.p005a.C0279d;
import android.support.v7.p018b.C0298b;
import android.support.v7.view.C0313a;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;

public class fd extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator f2284j = new DecelerateInterpolator();
    Runnable f2285a;
    int f2286b;
    int f2287c;
    private fg f2288d;
    private cq f2289e;
    private Spinner f2290f;
    private boolean f2291g;
    private int f2292h;
    private int f2293i;

    private fh m4689a(C0279d c0279d, boolean z) {
        fh fhVar = new fh(this, getContext(), c0279d, z);
        if (z) {
            fhVar.setBackgroundDrawable(null);
            fhVar.setLayoutParams(new LayoutParams(-1, this.f2292h));
        } else {
            fhVar.setFocusable(true);
            if (this.f2288d == null) {
                this.f2288d = new fg();
            }
            fhVar.setOnClickListener(this.f2288d);
        }
        return fhVar;
    }

    private boolean m4691a() {
        return this.f2290f != null && this.f2290f.getParent() == this;
    }

    private void m4692b() {
        if (!m4691a()) {
            if (this.f2290f == null) {
                this.f2290f = m4694d();
            }
            removeView(this.f2289e);
            addView(this.f2290f, new ViewGroup.LayoutParams(-2, -1));
            if (this.f2290f.getAdapter() == null) {
                this.f2290f.setAdapter(new ff());
            }
            if (this.f2285a != null) {
                removeCallbacks(this.f2285a);
                this.f2285a = null;
            }
            this.f2290f.setSelection(this.f2293i);
        }
    }

    private boolean m4693c() {
        if (m4691a()) {
            removeView(this.f2290f);
            addView(this.f2289e, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f2290f.getSelectedItemPosition());
        }
        return false;
    }

    private Spinner m4694d() {
        Spinner bhVar = new bh(getContext(), null, C0298b.actionDropDownStyle);
        bhVar.setLayoutParams(new cr(-2, -1));
        bhVar.setOnItemSelectedListener(this);
        return bhVar;
    }

    public void m4695a(int i) {
        View childAt = this.f2289e.getChildAt(i);
        if (this.f2285a != null) {
            removeCallbacks(this.f2285a);
        }
        this.f2285a = new fe(this, childAt);
        post(this.f2285a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2285a != null) {
            post(this.f2285a);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        C0313a a = C0313a.m3230a(getContext());
        setContentHeight(a.m3235e());
        this.f2287c = a.m3237g();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2285a != null) {
            removeCallbacks(this.f2285a);
        }
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        ((fh) view).m4698b().m3159d();
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f2289e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f2286b = -1;
        } else {
            if (childCount > 2) {
                this.f2286b = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f2286b = MeasureSpec.getSize(i) / 2;
            }
            this.f2286b = Math.min(this.f2286b, this.f2287c);
        }
        mode = MeasureSpec.makeMeasureSpec(this.f2292h, 1073741824);
        if (z || !this.f2291g) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.f2289e.measure(0, mode);
            if (this.f2289e.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                m4692b();
            } else {
                m4693c();
            }
        } else {
            m4693c();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.f2293i);
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f2291g = z;
    }

    public void setContentHeight(int i) {
        this.f2292h = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.f2293i = i;
        int childCount = this.f2289e.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f2289e.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                m4695a(i);
            }
            i2++;
        }
        if (this.f2290f != null && i >= 0) {
            this.f2290f.setSelection(i);
        }
    }
}
