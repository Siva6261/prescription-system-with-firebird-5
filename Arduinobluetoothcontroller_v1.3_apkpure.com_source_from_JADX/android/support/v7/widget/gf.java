package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class gf {
    private final Context f2378a;
    private final TypedArray f2379b;

    private gf(Context context, TypedArray typedArray) {
        this.f2378a = context;
        this.f2379b = typedArray;
    }

    public static gf m4786a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new gf(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static gf m4787a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new gf(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public float m4788a(int i, float f) {
        return this.f2379b.getFloat(i, f);
    }

    public int m4789a(int i, int i2) {
        return this.f2379b.getInt(i, i2);
    }

    public Drawable m4790a(int i) {
        if (this.f2379b.hasValue(i)) {
            int resourceId = this.f2379b.getResourceId(i, 0);
            if (resourceId != 0) {
                return aq.m4079a().m4100a(this.f2378a, resourceId);
            }
        }
        return this.f2379b.getDrawable(i);
    }

    public void m4791a() {
        this.f2379b.recycle();
    }

    public boolean m4792a(int i, boolean z) {
        return this.f2379b.getBoolean(i, z);
    }

    public int m4793b(int i, int i2) {
        return this.f2379b.getColor(i, i2);
    }

    public Drawable m4794b(int i) {
        if (this.f2379b.hasValue(i)) {
            int resourceId = this.f2379b.getResourceId(i, 0);
            if (resourceId != 0) {
                return aq.m4079a().m4101a(this.f2378a, resourceId, true);
            }
        }
        return null;
    }

    public int m4795c(int i, int i2) {
        return this.f2379b.getInteger(i, i2);
    }

    public CharSequence m4796c(int i) {
        return this.f2379b.getText(i);
    }

    public int m4797d(int i, int i2) {
        return this.f2379b.getDimensionPixelOffset(i, i2);
    }

    public String m4798d(int i) {
        return this.f2379b.getString(i);
    }

    public int m4799e(int i, int i2) {
        return this.f2379b.getDimensionPixelSize(i, i2);
    }

    public CharSequence[] m4800e(int i) {
        return this.f2379b.getTextArray(i);
    }

    public int m4801f(int i, int i2) {
        return this.f2379b.getLayoutDimension(i, i2);
    }

    public boolean m4802f(int i) {
        return this.f2379b.hasValue(i);
    }

    public int m4803g(int i, int i2) {
        return this.f2379b.getResourceId(i, i2);
    }
}
