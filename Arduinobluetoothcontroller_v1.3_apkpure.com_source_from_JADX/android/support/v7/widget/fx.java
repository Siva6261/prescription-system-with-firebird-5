package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

class fx {
    int f2333a;
    int f2334b;
    int f2335c;
    final int f2336d;
    final /* synthetic */ StaggeredGridLayoutManager f2337e;
    private ArrayList f2338f;

    private fx(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.f2337e = staggeredGridLayoutManager;
        this.f2338f = new ArrayList();
        this.f2333a = Integer.MIN_VALUE;
        this.f2334b = Integer.MIN_VALUE;
        this.f2335c = 0;
        this.f2336d = i;
    }

    int m4734a(int i) {
        if (this.f2333a != Integer.MIN_VALUE) {
            return this.f2333a;
        }
        if (this.f2338f.size() == 0) {
            return i;
        }
        m4736a();
        return this.f2333a;
    }

    public View m4735a(int i, int i2) {
        View view = null;
        int size;
        View view2;
        if (i2 == -1) {
            size = this.f2338f.size();
            int i3 = 0;
            while (i3 < size) {
                view2 = (View) this.f2338f.get(i3);
                if (!view2.isFocusable()) {
                    break;
                }
                if ((this.f2337e.m3694d(view2) > i) != this.f2337e.f1848l) {
                    break;
                }
                i3++;
                view = view2;
            }
            return view;
        }
        size = this.f2338f.size() - 1;
        while (size >= 0) {
            view2 = (View) this.f2338f.get(size);
            if (!view2.isFocusable()) {
                break;
            }
            if ((this.f2337e.m3694d(view2) > i ? 1 : null) != (!this.f2337e.f1848l ? 1 : null)) {
                break;
            }
            size--;
            view = view2;
        }
        return view;
    }

    void m4736a() {
        View view = (View) this.f2338f.get(0);
        fr c = m4742c(view);
        this.f2333a = this.f2337e.f1837a.mo731a(view);
        if (c.f2316f) {
            ft f = this.f2337e.f1842f.m4725f(c.m4360e());
            if (f != null && f.f2320b == -1) {
                this.f2333a -= f.m4726a(this.f2336d);
            }
        }
    }

    void m4737a(View view) {
        fr c = m4742c(view);
        c.f2315e = this;
        this.f2338f.add(0, view);
        this.f2333a = Integer.MIN_VALUE;
        if (this.f2338f.size() == 1) {
            this.f2334b = Integer.MIN_VALUE;
        }
        if (c.m4358c() || c.m4359d()) {
            this.f2335c += this.f2337e.f1837a.mo735c(view);
        }
    }

    void m4738a(boolean z, int i) {
        int b = z ? m4740b(Integer.MIN_VALUE) : m4734a(Integer.MIN_VALUE);
        m4747e();
        if (b != Integer.MIN_VALUE) {
            if (z && b < this.f2337e.f1837a.mo736d()) {
                return;
            }
            if (z || b <= this.f2337e.f1837a.mo734c()) {
                if (i != Integer.MIN_VALUE) {
                    b += i;
                }
                this.f2334b = b;
                this.f2333a = b;
            }
        }
    }

    int m4739b() {
        if (this.f2333a != Integer.MIN_VALUE) {
            return this.f2333a;
        }
        m4736a();
        return this.f2333a;
    }

    int m4740b(int i) {
        if (this.f2334b != Integer.MIN_VALUE) {
            return this.f2334b;
        }
        if (this.f2338f.size() == 0) {
            return i;
        }
        m4743c();
        return this.f2334b;
    }

    void m4741b(View view) {
        fr c = m4742c(view);
        c.f2315e = this;
        this.f2338f.add(view);
        this.f2334b = Integer.MIN_VALUE;
        if (this.f2338f.size() == 1) {
            this.f2333a = Integer.MIN_VALUE;
        }
        if (c.m4358c() || c.m4359d()) {
            this.f2335c += this.f2337e.f1837a.mo735c(view);
        }
    }

    fr m4742c(View view) {
        return (fr) view.getLayoutParams();
    }

    void m4743c() {
        View view = (View) this.f2338f.get(this.f2338f.size() - 1);
        fr c = m4742c(view);
        this.f2334b = this.f2337e.f1837a.mo733b(view);
        if (c.f2316f) {
            ft f = this.f2337e.f1842f.m4725f(c.m4360e());
            if (f != null && f.f2320b == 1) {
                this.f2334b = f.m4726a(this.f2336d) + this.f2334b;
            }
        }
    }

    void m4744c(int i) {
        this.f2333a = i;
        this.f2334b = i;
    }

    int m4745d() {
        if (this.f2334b != Integer.MIN_VALUE) {
            return this.f2334b;
        }
        m4743c();
        return this.f2334b;
    }

    void m4746d(int i) {
        if (this.f2333a != Integer.MIN_VALUE) {
            this.f2333a += i;
        }
        if (this.f2334b != Integer.MIN_VALUE) {
            this.f2334b += i;
        }
    }

    void m4747e() {
        this.f2338f.clear();
        m4748f();
        this.f2335c = 0;
    }

    void m4748f() {
        this.f2333a = Integer.MIN_VALUE;
        this.f2334b = Integer.MIN_VALUE;
    }

    void m4749g() {
        int size = this.f2338f.size();
        View view = (View) this.f2338f.remove(size - 1);
        fr c = m4742c(view);
        c.f2315e = null;
        if (c.m4358c() || c.m4359d()) {
            this.f2335c -= this.f2337e.f1837a.mo735c(view);
        }
        if (size == 1) {
            this.f2333a = Integer.MIN_VALUE;
        }
        this.f2334b = Integer.MIN_VALUE;
    }

    void m4750h() {
        View view = (View) this.f2338f.remove(0);
        fr c = m4742c(view);
        c.f2315e = null;
        if (this.f2338f.size() == 0) {
            this.f2334b = Integer.MIN_VALUE;
        }
        if (c.m4358c() || c.m4359d()) {
            this.f2335c -= this.f2337e.f1837a.mo735c(view);
        }
        this.f2333a = Integer.MIN_VALUE;
    }

    public int m4751i() {
        return this.f2335c;
    }
}
