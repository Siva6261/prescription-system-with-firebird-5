package android.support.v7.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

class C0347w extends BaseAdapter {
    final /* synthetic */ C0346v f1663a;
    private C0329i f1664b;
    private int f1665c = -1;

    public C0347w(C0346v c0346v, C0329i c0329i) {
        this.f1663a = c0346v;
        this.f1664b = c0329i;
        m3518a();
    }

    public C0337m m3517a(int i) {
        ArrayList l = this.f1663a.f1651g ? this.f1664b.m3378l() : this.f1664b.m3375i();
        if (this.f1665c >= 0 && i >= this.f1665c) {
            i++;
        }
        return (C0337m) l.get(i);
    }

    void m3518a() {
        C0337m r = this.f1663a.f1649e.m3384r();
        if (r != null) {
            ArrayList l = this.f1663a.f1649e.m3378l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                if (((C0337m) l.get(i)) == r) {
                    this.f1665c = i;
                    return;
                }
            }
        }
        this.f1665c = -1;
    }

    public int getCount() {
        ArrayList l = this.f1663a.f1651g ? this.f1664b.m3378l() : this.f1664b.m3375i();
        return this.f1665c < 0 ? l.size() : l.size() - 1;
    }

    public /* synthetic */ Object getItem(int i) {
        return m3517a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? this.f1663a.f1648d.inflate(C0346v.f1645a, viewGroup, false) : view;
        aa aaVar = (aa) inflate;
        if (this.f1663a.f1646b) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        aaVar.mo24a(m3517a(i), 0);
        return inflate;
    }

    public void notifyDataSetChanged() {
        m3518a();
        super.notifyDataSetChanged();
    }
}
