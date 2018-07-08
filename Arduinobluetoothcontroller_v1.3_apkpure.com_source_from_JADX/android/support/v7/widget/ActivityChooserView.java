package android.support.v7.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0227n;
import android.support.v7.p018b.C0306j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;

public class ActivityChooserView extends ViewGroup {
    C0227n f1736a;
    private final ag f1737b;
    private final ah f1738c;
    private final cq f1739d;
    private final FrameLayout f1740e;
    private final ImageView f1741f;
    private final FrameLayout f1742g;
    private final int f1743h;
    private final DataSetObserver f1744i;
    private final OnGlobalLayoutListener f1745j;
    private cx f1746k;
    private OnDismissListener f1747l;
    private boolean f1748m;
    private int f1749n;
    private boolean f1750o;
    private int f1751p;

    public class InnerLayout extends cq {
        private static final int[] f1735a = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            gf a = gf.m4786a(context, attributeSet, f1735a);
            setBackgroundDrawable(a.m4790a(0));
            a.m4791a();
        }
    }

    private void m3594a(int i) {
        if (this.f1737b.m4018d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1745j);
        boolean z = this.f1742g.getVisibility() == 0;
        int c = this.f1737b.m4017c();
        int i2 = z ? 1 : 0;
        if (i == Integer.MAX_VALUE || c <= i2 + i) {
            this.f1737b.m4014a(false);
            this.f1737b.m4012a(i);
        } else {
            this.f1737b.m4014a(true);
            this.f1737b.m4012a(i - 1);
        }
        cx listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.m4162k()) {
            if (this.f1748m || !z) {
                this.f1737b.m4015a(true, z);
            } else {
                this.f1737b.m4015a(false, false);
            }
            listPopupWindow.m4155f(Math.min(this.f1737b.m4011a(), this.f1743h));
            listPopupWindow.mo707c();
            if (this.f1736a != null) {
                this.f1736a.m2501a(true);
            }
            listPopupWindow.m4164m().setContentDescription(getContext().getString(C0306j.abc_activitychooserview_choose_application));
        }
    }

    private cx getListPopupWindow() {
        if (this.f1746k == null) {
            this.f1746k = new cx(getContext());
            this.f1746k.mo705a(this.f1737b);
            this.f1746k.m4142a((View) this);
            this.f1746k.m4146a(true);
            this.f1746k.m4143a(this.f1738c);
            this.f1746k.m4145a(this.f1738c);
        }
        return this.f1746k;
    }

    public boolean m3603a() {
        if (m3605c() || !this.f1750o) {
            return false;
        }
        this.f1748m = false;
        m3594a(this.f1749n);
        return true;
    }

    public boolean m3604b() {
        if (m3605c()) {
            getListPopupWindow().m4160i();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f1745j);
            }
        }
        return true;
    }

    public boolean m3605c() {
        return getListPopupWindow().m4162k();
    }

    public C0372z getDataModel() {
        return this.f1737b.m4018d();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0372z d = this.f1737b.m4018d();
        if (d != null) {
            d.registerObserver(this.f1744i);
        }
        this.f1750o = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0372z d = this.f1737b.m4018d();
        if (d != null) {
            d.unregisterObserver(this.f1744i);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1745j);
        }
        if (m3605c()) {
            m3604b();
        }
        this.f1750o = false;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1739d.layout(0, 0, i3 - i, i4 - i2);
        if (!m3605c()) {
            m3604b();
        }
    }

    protected void onMeasure(int i, int i2) {
        View view = this.f1739d;
        if (this.f1742g.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(C0372z c0372z) {
        this.f1737b.m4013a(c0372z);
        if (m3605c()) {
            m3604b();
            m3603a();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f1751p = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1741f.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1741f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.f1749n = i;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f1747l = onDismissListener;
    }

    public void setProvider(C0227n c0227n) {
        this.f1736a = c0227n;
    }
}
