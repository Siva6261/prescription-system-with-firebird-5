package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

class bp extends bo {
    private static final int[] f2057b = new int[]{16843666, 16843667};
    private gd f2058c;
    private gd f2059d;

    bp(TextView textView) {
        super(textView);
    }

    void mo708a() {
        super.mo708a();
        if (this.f2058c != null || this.f2059d != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            m4178a(compoundDrawablesRelative[0], this.f2058c);
            m4178a(compoundDrawablesRelative[2], this.f2059d);
        }
    }

    void mo709a(AttributeSet attributeSet, int i) {
        super.mo709a(attributeSet, i);
        Context context = this.a.getContext();
        aq a = aq.m4079a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2057b, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f2058c = bo.m4175a(context, a, obtainStyledAttributes.getResourceId(0, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f2059d = bo.m4175a(context, a, obtainStyledAttributes.getResourceId(1, 0));
        }
        obtainStyledAttributes.recycle();
    }
}
