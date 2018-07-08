package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class ej extends MarginLayoutParams {
    ey f2123a;
    final Rect f2124b = new Rect();
    boolean f2125c = true;
    boolean f2126d = false;

    public ej(int i, int i2) {
        super(i, i2);
    }

    public ej(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ej(ej ejVar) {
        super(ejVar);
    }

    public ej(LayoutParams layoutParams) {
        super(layoutParams);
    }

    public ej(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public boolean m4358c() {
        return this.f2123a.m4660q();
    }

    public boolean m4359d() {
        return this.f2123a.m4667x();
    }

    public int m4360e() {
        return this.f2123a.m4647d();
    }
}
