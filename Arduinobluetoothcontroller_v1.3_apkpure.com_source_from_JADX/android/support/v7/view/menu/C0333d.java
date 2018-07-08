package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.bv;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class C0333d implements C0332x {
    protected Context f1585a;
    protected Context f1586b;
    protected C0329i f1587c;
    protected LayoutInflater f1588d;
    protected LayoutInflater f1589e;
    protected C0030z f1590f;
    private C0273y f1591g;
    private int f1592h;
    private int f1593i;
    private int f1594j;

    public C0333d(Context context, int i, int i2) {
        this.f1585a = context;
        this.f1588d = LayoutInflater.from(context);
        this.f1592h = i;
        this.f1593i = i2;
    }

    public C0273y m3417a() {
        return this.f1591g;
    }

    public C0030z mo807a(ViewGroup viewGroup) {
        if (this.f1590f == null) {
            this.f1590f = (C0030z) this.f1588d.inflate(this.f1592h, viewGroup, false);
            this.f1590f.mo34a(this.f1587c);
            mo612b(true);
        }
        return this.f1590f;
    }

    public View mo808a(C0337m c0337m, View view, ViewGroup viewGroup) {
        aa b = view instanceof aa ? (aa) view : m3430b(viewGroup);
        mo809a(c0337m, b);
        return (View) b;
    }

    public void m3420a(int i) {
        this.f1594j = i;
    }

    public void mo608a(Context context, C0329i c0329i) {
        this.f1586b = context;
        this.f1589e = LayoutInflater.from(this.f1586b);
        this.f1587c = c0329i;
    }

    public void mo609a(C0329i c0329i, boolean z) {
        if (this.f1591g != null) {
            this.f1591g.mo518a(c0329i, z);
        }
    }

    public abstract void mo809a(C0337m c0337m, aa aaVar);

    public void m3424a(C0273y c0273y) {
        this.f1591g = c0273y;
    }

    protected void m3425a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1590f).addView(view, i);
    }

    public boolean mo811a(int i, C0337m c0337m) {
        return true;
    }

    public boolean mo610a(ad adVar) {
        return this.f1591g != null ? this.f1591g.mo519a(adVar) : false;
    }

    public boolean mo611a(C0329i c0329i, C0337m c0337m) {
        return false;
    }

    protected boolean mo812a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public aa m3430b(ViewGroup viewGroup) {
        return (aa) this.f1588d.inflate(this.f1593i, viewGroup, false);
    }

    public void mo612b(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f1590f;
        if (viewGroup != null) {
            int i;
            if (this.f1587c != null) {
                this.f1587c.m3376j();
                ArrayList i2 = this.f1587c.m3375i();
                int size = i2.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    int i4;
                    C0337m c0337m = (C0337m) i2.get(i3);
                    if (mo811a(i, c0337m)) {
                        View childAt = viewGroup.getChildAt(i);
                        C0337m itemData = childAt instanceof aa ? ((aa) childAt).getItemData() : null;
                        View a = mo808a(c0337m, childAt, viewGroup);
                        if (c0337m != itemData) {
                            a.setPressed(false);
                            bv.m2044u(a);
                        }
                        if (a != childAt) {
                            m3425a(a, i);
                        }
                        i4 = i + 1;
                    } else {
                        i4 = i;
                    }
                    i3++;
                    i = i4;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo812a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    public boolean mo613b() {
        return false;
    }

    public boolean mo614b(C0329i c0329i, C0337m c0337m) {
        return false;
    }
}
