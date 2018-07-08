package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0301e;
import android.support.v7.p018b.C0305i;
import android.support.v7.widget.cx;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

public class C0346v implements C0332x, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int f1645a = C0305i.abc_popup_menu_item_layout;
    boolean f1646b;
    private final Context f1647c;
    private final LayoutInflater f1648d;
    private final C0329i f1649e;
    private final C0347w f1650f;
    private final boolean f1651g;
    private final int f1652h;
    private final int f1653i;
    private final int f1654j;
    private View f1655k;
    private cx f1656l;
    private ViewTreeObserver f1657m;
    private C0273y f1658n;
    private ViewGroup f1659o;
    private boolean f1660p;
    private int f1661q;
    private int f1662r;

    public C0346v(Context context, C0329i c0329i, View view) {
        this(context, c0329i, view, false, C0298b.popupMenuStyle);
    }

    public C0346v(Context context, C0329i c0329i, View view, boolean z, int i) {
        this(context, c0329i, view, z, i, 0);
    }

    public C0346v(Context context, C0329i c0329i, View view, boolean z, int i, int i2) {
        this.f1662r = 0;
        this.f1647c = context;
        this.f1648d = LayoutInflater.from(context);
        this.f1649e = c0329i;
        this.f1650f = new C0347w(this, this.f1649e);
        this.f1651g = z;
        this.f1653i = i;
        this.f1654j = i2;
        Resources resources = context.getResources();
        this.f1652h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0301e.abc_config_prefDialogWidth));
        this.f1655k = view;
        c0329i.m3352a((C0332x) this, context);
    }

    private int m3499g() {
        ListAdapter listAdapter = this.f1650f;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                i2 = itemViewType;
                view2 = null;
            } else {
                view2 = view;
            }
            if (this.f1659o == null) {
                this.f1659o = new FrameLayout(this.f1647c);
            }
            view = listAdapter.getView(i, view2, this.f1659o);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            itemViewType = view.getMeasuredWidth();
            if (itemViewType >= this.f1652h) {
                return this.f1652h;
            }
            if (itemViewType <= i3) {
                itemViewType = i3;
            }
            i++;
            i3 = itemViewType;
        }
        return i3;
    }

    public void m3500a() {
        if (!m3513d()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void m3501a(int i) {
        this.f1662r = i;
    }

    public void mo608a(Context context, C0329i c0329i) {
    }

    public void mo609a(C0329i c0329i, boolean z) {
        if (c0329i == this.f1649e) {
            m3514e();
            if (this.f1658n != null) {
                this.f1658n.mo518a(c0329i, z);
            }
        }
    }

    public void m3504a(C0273y c0273y) {
        this.f1658n = c0273y;
    }

    public void m3505a(View view) {
        this.f1655k = view;
    }

    public void m3506a(boolean z) {
        this.f1646b = z;
    }

    public boolean mo610a(ad adVar) {
        if (adVar.hasVisibleItems()) {
            boolean z;
            C0346v c0346v = new C0346v(this.f1647c, adVar, this.f1655k);
            c0346v.m3504a(this.f1658n);
            int size = adVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = adVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            c0346v.m3506a(z);
            if (c0346v.m3513d()) {
                if (this.f1658n == null) {
                    return true;
                }
                this.f1658n.mo519a(adVar);
                return true;
            }
        }
        return false;
    }

    public boolean mo611a(C0329i c0329i, C0337m c0337m) {
        return false;
    }

    public void mo612b(boolean z) {
        this.f1660p = false;
        if (this.f1650f != null) {
            this.f1650f.notifyDataSetChanged();
        }
    }

    public boolean mo613b() {
        return false;
    }

    public boolean mo614b(C0329i c0329i, C0337m c0337m) {
        return false;
    }

    public cx m3512c() {
        return this.f1656l;
    }

    public boolean m3513d() {
        boolean z = false;
        this.f1656l = new cx(this.f1647c, null, this.f1653i, this.f1654j);
        this.f1656l.m4145a((OnDismissListener) this);
        this.f1656l.m4143a((OnItemClickListener) this);
        this.f1656l.mo705a(this.f1650f);
        this.f1656l.m4146a(true);
        View view = this.f1655k;
        if (view == null) {
            return false;
        }
        if (this.f1657m == null) {
            z = true;
        }
        this.f1657m = view.getViewTreeObserver();
        if (z) {
            this.f1657m.addOnGlobalLayoutListener(this);
        }
        this.f1656l.m4142a(view);
        this.f1656l.m4151d(this.f1662r);
        if (!this.f1660p) {
            this.f1661q = m3499g();
            this.f1660p = true;
        }
        this.f1656l.m4155f(this.f1661q);
        this.f1656l.m4157g(2);
        this.f1656l.mo707c();
        this.f1656l.m4164m().setOnKeyListener(this);
        return true;
    }

    public void m3514e() {
        if (m3515f()) {
            this.f1656l.m4160i();
        }
    }

    public boolean m3515f() {
        return this.f1656l != null && this.f1656l.m4162k();
    }

    public void onDismiss() {
        this.f1656l = null;
        this.f1649e.close();
        if (this.f1657m != null) {
            if (!this.f1657m.isAlive()) {
                this.f1657m = this.f1655k.getViewTreeObserver();
            }
            this.f1657m.removeGlobalOnLayoutListener(this);
            this.f1657m = null;
        }
    }

    public void onGlobalLayout() {
        if (m3515f()) {
            View view = this.f1655k;
            if (view == null || !view.isShown()) {
                m3514e();
            } else if (m3515f()) {
                this.f1656l.mo707c();
            }
        }
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C0347w c0347w = this.f1650f;
        c0347w.f1664b.m3357a(c0347w.m3517a(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        m3514e();
        return true;
    }
}
