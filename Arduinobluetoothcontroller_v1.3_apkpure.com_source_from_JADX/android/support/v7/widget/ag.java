package android.support.v7.widget;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.view.bv;
import android.support.v7.p018b.C0303g;
import android.support.v7.p018b.C0305i;
import android.support.v7.p018b.C0306j;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class ag extends BaseAdapter {
    final /* synthetic */ ActivityChooserView f1911a;
    private C0372z f1912b;
    private int f1913c;
    private boolean f1914d;
    private boolean f1915e;
    private boolean f1916f;

    public int m4011a() {
        int i = 0;
        int i2 = this.f1913c;
        this.f1913c = Integer.MAX_VALUE;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = getCount();
        View view = null;
        int i3 = 0;
        while (i < count) {
            view = getView(i, view, null);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
        }
        this.f1913c = i2;
        return i3;
    }

    public void m4012a(int i) {
        if (this.f1913c != i) {
            this.f1913c = i;
            notifyDataSetChanged();
        }
    }

    public void m4013a(C0372z c0372z) {
        C0372z d = this.f1911a.f1737b.m4018d();
        if (d != null && this.f1911a.isShown()) {
            d.unregisterObserver(this.f1911a.f1744i);
        }
        this.f1912b = c0372z;
        if (c0372z != null && this.f1911a.isShown()) {
            c0372z.registerObserver(this.f1911a.f1744i);
        }
        notifyDataSetChanged();
    }

    public void m4014a(boolean z) {
        if (this.f1916f != z) {
            this.f1916f = z;
            notifyDataSetChanged();
        }
    }

    public void m4015a(boolean z, boolean z2) {
        if (this.f1914d != z || this.f1915e != z2) {
            this.f1914d = z;
            this.f1915e = z2;
            notifyDataSetChanged();
        }
    }

    public ResolveInfo m4016b() {
        return this.f1912b.m4957b();
    }

    public int m4017c() {
        return this.f1912b.m4953a();
    }

    public C0372z m4018d() {
        return this.f1912b;
    }

    public boolean m4019e() {
        return this.f1914d;
    }

    public int getCount() {
        int a = this.f1912b.m4953a();
        if (!(this.f1914d || this.f1912b.m4957b() == null)) {
            a--;
        }
        a = Math.min(a, this.f1913c);
        return this.f1916f ? a + 1 : a;
    }

    public Object getItem(int i) {
        switch (getItemViewType(i)) {
            case 0:
                if (!(this.f1914d || this.f1912b.m4957b() == null)) {
                    i++;
                }
                return this.f1912b.m4955a(i);
            case 1:
                return null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return (this.f1916f && i == getCount() - 1) ? 1 : 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || view.getId() != C0303g.list_item) {
                    view = LayoutInflater.from(this.f1911a.getContext()).inflate(C0305i.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = this.f1911a.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                ((ImageView) view.findViewById(C0303g.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(C0303g.title)).setText(resolveInfo.loadLabel(packageManager));
                if (this.f1914d && i == 0 && this.f1915e) {
                    bv.m2021c(view, true);
                    return view;
                }
                bv.m2021c(view, false);
                return view;
            case 1:
                if (view != null && view.getId() == 1) {
                    return view;
                }
                view = LayoutInflater.from(this.f1911a.getContext()).inflate(C0305i.abc_activity_chooser_view_list_item, viewGroup, false);
                view.setId(1);
                ((TextView) view.findViewById(C0303g.title)).setText(this.f1911a.getContext().getString(C0306j.abc_activity_chooser_view_see_all));
                return view;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int getViewTypeCount() {
        return 3;
    }
}
