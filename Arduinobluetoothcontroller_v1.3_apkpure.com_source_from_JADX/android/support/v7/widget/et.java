package android.support.v7.widget;

import android.util.Log;
import android.view.View;

public abstract class et {
    private int f2222a;
    private RecyclerView f2223b;
    private eh f2224c;
    private boolean f2225d;
    private boolean f2226e;
    private View f2227f;
    private final eu f2228g;

    private void m4572a(int i, int i2) {
        RecyclerView recyclerView = this.f2223b;
        if (!this.f2226e || this.f2222a == -1 || recyclerView == null) {
            m4575a();
        }
        this.f2225d = false;
        if (this.f2227f != null) {
            if (m4574a(this.f2227f) == this.f2222a) {
                m4578a(this.f2227f, recyclerView.f148g, this.f2228g);
                this.f2228g.m4584a(recyclerView);
                m4575a();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.f2227f = null;
            }
        }
        if (this.f2226e) {
            m4577a(i, i2, recyclerView.f148g, this.f2228g);
            boolean a = this.f2228g.m4587a();
            this.f2228g.m4584a(recyclerView);
            if (!a) {
                return;
            }
            if (this.f2226e) {
                this.f2225d = true;
                recyclerView.ab.m4616a();
                return;
            }
            m4575a();
        }
    }

    public int m4574a(View view) {
        return this.f2223b.m200d(view);
    }

    protected final void m4575a() {
        if (this.f2226e) {
            m4583e();
            this.f2223b.f148g.f2237b = -1;
            this.f2227f = null;
            this.f2222a = -1;
            this.f2225d = false;
            this.f2226e = false;
            this.f2224c.m3613a(this);
            this.f2224c = null;
            this.f2223b = null;
        }
    }

    public void m4576a(int i) {
        this.f2222a = i;
    }

    protected abstract void m4577a(int i, int i2, ev evVar, eu euVar);

    protected abstract void m4578a(View view, ev evVar, eu euVar);

    protected void m4579b(View view) {
        if (m4574a(view) == m4582d()) {
            this.f2227f = view;
        }
    }

    public boolean m4580b() {
        return this.f2225d;
    }

    public boolean m4581c() {
        return this.f2226e;
    }

    public int m4582d() {
        return this.f2222a;
    }

    protected abstract void m4583e();
}
