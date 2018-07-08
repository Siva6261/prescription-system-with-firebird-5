package android.support.v7.widget;

import android.content.Context;
import android.support.v7.p005a.C0275b;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class gk extends C0275b {
    int f2386b;

    public gk(int i, int i2) {
        super(i, i2);
        this.f2386b = 0;
        this.a = 8388627;
    }

    public gk(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2386b = 0;
    }

    public gk(C0275b c0275b) {
        super(c0275b);
        this.f2386b = 0;
    }

    public gk(gk gkVar) {
        super((C0275b) gkVar);
        this.f2386b = 0;
        this.f2386b = gkVar.f2386b;
    }

    public gk(LayoutParams layoutParams) {
        super(layoutParams);
        this.f2386b = 0;
    }

    public gk(MarginLayoutParams marginLayoutParams) {
        super((LayoutParams) marginLayoutParams);
        this.f2386b = 0;
        m4813a(marginLayoutParams);
    }

    void m4813a(MarginLayoutParams marginLayoutParams) {
        this.leftMargin = marginLayoutParams.leftMargin;
        this.topMargin = marginLayoutParams.topMargin;
        this.rightMargin = marginLayoutParams.rightMargin;
        this.bottomMargin = marginLayoutParams.bottomMargin;
    }
}
