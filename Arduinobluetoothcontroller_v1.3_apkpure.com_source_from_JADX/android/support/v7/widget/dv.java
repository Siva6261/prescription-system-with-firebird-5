package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

class dv implements bt {
    final /* synthetic */ RecyclerView f2194a;

    dv(RecyclerView recyclerView) {
        this.f2194a = recyclerView;
    }

    public int mo747a() {
        return this.f2194a.getChildCount();
    }

    public int mo748a(View view) {
        return this.f2194a.indexOfChild(view);
    }

    public void mo749a(int i) {
        View childAt = this.f2194a.getChildAt(i);
        if (childAt != null) {
            this.f2194a.m156i(childAt);
        }
        this.f2194a.removeViewAt(i);
    }

    public void mo750a(View view, int i) {
        this.f2194a.addView(view, i);
        this.f2194a.m158j(view);
    }

    public void mo751a(View view, int i, LayoutParams layoutParams) {
        ey c = RecyclerView.m139c(view);
        if (c != null) {
            if (c.m4661r() || c.m4646c()) {
                c.m4656m();
            } else {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + c);
            }
        }
        this.f2194a.attachViewToParent(view, i, layoutParams);
    }

    public ey mo752b(View view) {
        return RecyclerView.m139c(view);
    }

    public View mo753b(int i) {
        return this.f2194a.getChildAt(i);
    }

    public void mo754b() {
        int a = mo747a();
        for (int i = 0; i < a; i++) {
            this.f2194a.m156i(mo753b(i));
        }
        this.f2194a.removeAllViews();
    }

    public void mo755c(int i) {
        View b = mo753b(i);
        if (b != null) {
            ey c = RecyclerView.m139c(b);
            if (c != null) {
                if (!c.m4661r() || c.m4646c()) {
                    c.m4645b(256);
                } else {
                    throw new IllegalArgumentException("called detach on an already detached child " + c);
                }
            }
        }
        this.f2194a.detachViewFromParent(i);
    }

    public void mo756c(View view) {
        ey c = RecyclerView.m139c(view);
        if (c != null) {
            c.m4635z();
        }
    }

    public void mo757d(View view) {
        ey c = RecyclerView.m139c(view);
        if (c != null) {
            c.m4623A();
        }
    }
}
