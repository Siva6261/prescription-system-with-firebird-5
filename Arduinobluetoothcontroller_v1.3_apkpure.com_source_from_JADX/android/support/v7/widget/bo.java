package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0308l;
import android.support.v7.p020e.C0311a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class bo {
    private static final int[] f2050b = new int[]{16842804, 16843119, 16843117, 16843120, 16843118};
    private static final int[] f2051c = new int[]{C0298b.textAllCaps};
    final TextView f2052a;
    private gd f2053d;
    private gd f2054e;
    private gd f2055f;
    private gd f2056g;

    bo(TextView textView) {
        this.f2052a = textView;
    }

    static bo m4174a(TextView textView) {
        return VERSION.SDK_INT >= 17 ? new bp(textView) : new bo(textView);
    }

    protected static gd m4175a(Context context, aq aqVar, int i) {
        ColorStateList b = aqVar.m4103b(context, i);
        if (b == null) {
            return null;
        }
        gd gdVar = new gd();
        gdVar.f2376d = true;
        gdVar.f2373a = b;
        return gdVar;
    }

    void mo708a() {
        if (this.f2053d != null || this.f2054e != null || this.f2055f != null || this.f2056g != null) {
            Drawable[] compoundDrawables = this.f2052a.getCompoundDrawables();
            m4178a(compoundDrawables[0], this.f2053d);
            m4178a(compoundDrawables[1], this.f2054e);
            m4178a(compoundDrawables[2], this.f2055f);
            m4178a(compoundDrawables[3], this.f2056g);
        }
    }

    void m4177a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, f2051c);
        if (obtainStyledAttributes.getBoolean(0, false)) {
            m4180a(true);
        }
        obtainStyledAttributes.recycle();
    }

    final void m4178a(Drawable drawable, gd gdVar) {
        if (drawable != null && gdVar != null) {
            aq.m4082a(drawable, gdVar, this.f2052a.getDrawableState());
        }
    }

    void mo709a(AttributeSet attributeSet, int i) {
        int i2 = 1;
        Context context = this.f2052a.getContext();
        aq a = aq.m4079a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2050b, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (obtainStyledAttributes.hasValue(1)) {
            this.f2053d = m4175a(context, a, obtainStyledAttributes.getResourceId(1, 0));
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.f2054e = m4175a(context, a, obtainStyledAttributes.getResourceId(2, 0));
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.f2055f = m4175a(context, a, obtainStyledAttributes.getResourceId(3, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.f2056g = m4175a(context, a, obtainStyledAttributes.getResourceId(4, 0));
        }
        obtainStyledAttributes.recycle();
        if (!(this.f2052a.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            boolean z;
            int i3;
            boolean z2;
            if (resourceId != -1) {
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, C0308l.TextAppearance);
                if (obtainStyledAttributes2.hasValue(C0308l.TextAppearance_textAllCaps)) {
                    z = obtainStyledAttributes2.getBoolean(C0308l.TextAppearance_textAllCaps, false);
                    i3 = 1;
                } else {
                    z2 = false;
                    z = false;
                }
                obtainStyledAttributes2.recycle();
            } else {
                z2 = false;
                z = false;
            }
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f2051c, i, 0);
            if (obtainStyledAttributes3.hasValue(0)) {
                z = obtainStyledAttributes3.getBoolean(0, false);
            } else {
                i2 = i3;
            }
            obtainStyledAttributes3.recycle();
            if (i2 != 0) {
                m4180a(z);
            }
        }
    }

    void m4180a(boolean z) {
        this.f2052a.setTransformationMethod(z ? new C0311a(this.f2052a.getContext()) : null);
    }
}
