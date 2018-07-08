package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.bv;
import android.support.v7.p018b.C0308l;
import android.util.AttributeSet;
import android.view.View;

class am {
    private final View f1930a;
    private final aq f1931b;
    private gd f1932c;
    private gd f1933d;
    private gd f1934e;

    am(View view, aq aqVar) {
        this.f1930a = view;
        this.f1931b = aqVar;
    }

    private boolean m4055b(Drawable drawable) {
        return VERSION.SDK_INT == 21 && (drawable instanceof GradientDrawable);
    }

    private void m4056c(Drawable drawable) {
        if (this.f1934e == null) {
            this.f1934e = new gd();
        }
        gd gdVar = this.f1934e;
        gdVar.m4784a();
        ColorStateList x = bv.m2047x(this.f1930a);
        if (x != null) {
            gdVar.f2376d = true;
            gdVar.f2373a = x;
        }
        Mode y = bv.m2048y(this.f1930a);
        if (y != null) {
            gdVar.f2375c = true;
            gdVar.f2374b = y;
        }
        if (gdVar.f2376d || gdVar.f2375c) {
            aq.m4082a(drawable, gdVar, this.f1930a.getDrawableState());
        }
    }

    ColorStateList m4057a() {
        return this.f1933d != null ? this.f1933d.f2373a : null;
    }

    void m4058a(int i) {
        m4064b(this.f1931b != null ? this.f1931b.m4103b(this.f1930a.getContext(), i) : null);
    }

    void m4059a(ColorStateList colorStateList) {
        if (this.f1933d == null) {
            this.f1933d = new gd();
        }
        this.f1933d.f2373a = colorStateList;
        this.f1933d.f2376d = true;
        m4065c();
    }

    void m4060a(Mode mode) {
        if (this.f1933d == null) {
            this.f1933d = new gd();
        }
        this.f1933d.f2374b = mode;
        this.f1933d.f2375c = true;
        m4065c();
    }

    void m4061a(Drawable drawable) {
        m4064b(null);
    }

    void m4062a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f1930a.getContext().obtainStyledAttributes(attributeSet, C0308l.ViewBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0308l.ViewBackgroundHelper_android_background)) {
                ColorStateList b = this.f1931b.m4103b(this.f1930a.getContext(), obtainStyledAttributes.getResourceId(C0308l.ViewBackgroundHelper_android_background, -1));
                if (b != null) {
                    m4064b(b);
                }
            }
            if (obtainStyledAttributes.hasValue(C0308l.ViewBackgroundHelper_backgroundTint)) {
                bv.m2006a(this.f1930a, obtainStyledAttributes.getColorStateList(C0308l.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(C0308l.ViewBackgroundHelper_backgroundTintMode)) {
                bv.m2007a(this.f1930a, cj.m4346a(obtainStyledAttributes.getInt(C0308l.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    Mode m4063b() {
        return this.f1933d != null ? this.f1933d.f2374b : null;
    }

    void m4064b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1932c == null) {
                this.f1932c = new gd();
            }
            this.f1932c.f2373a = colorStateList;
            this.f1932c.f2376d = true;
        } else {
            this.f1932c = null;
        }
        m4065c();
    }

    void m4065c() {
        Drawable background = this.f1930a.getBackground();
        if (background == null) {
            return;
        }
        if (this.f1933d != null) {
            aq.m4082a(background, this.f1933d, this.f1930a.getDrawableState());
        } else if (this.f1932c != null) {
            aq.m4082a(background, this.f1932c, this.f1930a.getDrawableState());
        } else if (m4055b(background)) {
            m4056c(background);
        }
    }
}
