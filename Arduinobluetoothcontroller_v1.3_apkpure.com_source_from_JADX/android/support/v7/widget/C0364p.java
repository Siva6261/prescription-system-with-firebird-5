package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p010d.p011a.C0106a;
import android.support.v7.p018b.C0298b;

class C0364p extends az implements C0324u {
    final /* synthetic */ C0359k f2446a;
    private final float[] f2447b = new float[2];

    public C0364p(C0359k c0359k, Context context) {
        this.f2446a = c0359k;
        super(context, null, C0298b.actionOverflowButtonStyle);
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnTouchListener(new C0365q(this, this, c0359k));
    }

    public boolean mo583c() {
        return false;
    }

    public boolean mo584d() {
        return false;
    }

    public boolean performClick() {
        if (!super.performClick()) {
            playSoundEffect(0);
            this.f2446a.m4923d();
        }
        return true;
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (!(drawable == null || background == null)) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(width, height) / 2;
            width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            C0106a.m1335a(background, width - max, height - max, width + max, height + max);
        }
        return frame;
    }
}
