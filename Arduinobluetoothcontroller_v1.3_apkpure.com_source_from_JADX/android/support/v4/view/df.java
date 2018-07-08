package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;

class df implements bm {
    final /* synthetic */ ViewPager f995a;
    private final Rect f996b = new Rect();

    df(ViewPager viewPager) {
        this.f995a = viewPager;
    }

    public es mo69a(View view, es esVar) {
        es a = bv.m2001a(view, esVar);
        if (a.mo419e()) {
            return a;
        }
        Rect rect = this.f996b;
        rect.left = a.mo414a();
        rect.top = a.mo416b();
        rect.right = a.mo417c();
        rect.bottom = a.mo418d();
        int childCount = this.f995a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            es b = bv.m2014b(this.f995a.getChildAt(i), a);
            rect.left = Math.min(b.mo414a(), rect.left);
            rect.top = Math.min(b.mo416b(), rect.top);
            rect.right = Math.min(b.mo417c(), rect.right);
            rect.bottom = Math.min(b.mo418d(), rect.bottom);
        }
        return a.mo415a(rect.left, rect.top, rect.right, rect.bottom);
    }
}
