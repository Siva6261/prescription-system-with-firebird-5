package android.support.v7.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class C0335h extends BaseAdapter {
    final /* synthetic */ C0334g f1604a;
    private int f1605b = -1;

    public C0335h(C0334g c0334g) {
        this.f1604a = c0334g;
        m3446a();
    }

    public C0337m m3445a(int i) {
        ArrayList l = this.f1604a.f1597c.m3378l();
        int a = this.f1604a.f1602h + i;
        if (this.f1605b >= 0 && a >= this.f1605b) {
            a++;
        }
        return (C0337m) l.get(a);
    }

    void m3446a() {
        C0337m r = this.f1604a.f1597c.m3384r();
        if (r != null) {
            ArrayList l = this.f1604a.f1597c.m3378l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (((C0337m) l.get(i)) == r) {
                    this.f1605b = i;
                    return;
                }
            }
        }
        this.f1605b = -1;
    }

    public int getCount() {
        int size = this.f1604a.f1597c.m3378l().size() - this.f1604a.f1602h;
        return this.f1605b < 0 ? size : size - 1;
    }

    public /* synthetic */ Object getItem(int i) {
        return m3445a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.f1604a.f1596b.inflate(this.f1604a.f1600f, viewGroup, false) : view;
        ((aa) inflate).mo24a(m3445a(i), 0);
        return inflate;
    }

    public void notifyDataSetChanged() {
        m3446a();
        super.notifyDataSetChanged();
    }
}
