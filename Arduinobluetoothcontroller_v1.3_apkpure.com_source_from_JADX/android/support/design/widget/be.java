package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.C0230q;
import android.support.v4.view.bv;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

abstract class be extends cz {
    private final Rect f185a = new Rect();
    private final Rect f186b = new Rect();
    private int f187c = 0;
    private int f188d;

    public be(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static int m296c(int i) {
        return i == 0 ? 8388659 : i;
    }

    float mo55a(View view) {
        return 1.0f;
    }

    final int m298a() {
        return this.f187c;
    }

    abstract View mo56a(List list);

    public boolean mo53a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View a = mo56a(coordinatorLayout.m424d(view));
            if (a != null) {
                if (bv.m2043t(a) && !bv.m2043t(view)) {
                    bv.m2012a(view, true);
                    if (bv.m2043t(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                if (bv.m1994A(a)) {
                    int size = MeasureSpec.getSize(i3);
                    if (size == 0) {
                        size = coordinatorLayout.getHeight();
                    }
                    coordinatorLayout.m409a(view, i, i2, MeasureSpec.makeMeasureSpec(mo57b(a) + (size - a.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                    return true;
                }
            }
        }
        return false;
    }

    int mo57b(View view) {
        return view.getMeasuredHeight();
    }

    public final void m302b(int i) {
        this.f188d = i;
    }

    protected void mo54b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View a = mo56a(coordinatorLayout.m424d(view));
        if (a != null) {
            ae aeVar = (ae) view.getLayoutParams();
            Rect rect = this.f185a;
            rect.set(coordinatorLayout.getPaddingLeft() + aeVar.leftMargin, a.getBottom() + aeVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - aeVar.rightMargin, ((coordinatorLayout.getHeight() + a.getBottom()) - coordinatorLayout.getPaddingBottom()) - aeVar.bottomMargin);
            Rect rect2 = this.f186b;
            C0230q.m2510a(m296c(aeVar.f311c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int c = m304c(a);
            view.layout(rect2.left, rect2.top - c, rect2.right, rect2.bottom - c);
            this.f187c = rect2.top - a.getBottom();
            return;
        }
        super.mo54b(coordinatorLayout, view, i);
        this.f187c = 0;
    }

    final int m304c(View view) {
        return this.f188d == 0 ? 0 : bf.m609a(Math.round(mo55a(view) * ((float) this.f188d)), 0, this.f188d);
    }
}
