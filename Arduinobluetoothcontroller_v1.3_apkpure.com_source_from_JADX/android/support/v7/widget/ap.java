package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p010d.p011a.C0106a;
import android.support.v4.widget.C0246e;
import android.support.v7.p018b.C0308l;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class ap {
    private final CompoundButton f1940a;
    private final aq f1941b;
    private ColorStateList f1942c = null;
    private Mode f1943d = null;
    private boolean f1944e = false;
    private boolean f1945f = false;
    private boolean f1946g;

    ap(CompoundButton compoundButton, aq aqVar) {
        this.f1940a = compoundButton;
        this.f1941b = aqVar;
    }

    int m4066a(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = C0246e.m2765a(this.f1940a);
        return a != null ? i + a.getIntrinsicWidth() : i;
    }

    ColorStateList m4067a() {
        return this.f1942c;
    }

    void m4068a(ColorStateList colorStateList) {
        this.f1942c = colorStateList;
        this.f1944e = true;
        m4073d();
    }

    void m4069a(Mode mode) {
        this.f1943d = mode;
        this.f1945f = true;
        m4073d();
    }

    void m4070a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f1940a.getContext().obtainStyledAttributes(attributeSet, C0308l.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0308l.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(C0308l.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.f1940a.setButtonDrawable(this.f1941b.m4100a(this.f1940a.getContext(), resourceId));
                }
            }
            if (obtainStyledAttributes.hasValue(C0308l.CompoundButton_buttonTint)) {
                C0246e.m2766a(this.f1940a, obtainStyledAttributes.getColorStateList(C0308l.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(C0308l.CompoundButton_buttonTintMode)) {
                C0246e.m2767a(this.f1940a, cj.m4346a(obtainStyledAttributes.getInt(C0308l.CompoundButton_buttonTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    Mode m4071b() {
        return this.f1943d;
    }

    void m4072c() {
        if (this.f1946g) {
            this.f1946g = false;
            return;
        }
        this.f1946g = true;
        m4073d();
    }

    void m4073d() {
        Drawable a = C0246e.m2765a(this.f1940a);
        if (a == null) {
            return;
        }
        if (this.f1944e || this.f1945f) {
            a = C0106a.m1346f(a).mutate();
            if (this.f1944e) {
                C0106a.m1336a(a, this.f1942c);
            }
            if (this.f1945f) {
                C0106a.m1339a(a, this.f1943d);
            }
            if (a.isStateful()) {
                a.setState(this.f1940a.getDrawableState());
            }
            this.f1940a.setButtonDrawable(a);
        }
    }
}
