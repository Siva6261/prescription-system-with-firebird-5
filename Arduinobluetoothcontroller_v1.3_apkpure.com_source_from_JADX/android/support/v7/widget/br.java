package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class br {
    final bt f2060a;
    final bs f2061b = new bs();
    final List f2062c = new ArrayList();

    br(bt btVar) {
        this.f2060a = btVar;
    }

    private int m4183e(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.f2060a.mo747a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.f2061b.m4210e(i2));
            if (e == 0) {
                while (this.f2061b.m4208c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    private void m4184g(View view) {
        this.f2062c.add(view);
        this.f2060a.mo756c(view);
    }

    private boolean m4185h(View view) {
        if (!this.f2062c.remove(view)) {
            return false;
        }
        this.f2060a.mo757d(view);
        return true;
    }

    View m4186a(int i, int i2) {
        int size = this.f2062c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.f2062c.get(i3);
            ey b = this.f2060a.mo752b(view);
            if (b.m4647d() == i && !b.m4657n() && !b.m4660q() && (i2 == -1 || b.m4651h() == i2)) {
                return view;
            }
        }
        return null;
    }

    void m4187a() {
        this.f2061b.m4204a();
        for (int size = this.f2062c.size() - 1; size >= 0; size--) {
            this.f2060a.mo757d((View) this.f2062c.get(size));
            this.f2062c.remove(size);
        }
        this.f2060a.mo754b();
    }

    void m4188a(int i) {
        int e = m4183e(i);
        View b = this.f2060a.mo753b(e);
        if (b != null) {
            if (this.f2061b.m4209d(e)) {
                m4185h(b);
            }
            this.f2060a.mo749a(e);
        }
    }

    void m4189a(View view) {
        int a = this.f2060a.mo748a(view);
        if (a >= 0) {
            if (this.f2061b.m4209d(a)) {
                m4185h(view);
            }
            this.f2060a.mo749a(a);
        }
    }

    void m4190a(View view, int i, LayoutParams layoutParams, boolean z) {
        int a = i < 0 ? this.f2060a.mo747a() : m4183e(i);
        this.f2061b.m4206a(a, z);
        if (z) {
            m4184g(view);
        }
        this.f2060a.mo751a(view, a, layoutParams);
    }

    void m4191a(View view, int i, boolean z) {
        int a = i < 0 ? this.f2060a.mo747a() : m4183e(i);
        this.f2061b.m4206a(a, z);
        if (z) {
            m4184g(view);
        }
        this.f2060a.mo750a(view, a);
    }

    void m4192a(View view, boolean z) {
        m4191a(view, -1, z);
    }

    int m4193b() {
        return this.f2060a.mo747a() - this.f2062c.size();
    }

    int m4194b(View view) {
        int a = this.f2060a.mo748a(view);
        return (a == -1 || this.f2061b.m4208c(a)) ? -1 : a - this.f2061b.m4210e(a);
    }

    View m4195b(int i) {
        return this.f2060a.mo753b(m4183e(i));
    }

    int m4196c() {
        return this.f2060a.mo747a();
    }

    View m4197c(int i) {
        return this.f2060a.mo753b(i);
    }

    boolean m4198c(View view) {
        return this.f2062c.contains(view);
    }

    void m4199d(int i) {
        int e = m4183e(i);
        this.f2061b.m4209d(e);
        this.f2060a.mo755c(e);
    }

    void m4200d(View view) {
        int a = this.f2060a.mo748a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f2061b.m4205a(a);
        m4184g(view);
    }

    void m4201e(View view) {
        int a = this.f2060a.mo748a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f2061b.m4208c(a)) {
            this.f2061b.m4207b(a);
            m4185h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    boolean m4202f(View view) {
        int a = this.f2060a.mo748a(view);
        if (a == -1) {
            return m4185h(view) ? true : true;
        } else {
            if (!this.f2061b.m4208c(a)) {
                return false;
            }
            this.f2061b.m4209d(a);
            if (m4185h(view)) {
                this.f2060a.mo749a(a);
            } else {
                this.f2060a.mo749a(a);
            }
            return true;
        }
    }

    public String toString() {
        return this.f2061b.toString() + ", hidden list:" + this.f2062c.size();
    }
}
