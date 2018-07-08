package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.widget.gf;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements C0325k, C0030z, OnItemClickListener {
    private static final int[] f1512a = new int[]{16842964, 16843049};
    private C0329i f1513b;
    private int f1514c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        gf a = gf.m4787a(context, attributeSet, f1512a, i, 0);
        if (a.m4802f(0)) {
            setBackgroundDrawable(a.m4790a(0));
        }
        if (a.m4802f(1)) {
            setDivider(a.m4790a(1));
        }
        a.m4791a();
    }

    public void mo34a(C0329i c0329i) {
        this.f1513b = c0329i;
    }

    public boolean mo585a(C0337m c0337m) {
        return this.f1513b.m3357a((MenuItem) c0337m, 0);
    }

    public int getWindowAnimations() {
        return this.f1514c;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo585a((C0337m) getAdapter().getItem(i));
    }
}
