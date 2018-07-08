package android.support.v7.widget;

import android.support.v7.p005a.C0279d;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class ff extends BaseAdapter {
    final /* synthetic */ fd f2296a;

    private ff(fd fdVar) {
        this.f2296a = fdVar;
    }

    public int getCount() {
        return this.f2296a.f2289e.getChildCount();
    }

    public Object getItem(int i) {
        return ((fh) this.f2296a.f2289e.getChildAt(i)).m4698b();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return this.f2296a.m4689a((C0279d) getItem(i), true);
        }
        ((fh) view).m4697a((C0279d) getItem(i));
        return view;
    }
}
